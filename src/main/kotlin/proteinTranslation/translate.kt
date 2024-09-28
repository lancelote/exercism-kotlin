package proteinTranslation

val STOP = setOf("UAA", "UAG", "UGA")
val CODONS = mapOf<String, String>(
    "AUG" to "Methionine",
    "UUU" to "Phenylalanine",
    "UUC" to "Phenylalanine",
    "UUA" to "Leucine",
    "UUG" to "Leucine",
    "UCU" to "Serine",
    "UCC" to "Serine",
    "UCA" to "Serine",
    "UCG" to "Serine",
    "UAU" to "Tyrosine",
    "UAC" to "Tyrosine",
    "UGU" to "Cysteine",
    "UGC" to "Cysteine",
    "UGG" to "Tryptophan",
)

fun translate(rna: String?) = rna
    ?.chunked(3)
    ?.takeWhile { !STOP.contains(it) }
    ?.map { CODONS[it] ?: throw IllegalArgumentException("Invalid codon") }
    ?: emptyList()
