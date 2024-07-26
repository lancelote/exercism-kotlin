package darts

import kotlin.math.sqrt

object Darts {
    fun score(x: Number, y: Number): Int {
        val floatX = x.toDouble()
        val floatY = y.toDouble()

        val distance = sqrt(floatX * floatX + floatY * floatY)

        return when {
            distance > 10 -> 0
            distance > 5 -> 1
            distance > 1 -> 5
            else -> 10
        }
    }
}
