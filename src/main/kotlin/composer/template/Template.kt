package composer.template

data class Template(private var start: String, private var body: Body, private var end: String) {

    fun get(): String = start + body.get() + end

}