package scraper

interface Scraper<in T, out S> {

    fun scrap(data: T): S

}