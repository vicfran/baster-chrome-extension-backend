package scraper

import model.Experience
import org.jsoup.nodes.Document

class ExperienceScraper: Scraper<Document, List<Experience>> {

    companion object {
        private const val EXPERIENCES_ELEMENT = "li.pv-profile-section__card-item.pv-position-entity"
        private const val POSITION_ELEMENT = "h3"
        private const val COMPANY_ELEMENT = "span.pv-entity__secondary-title"
        private const val DURATION_ELEMENT = ".pv-entity__bullet-item"
        private const val LOCATION_ELEMENT = ".pv-entity__location"
        private const val DESCRIPTION_ELEMENT = "p.pv-entity__description"
    }

    override fun scrap(document: Document): List<Experience> {
        val experiencesEntity = document.select(EXPERIENCES_ELEMENT)
        return experiencesEntity.map {
            val position = it.select(POSITION_ELEMENT).text()
            val company = it.select(COMPANY_ELEMENT).text()
            val duration = it.select(DURATION_ELEMENT).text()
            val location = it.select(LOCATION_ELEMENT).text()
            val description = it.select(DESCRIPTION_ELEMENT).text()
            Experience(position, company, duration, location, description)
        }
    }

}