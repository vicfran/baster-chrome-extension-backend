package baster

import model.Profile
import model.ProfileEntity
import org.jsoup.Jsoup
import scraper.AptitudeScraper
import scraper.ExperienceScraper
import scraper.Scraper

class ProfileScraper: Scraper<ProfileEntity, Profile> {

    companion object {
        private const val NAME_ELEMENT = "h1.pv-top-card-section__name"
        private const val JOB_ELEMENT = "h2.pv-top-card-section__headline"
        private const val COMPANY_ELEMENT = "h3.pv-top-card-section__company"
        private const val LOCATION_ELEMENT = "h3.pv-top-card-section__location"
        private const val RECOMMENDATIONS_ELEMENT = "artdeco-tablist"
    }

    override fun scrap(profileEntity: ProfileEntity): Profile {
        val document = Jsoup.parse(profileEntity.body)
        val name = document.select(NAME_ELEMENT).text()
        val job = document.select(JOB_ELEMENT).text()
        val company = document.select(COMPANY_ELEMENT).text()
        val location = document.select(LOCATION_ELEMENT).text()
        val experiences = ExperienceScraper().scrap(document)
        val aptitudes = AptitudeScraper().scrap(document)
        val recommendations = document.select(RECOMMENDATIONS_ELEMENT).elementAtOrNull(0)?.child(0)?.text() ?: ""
        return Profile(name, job, company, location, experiences, aptitudes, recommendations)
    }

}