package cryptoSquare

import kotlin.math.sqrt
import kotlin.math.ceil

object CryptoSquare {

    fun ciphertext(plaintext: String) = plaintext.normalize().encode()

    private fun String.normalize() = this.lowercase().filter { it.isLetterOrDigit() }

    private fun String.encode(): String {
        val (cols, rows) = this.dimensions()
        val result: MutableList<String> = mutableListOf()

        for (c in 0 until cols) {
            var line = ""
            for (r in 0 until rows) {
                line += this.elementAtOrNull(c + (r * cols)) ?: " "
            }
            result.add(line)
        }

        return result.joinToString(" ")
    }

    private fun String.dimensions(): Pair<Int, Int> {
        val root = sqrt(this.length.toDouble())
        val cols = ceil(root).toInt()
        val rows = if (cols == 0) 0 else ceil(this.length.toDouble() / cols).toInt()
        return Pair(cols, rows)
    }
}
