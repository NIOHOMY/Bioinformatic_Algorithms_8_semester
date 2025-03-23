package labs.com

fun main() {
    val motifs = listOf(
        "AAGTCATTTT",
        "GCAGCTAAGA",
        "TTATTTGTCC",
        "CCTGTTACAT",
        "AACAGGGGGT",
        "TATTCATAGA",
        "GGTTATTCAT",
        "AAACAGGTTA",
        "TTCATCGAGT",
        "TAAGTATAGA",
        "ATGCAGGTCT",
        "CCTGACCCTT"
    )

    val consensus = findConsensus(motifs)
    val countMatrix = countMotifs(motifs)

    // Выводим матрицу Motifs с заглавными и строчными буквами
    println("Motifs matrix:")
    printMotifsWithUppercase(motifs, consensus)

    // Выводим консенсусную последовательность
    println("\nConsensus sequence: $consensus")

    // Выводим матрицу Count(Motifs)
    println("\nCount(Motifs) matrix:")
    printCountMatrix(countMatrix)
}

fun findConsensus(motifs: List<String>): String {
    val consensus = StringBuilder()
    val motifLength = motifs[0].length

    for (i in 0 until motifLength) {
        val column = motifs.map { it[i] }
        val mostFrequentNucleotide = column.groupingBy { it }.eachCount().maxByOrNull { it.value }?.key
        consensus.append(mostFrequentNucleotide)
    }

    return consensus.toString()
}

fun countMotifs(motifs: List<String>): Map<Char, List<Int>> {
    val motifLength = motifs[0].length
    val countMap = mutableMapOf('A' to MutableList(motifLength) { 0 },
        'C' to MutableList(motifLength) { 0 },
        'G' to MutableList(motifLength) { 0 },
        'T' to MutableList(motifLength) { 0 })

    for (motif in motifs) {
        for (i in 0 until motifLength) {
            val nucleotide = motif[i]
            countMap[nucleotide]!![i]++
        }
    }

    return countMap
}

fun printMotifsWithUppercase(motifs: List<String>, consensus: String) {
    for (i in motifs.indices) {
        print(if(i<10) " ${i}: " else "${i} ")
        val motif = motifs[i]
        val motifWithCase = StringBuilder()

        for (j in motif.indices) {
            if (motif[j] == consensus[j]) {
                motifWithCase.append(motif[j].uppercaseChar() + " ")
            } else {
                motifWithCase.append(motif[j].lowercaseChar() + " ")
            }
        }
        println(motifWithCase.toString())
    }
}

fun printCountMatrix(countMatrix: Map<Char, List<Int>>) {
    val nucleotides = listOf('A', 'C', 'G', 'T')
    println("\t" + (1..countMatrix['A']!!.size).joinToString("\t"))
    for (nucleotide in nucleotides) {
        print("$nucleotide\t")
        println(countMatrix[nucleotide]?.joinToString("\t") ?: "")
    }
}
