package labs.com.algorithms.lab1

class HammingDistanceCalculator {
    fun calculateHammingDistance(s: String, t: String): Int {
        require(s.length == t.length) { "Input strings must have the same length" }

        var distance = 0
        for (i in s.indices) {
            if (s[i] != t[i]) {
                distance++
            }
        }
        return distance
    }
}