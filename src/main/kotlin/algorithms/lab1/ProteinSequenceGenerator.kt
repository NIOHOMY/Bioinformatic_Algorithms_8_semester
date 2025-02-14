package labs.com.algorithms.lab1

class ProteinSequenceGenerator {

    private val codonTable = mapOf(
        "UUU" to "F",    "CUU" to "L", "AUU" to "I", "GUU" to "V",
        "UUC" to "F",    "CUC" to "L", "AUC" to "I", "GUC" to "V",
        "UUA" to "L",    "CUA" to "L", "AUA" to "I", "GUA" to "V",
        "UUG" to "L",    "CUG" to "L", "AUG" to "M", "GUG" to "V",

        "UCU" to "S",    "CCU" to "P", "ACU" to "T", "GCU" to "A",
        "UCC" to "S",    "CCC" to "P", "ACC" to "T", "GCC" to "A",
        "UCA" to "S",    "CCA" to "P", "ACA" to "T", "GCA" to "A",
        "UCG" to "S",    "CCG" to "P", "ACG" to "T", "GCG" to "A",

        "UAU" to "Y",    "CAU" to "H", "AAU" to "N", "GAU" to "D",
        "UAC" to "Y",    "CAC" to "H", "AAC" to "N", "GAC" to "D",
        "UAA" to " Stop", "CAA" to "Q", "AAA" to "K", "GAA" to "E",
        "UAG" to " Stop", "CAG" to "Q", "AAG" to "K", "GAG" to "E",

        "UGU" to "C",    "CGU" to "R", "AGU" to "S", "GGU" to "G",
        "UGC" to "C",    "CGC" to "R", "AGC" to "S", "GGC" to "G",
        "UGA" to " Stop", "CGA" to "R", "AGA" to "R", "GGA" to "G",
        "UGG" to "W",    "CGG" to "R", "AGG" to "R", "GGG" to "G"
    )

    fun generateProteinSequence(rnaSequence: String): String {
        val proteinSequence = StringBuilder()
        for (i in 0 until rnaSequence.length step 3) {
            if (i + 3 <= rnaSequence.length) {
                val codon = rnaSequence.substring(i, i + 3)
                val aminoAcid = codonTable[codon] ?: throw IllegalArgumentException("Invalid codon: $codon")
                proteinSequence.append(aminoAcid)
            } else {
                proteinSequence.append(" Can't read next codon. Stopped.")
            }
        }

        return proteinSequence.toString()
    }
}