package darts

import kotlin.math.sqrt

object Darts {
    fun score(x: Number, y: Number): Int {
        val floatX = x.toFloat()
        val floatY = y.toFloat()

        val distance = sqrt(floatX * floatX + floatY * floatY)

        return when {
            distance > 10 -> 0
            distance > 5 -> 1
            distance > 1 -> 5
            else -> 10
        }
    }
}
