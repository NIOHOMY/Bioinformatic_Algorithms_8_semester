package labs.com.algorithms

class LevenshteinDistanceMatrixCalculator : LevenshteinDistanceCalculator {

    override fun getLevenshteinDistance(str1: String, str2: String): Int {
        val m = str1.length
        val n = str2.length
        val dp = Array(m + 1) { IntArray(n + 1) }

        for (i in 0..m) {
            for (j in 0..n) {
                when {
                    i == 0 -> dp[i][j] = j
                    j == 0 -> dp[i][j] = i
                    str1[i - 1] == str2[j - 1] -> dp[i][j] = dp[i - 1][j - 1]
                    else -> dp[i][j] = minOf(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1
                }
            }
        }

        return dp[m][n]
    }
}