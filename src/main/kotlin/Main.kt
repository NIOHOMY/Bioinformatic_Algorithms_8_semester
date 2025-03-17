package labs.com

import labs.com.algorithms.BestSequencesAlignmentAlgorithm
import labs.com.utils.FileReader

private val alignmentAlgorithm = BestSequencesAlignmentAlgorithm()

/**
 * Вариант 19.
 *     a     t     g     c
 * a  1  -2  -2   -2
 * t  -2   1  -2   -2
 * g -2 -2    1  -2
 * c -2 -2  -2    1
 * Штраф за пробел −1.
 */
private val weightMatrix = arrayOf(
    intArrayOf(1, -2, -2, -2),
    intArrayOf(-2, 1, -2, -2),
    intArrayOf(-2, -2, 1, -2),
    intArrayOf(-2, -2, -2, 1)
)
private const val GapFine = -1

fun main() {
    println()
    testGlobal()
    println()
    testLocal()
    val fileReader = FileReader()
    try {
        val str1 = fileReader.readFromFile(
            "C:/Users/N1o/IdeaProjects/Bioinformatic_Algorithms_8_semester/src/main/resources/human_epidermal_growth_factor.txt",
            1
        )
        val str2 = fileReader.readFromFile(
            "C:/Users/N1o/IdeaProjects/Bioinformatic_Algorithms_8_semester/src/main/resources/pig_epidermal_growth_factor.txt",
            1
        )
        println()
        task1(str1, str2)
        println()
        task2(str1, str2)
        println()
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
}


fun testGlobal() {
    val seqA = "ACGTGAC"
    val seqB = "GACGTC"

    val (aligned, score) = alignmentAlgorithm.global(seqA, seqB, weightMatrix, GapFine)

    println("Global")
    println("A: ${aligned.first}")
    println("B: ${aligned.second}")
    println("Score: ${score}")
}


fun testLocal() {
    val seqA = "ACGTGAC"
    val seqB = "GACGTC"

    val (aligned, score) = alignmentAlgorithm.local(seqA, seqB, weightMatrix, GapFine)
    println("Local")
    println("A: ${aligned.first}")
    println("B: ${aligned.second}")
    println("Score: ${score}")
}


private fun task1(str1: String, str2: String) {
    val (globalAlignment, score) = alignmentAlgorithm.global(str1, str2, weightMatrix, GapFine)
    println("Global Alignment: \nA: ${globalAlignment.first}, \nB: ${globalAlignment.second} \n Score: ${score}")
}

private fun task2(str1: String, str2: String) {
    val (localAlignment, score) = alignmentAlgorithm.local(str1, str2, weightMatrix, GapFine)
    println("Local Alignment: \nA: ${localAlignment.first}, \nB: ${localAlignment.second} \n Score: ${score}")
}