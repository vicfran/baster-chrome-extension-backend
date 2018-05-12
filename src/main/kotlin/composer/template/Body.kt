package composer.template

data class Body(val parts: List<String>) {

    fun get(): String = parts.joinToString("")

}