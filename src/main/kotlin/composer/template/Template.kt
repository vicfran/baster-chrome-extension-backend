package composer.template

data class Template(val start: String, val body: Body, val end: String) {

    fun get(): String = start + body.get() + end

}