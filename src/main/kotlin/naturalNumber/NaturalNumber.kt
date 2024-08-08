package naturalNumber

import kotlin.math.sqrt

enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {
    if (naturalNumber == 1) return Classification.DEFICIENT
    require(naturalNumber > 0) { throw RuntimeException("a positive number is expected") }

    val topSearchBound = sqrt(naturalNumber.toDouble()).toInt()
    val aliquotSum = 1 + (2..topSearchBound)
        .sumOf { d1 ->
            if (naturalNumber % d1 != 0) {
                0
            } else {
                val d2 = naturalNumber / d1
                if (d1 == d2) d1 else (d1 + d2)
            }
        }

    return when {
        aliquotSum == naturalNumber -> Classification.PERFECT
        aliquotSum > naturalNumber -> Classification.ABUNDANT
        else -> Classification.DEFICIENT
    }
}
