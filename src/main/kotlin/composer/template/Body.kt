package composer.template

data class Body(private var parts: List<String>) {

    fun get(): String = parts.joinToString("")

}