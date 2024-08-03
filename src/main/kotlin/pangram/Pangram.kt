package pangram

object Pangram {
    fun isPangram(input: String): Boolean {
        return input
            .filter { it.isLetter() }
            .map { it.lowercaseChar() }
            .toSet()
            .size == 26
    }
}
