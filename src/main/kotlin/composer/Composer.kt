package baster

import model.Profile

class Composer {

    companion object {
        private const val START = "Hola"
        private const val INTRO_1 = "Tu trabajo en"
        private const val INTRO_1_1 = "me ha llamado la atención y me gustaría hablar contigo"
        private const val INTRO_2 = "Me llama la atención tus conocimientos en"
        private const val INTRO_2_1 = "y que incluso"
        private const val INTRO_2_2_PLURAL = "personas lo certifican, ¡enhorabuena!"
        private const val INTRO_2_2_SINGULAR = "persona lo certifica, ¡enhorabuena!"
        private const val INTRO_3 = "Además, me gustaría conocer cómo fue tu experiencia trabajando en"
        private const val INTRO_3_1 = "como"
        private const val INTRO_4 = "He visto en tu perfil que tienes"
        private const val INTRO_4_1 = "recomendaciones, esas personas con las que has trabajado valoran positivamente tu trabajo y eso es algo genial"
        private const val BODY_1 = "Es posible que hayas notado mi interés en tu perfil"
        private const val BODY_2 = "¿Te gustaría hacer un cambio en tu carrera?"
        private const val BODY_3 = "¿Te gustaría saber un poco más sobre el puesto?"
        private const val FINAL_1 = "Si el momento no es adecuado lo entendería perfectamente"
        private const val FINAL_2 = "Dime cuando tengas un momento"
        private const val END = "Muchas gracias"

        private const val SPACE = " "
        private const val DOT = "."
        private const val END_LINE = "\n\n"
    }

    fun compose(profile: Profile): String {
        var template = START + SPACE

        if (profile.hasName()) {
            template += profile.name + END_LINE
        }

        if (profile.hasExperiences()) {
            template += INTRO_1 + SPACE + profile.experiences[0].company + SPACE + INTRO_1_1 + DOT + END_LINE

            if (profile.experiences.size > 1) {
                val experience = profile.experiences[1]
                template += INTRO_3 + SPACE + experience.company + SPACE + INTRO_3_1 + SPACE + experience.position + DOT + END_LINE
            }
        }

        if (profile.hasRecommendations()) {
            template += INTRO_4 + SPACE + profile.recommendations + SPACE + INTRO_4_1 + DOT + END_LINE
        }

        if (profile.hasAptitudes()) {
            val aptitude = profile.aptitudes[0]
            template += INTRO_2 + SPACE + aptitude.name
            if (aptitude.hasValidations()) {
                template += SPACE + INTRO_2_1 + SPACE + aptitude.validations + SPACE
                template += if (aptitude.validations.toInt() > 1) {
                    INTRO_2_2_PLURAL
                } else {
                    INTRO_2_2_SINGULAR
                }
                template += DOT + END_LINE
            } else {
                template += DOT + END_LINE
            }
        }

        template += BODY_2 + END_LINE

        template += FINAL_2 + DOT + END_LINE

        template += END

        return template
    }

}
