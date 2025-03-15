package labs.com.algorithms

class BestSequencesAlignmentAlgorithm {

    /**
     * ## Алгоритм глобального выравнивания Нидлмана-Вунша
     *
     * ###### Описание:
     * Строит матрицу сходства M_i_j для всего выравнивания, начиная с верхнего левого угла и заполняя всю матрицу
     * с учётом штрафов за пробелы и матрицы весов.
     *
     * * Имеет квадратичные затраты памяти и времени.
     *
     *  @return **Число**, полученное в правом нижнем углу матрицы M.
     *
     * **Выравнивание**, полученное через обратный обход, начиная с правого нижнего угла,
     * по ячейкам, имеющих максимальный вес.
     */
    fun global(
        seq1: String,
        seq2: String,
        weightMatrix: Array<IntArray>,
        gapFine: Int
    ): Pair<String, Int> {
        val m = seq1.length
        val n = seq2.length
        val dp = Array(m + 1) { IntArray(n + 1) }

        for (i in 0..m) dp[i][0] = gapFine * i
        for (j in 0..n) dp[0][j] = gapFine * j

        for (i in 1..m) {
            for (j in 1..n) {
                val match = dp[i - 1][j - 1] + getWeight(seq1[i - 1], seq2[j - 1], weightMatrix)
                val delete = dp[i - 1][j] + gapFine
                val insert = dp[i][j - 1] + gapFine
                dp[i][j] = maxOf(match, delete, insert)
            }
        }

        val alignment1 = StringBuilder()
        val alignment2 = StringBuilder()
        var i = m
        var j = n

        while (i > 0 && j > 0) {
            if (dp[i][j] == dp[i - 1][j - 1] + getWeight(seq1[i - 1], seq2[j - 1], weightMatrix)) {
                alignment1.append(seq1[i - 1])
                alignment2.append(seq2[j - 1])
                i--
                j--
            } else if (dp[i][j] == dp[i - 1][j] + gapFine) {
                alignment1.append(seq1[i - 1])
                alignment2.append('-')
                i--
            } else {
                alignment1.append('-')
                alignment2.append(seq2[j - 1])
                j--
            }
        }

        while (i > 0) {
            alignment1.append(seq1[i - 1])
            alignment2.append('-')
            i--
        }
        while (j > 0) {
            alignment1.append('-')
            alignment2.append(seq2[j - 1])
            j--
        }

        return Pair(alignment1.reverse().toString(), dp[m][n])
    }

    /**
     * ## Алгоритм локального выравнивания Смита–Ватермана
     *
     * ###### Описание:
     * Решает задачу поиска гомологичных участков в двух последовательностях,
     * применяя матрицу сходства M_i_j.
     *
     * * На момент начала построения значения элементов верхней строки и
     * левого столбца матрицы M считаются равными нулю.
     *
     *  @return **Число**, полученное наибольшее число матрицы M.
     *
     * **Выравнивание**, полученное через обратный обход, начиная с наибольшего числа и заканчивается в клетке с нулём.
     */
    fun local(
        seq1: String,
        seq2: String,
        weightMatrix: Array<IntArray>,
        gapFine: Int
    ): Pair<String, Int> {
        val m = seq1.length
        val n = seq2.length
        val dp = Array(m + 1) { IntArray(n + 1) }
        var maxScore = 0
        var maxPos = Pair(0, 0)

        for (i in 1..m) {
            for (j in 1..n) {
                val match = dp[i - 1][j - 1] + getWeight(seq1[i - 1], seq2[j - 1], weightMatrix)
                val delete = dp[i - 1][j] + gapFine
                val insert = dp[i][j - 1] + gapFine
                dp[i][j] = maxOf(match, delete, insert, 0)

                if (dp[i][j] > maxScore) {
                    maxScore = dp[i][j]
                    maxPos = Pair(i, j)
                }
            }
        }

        val alignment1 = StringBuilder()
        val alignment2 = StringBuilder()
        var i = maxPos.first
        var j = maxPos.second

        while (i > 0 && j > 0 && dp[i][j] > 0) {
            if (dp[i][j] == dp[i - 1][j - 1] + getWeight(seq1[i - 1], seq2[j - 1], weightMatrix)) {
                alignment1.append(seq1[i - 1])
                alignment2.append(seq2[j - 1])
                i--
                j--
            } else if (dp[i][j] == dp[i - 1][j] + gapFine) {
                alignment1.append(seq1[i - 1])
                alignment2.append('-')
                i--
            } else {
                alignment1.append('-')
                alignment2.append(seq2[j - 1])
                j--
            }
        }

        return Pair(alignment1.reverse().toString(), maxScore)
    }

    private fun getWeight(char1: Char, char2: Char, scoringMatrix: Array<IntArray>): Int {
        val nucleotides = "atgc"
        val index1 = nucleotides.indexOf(char1.lowercaseChar())
        val index2 = nucleotides.indexOf(char2.lowercaseChar())

        if (char1 == '\n' || char2 == '\n') {
            return 0
        } else if (index1 < 0 || index2 < 0) {
            throw IllegalArgumentException("Invalid character in sequence: $char1 or $char2")
        }

        return scoringMatrix[index1][index2]
    }
}