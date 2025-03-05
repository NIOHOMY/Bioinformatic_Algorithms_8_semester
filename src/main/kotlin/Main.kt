package labs.com

import labs.com.algorithms.LevenshteinDistanceMatrixCalculator
import labs.com.algorithms.LevenshteinDistanceOptimizedCalculator
import labs.com.utils.FileReader
import kotlin.math.pow

private val TestStr1 = "PLEASANTLY"
private val TestStr2 = "MEANLY"

fun main() {
    println()
    testLevenshteinDistanceMatrixCalculator()
    println()
    testLevenshteinDistanceOptimizedCalculator()
}

fun <T> measureTime(block: () -> T): Pair<T, Long> {
    val startTime = System.nanoTime()
    val result = block()
    val endTime = System.nanoTime()
    val duration = endTime - startTime
    return result to duration
}

private fun printStrsDistanceAndTime(str1: String, str2: String, distance: Int, time: Long) {
    val divider = "--------------------------------------------------------------------------------------\n"
    println(
        divider +
        "Str1: $str1\n " +
        divider +
        "Str2: $str2\n" +
        divider +
            "Distance by 2 str (optimized): $distance. \n" +
            "Time: $time nanoseconds or ${time / 10.0.pow(10)} seconds.\n"
    )
}

private fun testLevenshteinDistanceMatrixCalculator() {
    val calculator = LevenshteinDistanceMatrixCalculator()
    val (distanceTest, timeTest) = measureTime { calculator.getLevenshteinDistance(TestStr1, TestStr2) }
    printStrsDistanceAndTime(TestStr1, TestStr2, distanceTest, timeTest)

    val fileReader = FileReader()
    try {
        val str1 = fileReader.readFromFile("C:/Users/N1o/IdeaProjects/Bioinformatic_Algorithms_8_semester/src/main/resources/human_epidermal_growth_factor.txt", 1)
        val str2 = fileReader.readFromFile("C:/Users/N1o/IdeaProjects/Bioinformatic_Algorithms_8_semester/src/main/resources/pig_epidermal_growth_factor.txt", 1)
        val (distance, time) = measureTime { calculator.getLevenshteinDistance(str1, str2) }
        printStrsDistanceAndTime(str1, str2, distance, time)
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
}

private fun testLevenshteinDistanceOptimizedCalculator() {
    val calculator = LevenshteinDistanceOptimizedCalculator()
    val (distanceTest, timeTest) = measureTime { calculator.getLevenshteinDistance(TestStr1, TestStr2) }
    printStrsDistanceAndTime(TestStr1, TestStr2, distanceTest, timeTest)

    val fileReader = FileReader()
    try {
        val str1 = fileReader.readFromFile("C:/Users/N1o/IdeaProjects/Bioinformatic_Algorithms_8_semester/src/main/resources/human_epidermal_growth_factor.txt", 1)
        val str2 = fileReader.readFromFile("C:/Users/N1o/IdeaProjects/Bioinformatic_Algorithms_8_semester/src/main/resources/pig_epidermal_growth_factor.txt", 1)
        val (distance, time) = measureTime { calculator.getLevenshteinDistance(str1, str2) }
        printStrsDistanceAndTime(str1, str2, distance, time)
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
}