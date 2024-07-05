package armstrongNumber

import kotlin.math.pow

object ArmstrongNumber {
    fun check(input: Int): Boolean {
        val numString = input.toString()
        val numLength = numString.length

        return numString
            .map { it.digitToInt().toDouble().pow(numLength) }
            .sum().toInt() == input
    }
}
