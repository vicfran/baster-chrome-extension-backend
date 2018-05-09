package baster

import model.Profile
import model.ProfileEntity
import org.jsoup.Jsoup

class Scraper {

    fun scrap(profileEntity: ProfileEntity): Profile {
        val document = Jsoup.parse(profileEntity.body)
        val name = document.select("h1.pv-top-card-section__name").text()
        return Profile(name)
    }

}