package baster

import model.Experience
import model.Profile

class Parser {

    fun parse(profile: Profile): Profile {
        with (profile) {
            val name = if (name.isNotEmpty()) name.split(" ")[0] else ""
            val position = position.toLowerCase()
            val location = if (location.isNotEmpty()) location.split(" ")[0] else ""
            val experiences = parseExperiences(experiences)
            val recommendations = parseRecommendations(recommendations)

            return Profile(name, position, company, location, experiences, aptitudes, recommendations)
        }
    }

    private fun parseExperiences(experiences: List<Experience>): List<Experience> =
        experiences.map {
            val position = it.position.toLowerCase()
            val location = if (it.location.isNotEmpty()) it.location.split(" ")[1] else ""
            Experience(position, it.company, it.duration, location, it.description)
    }

    private fun parseRecommendations(recommendations: String): String =
            if (recommendations.isNotEmpty()) recommendations.split(" ")[1][1].toString() else ""

}