package pangram

object Pangram {
    fun isPangram(input: String) = input
            .filter { it.isLetter() }
            .map { it.lowercaseChar() }
            .toSet()
            .size == 26
}
