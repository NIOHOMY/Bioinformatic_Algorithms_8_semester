package labs.com.algorithms.lab1

class RabbitPopulation {
    fun calculatePopulation(n: Long, k: Long): Long {
        var previous = 0L
        var current = 1L

        for (month in 2..n) {
            val next = current + previous * k
            previous = current
            current = next
        }

        return current
    }
}