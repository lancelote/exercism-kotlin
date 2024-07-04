package acronym

object Acronym {
    fun generate(phrase: String) = phrase
        .split(" ", "-", "_")
        .filter { it.isNotEmpty() }
        .map { it.first().uppercaseChar() }
        .joinToString("")
}
