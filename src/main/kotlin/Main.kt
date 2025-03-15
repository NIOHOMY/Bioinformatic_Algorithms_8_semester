package labs.com

import labs.com.utils.FileReader

fun main() {
    println()
    task1()
    println()
}

private fun task1() {

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
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
}