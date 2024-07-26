package darts

object Darts {
    fun score(x: Number, y: Number): Int {
        val doubleX = x.toDouble()
        val doubleY = y.toDouble()

        val outerRing = 100
        val middleRing = 25
        val innerRing = 1

        val distanceSquared = doubleX * doubleX + doubleY * doubleY

        return when {
            distanceSquared > outerRing -> 0
            distanceSquared > middleRing -> 1
            distanceSquared > innerRing -> 5
            else -> 10
        }
    }
}
