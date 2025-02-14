package labs.com.algorithms.lab1

class HammingDistanceCalculator {
    fun calculateHammingDistance(s: String, t: String): Int {
        if (s.length != t.length) return -1

        var distance = 0
        for (i in s.indices) {
            if (s[i] != t[i]) {
                distance++
            }
        }
        return distance
    }
}