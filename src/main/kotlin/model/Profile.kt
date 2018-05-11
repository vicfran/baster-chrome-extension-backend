package model

data class Profile(
        val name: String = "",
        val position: String = "",
        val company: String = "",
        val location: String = "",
        val experiences: List<Experience> = emptyList(),
        val aptitudes: List<Aptitude> = emptyList(),
        val recommendations: String = "")

data class Experience(
        val position: String = "",
        val company: String = "",
        val duration: String = "",
        val location: String = "",
        val description: String = ""
)

data class Aptitude(
        val name: String = "",
        val validations: String = ""
)
