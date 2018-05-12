package baster

import composer.template.Body
import composer.template.Template

class TemplatesMother {

    fun getFullProfileTemplate(): Template =
            Template(
                    "Hola Victor\n\n",
                    Body(listOf(
                            "Tu trabajo en idealista me ha llamado la atención y me gustaría hablar contigo.\n\n",
                            "Además, me gustaría conocer cómo fue tu experiencia trabajando en Blackphone como android engineer.\n\n",
                            "He visto en tu perfil que tienes 4 recomendaciones, esas personas con las que has trabajado valoran positivamente tu trabajo y eso es algo genial.\n\n",
                            "Me llama la atención tus conocimientos en Android",
                            " y que incluso 48 ",
                            "personas lo certifican, ¡enhorabuena!",
                            ".\n\n"
                    )),
                    "¿Te gustaría hacer un cambio en tu carrera?\n\nDime cuando tengas un momento.\n\nMuchas gracias"
            )

    fun getProfileWithOneExperienceTemplate(): Template =
            Template(
                    "Hola Victor\n\n",
                    Body(listOf(
                            "Tu trabajo en idealista me ha llamado la atención y me gustaría hablar contigo.\n\n",
                            "He visto en tu perfil que tienes 4 recomendaciones, esas personas con las que has trabajado valoran positivamente tu trabajo y eso es algo genial.\n\n",
                            "Me llama la atención tus conocimientos en Android",
                            " y que incluso 48 ",
                            "personas lo certifican, ¡enhorabuena!",
                            ".\n\n"
                    )),
                    "¿Te gustaría hacer un cambio en tu carrera?\n\nDime cuando tengas un momento.\n\nMuchas gracias"
            )

    fun getProfileWithoutExperiencesTemplate(): Template =
            Template(
                    "Hola Victor\n\n",
                    Body(listOf(
                            "He visto en tu perfil que tienes 4 recomendaciones, esas personas con las que has trabajado valoran positivamente tu trabajo y eso es algo genial.\n\n",
                            "Me llama la atención tus conocimientos en Android",
                            " y que incluso 48 ",
                            "personas lo certifican, ¡enhorabuena!",
                            ".\n\n"
                    )),
                    "¿Te gustaría hacer un cambio en tu carrera?\n\nDime cuando tengas un momento.\n\nMuchas gracias"
            )

    fun getProfileWithoutAptitudesTemplate(): Template =
            Template(
                    "Hola Victor\n\n",
                    Body(listOf(
                            "Tu trabajo en idealista me ha llamado la atención y me gustaría hablar contigo.\n\n",
                            "He visto en tu perfil que tienes 4 recomendaciones, esas personas con las que has trabajado valoran positivamente tu trabajo y eso es algo genial.\n\n"
                    )),
                    "¿Te gustaría hacer un cambio en tu carrera?\n\nDime cuando tengas un momento.\n\nMuchas gracias"
            )

    fun getProfileWithoutRecommendationsTemplate(): Template =
            Template(
                    "Hola Victor\n\n",
                    Body(listOf(
                            "Tu trabajo en idealista me ha llamado la atención y me gustaría hablar contigo.\n\n",
                            "Me llama la atención tus conocimientos en Android",
                            " y que incluso 48 ",
                            "personas lo certifican, ¡enhorabuena!",
                            ".\n\n"
                    )),
                    "¿Te gustaría hacer un cambio en tu carrera?\n\nDime cuando tengas un momento.\n\nMuchas gracias"
            )

    fun getProfileWithoutAptitudesNorRecommendationsTemplate(): Template =
            Template(
                    "Hola Victor\n\n",
                    Body(listOf(
                            "Tu trabajo en idealista me ha llamado la atención y me gustaría hablar contigo.\n\n"
                    )),
                    "¿Te gustaría hacer un cambio en tu carrera?\n\nDime cuando tengas un momento.\n\nMuchas gracias"
            )


}