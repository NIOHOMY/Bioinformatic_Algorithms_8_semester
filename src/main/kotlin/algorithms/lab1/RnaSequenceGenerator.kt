package labs.com.algorithms.lab1

class RnaSequenceGenerator {
    fun generateRnaSequence(dnaSequence: String): String {
        return dnaSequence.replace('T', 'U')
    }
}