package acronym

object Acronym {
    fun generate(phrase: String): String {
        var wasSeparator = true
        val result: MutableList<Char> = mutableListOf()

        for (x in phrase) {
            if (x.isLetter() && wasSeparator) {
                result.add(x.uppercaseChar())
                wasSeparator = false
            } else if (x == ' ' || x == '-') {
                wasSeparator = true
            }
        }

        return result.joinToString("")
    }
}
