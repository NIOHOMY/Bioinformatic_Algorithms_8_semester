package labs.com.algorithms.lab1

class DnaSequenceAnalyzer {
    fun countNucleotides(dnaSequence: String): String {
        val nucleotideCounts = mutableMapOf('A' to 0, 'C' to 0, 'G' to 0, 'T' to 0)

        for (nucleotide in dnaSequence) {
            nucleotideCounts[nucleotide] = nucleotideCounts.getOrDefault(nucleotide, 0) + 1
        }

        return "${nucleotideCounts['A']} ${nucleotideCounts['C']} ${nucleotideCounts['G']} ${nucleotideCounts['T']}"
    }
}