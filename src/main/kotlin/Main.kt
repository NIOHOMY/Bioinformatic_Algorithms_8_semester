package labs.com

import labs.com.algorithms.lab1.*

fun main() {
    println()
    testRabbitPopulation()
    println()
    testDnaSequenceAnalyzer()
    println()
    testHammingDistanceCalculator()
    println()
    testRnaSequenceGenerator()
    println()
    testProteinSequenceGenerator()
}

fun testRabbitPopulation() {
    val rabbitPopulation = RabbitPopulation()
    val n = 5
    val k = 3

    val totalPairs = rabbitPopulation.calculatePopulation(n.toLong(), k.toLong())
    println("months: $n total rabbits pairs: $totalPairs")
}

fun testDnaSequenceAnalyzer() {
    val dnaSequenceAnalyzer = DnaSequenceAnalyzer()
    val dnaSequence = "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC"
    val nucleotideCounts = dnaSequenceAnalyzer.countNucleotides(dnaSequence)
    println("Nucleotide counts: $nucleotideCounts")
}

fun testHammingDistanceCalculator() {
    val hammingDistanceCalculator = HammingDistanceCalculator()
    val s = "GAGCCTACTAACGGGAT"
    val t = "CATCGTAATGACGGCCT"
    val distance = hammingDistanceCalculator.calculateHammingDistance(s, t)
    println("Hamming distance: $distance")
}

fun testRnaSequenceGenerator() {
    val rnaSequenceGenerator = RnaSequenceGenerator()
    val dnaSequence = "GATGGAACTTGACTACGTAAATT"
    val rnaSequence = rnaSequenceGenerator.generateRnaSequence(dnaSequence)
    println("RNA sequence: $rnaSequence")
}

fun testProteinSequenceGenerator() {
    val proteinSequenceGenerator = ProteinSequenceGenerator()
    val rnaSequence = "AUGGCCAUGGCGCCCAGAACUGAGAUCAAUAGUACCCGUAUUAACGGGUGA"
    val proteinSequence = proteinSequenceGenerator.generateProteinSequence(rnaSequence)
    println("Protein sequence: $proteinSequence")
}