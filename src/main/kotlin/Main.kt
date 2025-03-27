package labs.com

import labs.com.utils.FileReader

fun countKmers(text: String, k: Int): Map<String, Int> {
    val kmersCount = mutableMapOf<String, Int>()
    for (i in 0..text.length - k) {
        val kmer = text.substring(i, i + k)
        kmersCount[kmer] = kmersCount.getOrDefault(kmer, 0) + 1
    }
    return kmersCount
}

fun mostFrequentKmer(text: String, k: Int): List<String> {
    val kmersCount = countKmers(text, k)
    println(kmersCount.map { "${it.value}" })
    val maxCount = kmersCount.values.maxOrNull() ?: 0
    println("Max count: ${maxCount}\nSize: ${kmersCount.size}\n")
    return kmersCount.filter { it.value == maxCount && it.key.length == k }.keys.toList()
}

fun main() {
    val fileReader = FileReader()
    try {
        val sequence = fileReader.readFromFile(
            "C:/Users/N1o/IdeaProjects/Bioinformatic_Algorithms_8_semester/src/main/resources/pig_epidermal_growth_factor.txt",
            1
        )
        val k = 2
        val result = mostFrequentKmer(sequence, k)
        println("Most frequent $k-mers:\n${result .joinToString(", ")}")
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
}