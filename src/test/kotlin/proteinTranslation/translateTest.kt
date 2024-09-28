package proteinTranslation

import java.util.stream.Stream
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.Arguments

class ProteinTranslationTest {
    @Test
    fun emptyRNAHasNoProteins() {
        assertEquals(emptyList(), translate(null))
    }

    @Test
    fun `Sequence of two protein codons translates into proteins`() {
        assertEquals(listOf("Phenylalanine", "Phenylalanine"), translate("UUUUUU"))
    }

    @Test
    fun `Sequence of two different protein codons translates into proteins`() {
        assertEquals(listOf("Leucine", "Leucine"), translate("UUAUUG"))
    }

    @Test
    fun `Translate RNA strand into correct protein list`() {
        assertEquals(listOf("Methionine", "Phenylalanine", "Tryptophan"), translate("AUGUUUUGG"))
    }

    @Test
    fun `Translation stops if STOP codon at beginning of sequence`() {
        assertEquals(emptyList(), translate("UAGUGG"))
    }

    @Test
    fun `Translation stops if STOP codon at end of three-codon sequence`() {
        assertEquals(listOf("Methionine", "Phenylalanine"), translate("AUGUUUUAA"))
    }

    @Test
    fun `Translation stops if STOP codon in middle of three-codon sequence`() {
        assertEquals(listOf("Tryptophan"), translate("UGGUAGUGG"))
    }

    @Test
    fun `Translation stops if STOP codon in middle of six-codon sequence`() {
        assertEquals(listOf("Tryptophan", "Cysteine", "Tyrosine"), translate("UGGUGUUAUUAAUGGUUU"))
    }

    @Test
    fun `Non-existing codon can't translate`() {
        assertFailsWith<IllegalArgumentException>("Invalid codon") {
            translate("AAA")
        }
    }

    @Test
    fun `Unknown amino acids, not part of a codon, can't translate`() {
        assertFailsWith<IllegalArgumentException>("Invalid codon") {
            translate("XYZ")
        }
    }

    @Test
    fun `Incomplete RNA sequence can't translate`() {
        assertFailsWith<IllegalArgumentException>("Invalid codon") {
            translate("AUGU")
        }
    }

    @Test
    fun `Incomplete RNA sequence can translate if valid until a STOP codon`() {
        assertEquals(listOf("Phenylalanine", "Phenylalanine"), translate("UUCUUCUAAUGGU"))
    }
}

class SingleCodonTranslationTest {
    @ParameterizedTest
    @MethodSource("getTestData")
    fun `Protein codon translates into protein`(codons: List<String>, protein: String) {
        codons.forEachIndexed { index, codon ->
            val seq = index + 1
            assertEquals(listOf(protein), translate(codon), "${protein} RNA sequence ${seq} translates into ${protein}")
        }
    }

    companion object {
        @JvmStatic
        fun getTestData(): Stream<Arguments> = Stream.of(
            Arguments.of(listOf("AUG"), "Methionine"),
            Arguments.of(listOf("UUU", "UUC"), "Phenylalanine"),
            Arguments.of(listOf("UUA", "UUG"), "Leucine"),
            Arguments.of(listOf("UCU", "UCC", "UCA", "UCG"), "Serine"),
            Arguments.of(listOf("UAU", "UAC"), "Tyrosine"),
            Arguments.of(listOf("UGU", "UGC"), "Cysteine"),
            Arguments.of(listOf("UGG"), "Tryptophan")
        )
    }
}
