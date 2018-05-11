package scraper

import model.Aptitude
import org.jsoup.nodes.Document

class AptitudeScraper : Scraper<Document, List<Aptitude>> {

    companion object {
        private val APTITUDES_ELEMENT = ".pv-skill-category-entity__top-skill"
        private val NAME_ELEMENT = ".pv-skill-category-entity__name"
        private val VALIDATIONS_ELEMENT = ".pv-skill-category-entity__endorsement-count"
    }

    override fun scrap(document: Document): List<Aptitude> {
        val aptitudesEntity = document.select(APTITUDES_ELEMENT)
        return aptitudesEntity.map {
            val name = it.select(NAME_ELEMENT).text()
            val validations = it.select(VALIDATIONS_ELEMENT).text()
            Aptitude(name, validations)
        }
    }

}