package labs.com.algorithms

class LevenshteinDistanceOptimizedCalculator : LevenshteinDistanceCalculator {

    override fun getLevenshteinDistance(str1: String, str2: String): Int {
        val m = str1.length
        val n = str2.length
        val prev = IntArray(n + 1)
        val curr = IntArray(n + 1)

        for (j in 0..n) {
            prev[j] = j
        }

        for (i in 1..m) {
            curr[0] = i
            for (j in 1..n) {
                curr[j] = if (str1[i - 1] == str2[j - 1]) {
                    prev[j - 1]
                } else {
                    minOf(prev[j - 1], prev[j], curr[j - 1]) + 1
                }
            }
            System.arraycopy(curr, 0, prev, 0, n + 1)
        }

        return curr[n]
    }
}