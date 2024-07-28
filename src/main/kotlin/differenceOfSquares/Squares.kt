package differenceOfSquares

class Squares(private val n: Int) {
    fun sumOfSquares() = (1..n).sumOf { it * it }

    fun squareOfSum(): Int {
        val sum = (1..n).sum()
        return sum * sum
    }

    fun difference() = squareOfSum() - sumOfSquares()
}
