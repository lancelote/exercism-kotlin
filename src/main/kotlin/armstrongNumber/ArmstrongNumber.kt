package armstrongNumber

object ArmstrongNumber {
    fun check(input: Int): Boolean {
        val numString = input.toString()
        val numLength = numString.length

        return numString
            .map { it.digitToInt() pow numLength }
            .sum() == input
    }

    private infix fun Int.pow(n: Int): Int = if (n == 0) 1 else this * pow(n - 1)
}
