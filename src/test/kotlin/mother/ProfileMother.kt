package baster

import model.Aptitude
import model.Experience
import model.Profile
class ProfileMother {

    companion object {
        private const val NAME = "Victor"
        private const val POSITION = "senior android engineer"
        private const val COMPANY = "idealista"
        private const val LOCATION = "Madrid"
        private const val RECOMMENDATIONS = "4"
    }

    fun getFullProfile(): Profile =
            Profile(
                    NAME,
                    POSITION,
                    COMPANY,
                    LOCATION,
                    getExperiences(),
                    getAptitudes(),
                    RECOMMENDATIONS
            )

    fun getProfileWithOneExperience(): Profile =
            Profile(
                    NAME,
                    POSITION,
                    COMPANY,
                    LOCATION,
                    getExperience(),
                    getAptitudes(),
                    RECOMMENDATIONS
            )

    fun getProfileWithoutExperiences(): Profile =
            Profile(
                    NAME,
                    POSITION,
                    COMPANY,
                    LOCATION,
                    emptyList(),
                    getAptitudes(),
                    RECOMMENDATIONS
            )

    fun getProfileWithoutAptitudes(): Profile =
            Profile(
                    NAME,
                    POSITION,
                    COMPANY,
                    LOCATION,
                    getExperience(),
                    emptyList(),
                    RECOMMENDATIONS
            )

    fun getProfileWithoutRecommendations(): Profile =
            Profile(
                    NAME,
                    POSITION,
                    COMPANY,
                    LOCATION,
                    getExperience(),
                    getAptitudes()
            )

    fun getProfileWithoutAptitudesNorRecommendations(): Profile =
            Profile(
                    NAME,
                    POSITION,
                    COMPANY,
                    LOCATION,
                    getExperience()
            )


    private fun getExperience(): List<Experience> =
            listOf(ExperienceMother().getExperience())

    private fun getExperiences(): List<Experience> {
        val experienceMother = ExperienceMother()
        return listOf(
                experienceMother.getExperience(),
                experienceMother.getAnotherExperience())
    }

    private fun getAptitudes(): List<Aptitude> =
            listOf(AptitudeMother().getAptitude())

}

