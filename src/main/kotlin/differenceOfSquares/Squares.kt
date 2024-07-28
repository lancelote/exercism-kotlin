package differenceOfSquares

class Squares(private val n: Int) {
    fun sumOfSquares() = n * (n + 1) * (2 * n + 1) / 6

    fun squareOfSum() = n * n * (n + 1) * (n + 1) / 4

    fun difference() = squareOfSum() - sumOfSquares()
}
