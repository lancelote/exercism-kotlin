package naturalNumber

enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {
    if (naturalNumber <= 0) throw RuntimeException("a positive number is expected")

    val aliquotSum = (1 until naturalNumber).filter { naturalNumber % it == 0 }.sum()

    return when {
        aliquotSum == naturalNumber -> Classification.PERFECT
        aliquotSum > naturalNumber -> Classification.ABUNDANT
        else -> Classification.DEFICIENT
    }
}
