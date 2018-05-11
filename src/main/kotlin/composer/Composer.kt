package baster

import composer.template.Body
import composer.template.Template
import model.Profile

class Composer {

    companion object {
        private const val START = "Hola"

        private const val BODY_1 = "Tu trabajo en"
        private const val BODY_1_1 = "me ha llamado la atención y me gustaría hablar contigo"

        private const val BODY_2 = "Me llama la atención tus conocimientos en"
        private const val BODY_2_1 = "y que incluso"
        private const val BODY_2_2_PLURAL = "personas lo certifican, ¡enhorabuena!"
        private const val BODY_2_2_SINGULAR = "persona lo certifica, ¡enhorabuena!"

        private const val BODY_3 = "Además, me gustaría conocer cómo fue tu experiencia trabajando en"
        private const val BODY_3_1 = "como"

        private const val BODY_4 = "He visto en tu perfil que tienes"
        private const val BODY_4_1 = "recomendaciones, esas personas con las que has trabajado valoran positivamente tu trabajo y eso es algo genial"

        private const val FINAL_1 = "¿Te gustaría hacer un cambio en tu carrera?"
        private const val FINAL_2 = "Dime cuando tengas un momento"

        private const val END = "Muchas gracias"

        private const val SPACE = " "
        private const val DOT = "."
        private const val END_LINE = "\n\n"
    }

    fun compose(profile: Profile): Template {
        val start = composeStart(profile)
        val body = composeBody(profile)
        val end = composeEnd()

        return Template(start, body, end)
    }

    private fun composeStart(profile: Profile): String {
        var start = START + SPACE

        if (profile.hasName()) {
            start += profile.name + END_LINE
        }

        return start
    }

    private fun composeBody(profile: Profile): Body {
        var body = mutableListOf<String>()

        if (profile.hasExperiences()) {
            body.add(BODY_1 + SPACE + profile.experiences[0].company + SPACE + BODY_1_1 + DOT + END_LINE)

            if (profile.experiences.size > 1) {
                val experience = profile.experiences[1]
                body.add(BODY_3 + SPACE + experience.company + SPACE + BODY_3_1 + SPACE + experience.position + DOT + END_LINE)
            }
        }

        if (profile.hasRecommendations()) {
            body.add(BODY_4 + SPACE + profile.recommendations + SPACE + BODY_4_1 + DOT + END_LINE)
        }

        if (profile.hasAptitudes()) {
            val aptitude = profile.aptitudes[0]
            body.add(BODY_2 + SPACE + aptitude.name)
            if (aptitude.hasValidations()) {
                body.add(SPACE + BODY_2_1 + SPACE + aptitude.validations + SPACE)
                body.add(if (aptitude.validations.toInt() > 1) {
                    BODY_2_2_PLURAL
                } else {
                    BODY_2_2_SINGULAR
                })
                body.add(DOT + END_LINE)
            } else {
                body.add(DOT + END_LINE)
            }
        }

        return Body(body)
    }

    private fun composeEnd(): String {
        var end = FINAL_1 + END_LINE

        end += FINAL_2 + DOT + END_LINE

        end += END

        return end
    }

}
