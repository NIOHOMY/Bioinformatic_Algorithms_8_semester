package labs.com.algorithms

/**
 * Класс содержит алгоритмы выравнивания последовательностей
 *
 * **Глобальный:** Нидлмана-Вунша
 *
 * **Локальный:** Смита–Ватермана
 */
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
        seqA: String, seqB: String, weightMatrix: Array<IntArray>, gapFine: Int
    ): Pair<Pair<String, String>, Int> {
        val n = seqA.length
        val m = seqB.length

        val scoreMatrix = Array(n + 1) { IntArray(m + 1) }

        for (i in 0..n) {
            scoreMatrix[i][0] = i * gapFine
        }
        for (j in 0..m) {
            scoreMatrix[0][j] = j * gapFine
        }

        for (i in 1..n) {
            for (j in 1..m) {
                val matchScore = getWeight(seqA[i - 1], seqB[j - 1], weightMatrix)
                scoreMatrix[i][j] = maxOf(
                    scoreMatrix[i - 1][j - 1] + matchScore,
                    scoreMatrix[i - 1][j] + gapFine,
                    scoreMatrix[i][j - 1] + gapFine
                )
            }
        }

        val alignedA = StringBuilder()
        val alignedB = StringBuilder()
        var i = n
        var j = m
        val maxScore = scoreMatrix[i - 1][j - 1]

        while (i > 0 || j > 0) {
            when {
                i > 0 && j > 0 && scoreMatrix[i][j] == scoreMatrix[i - 1][j - 1] + (getWeight(seqA[i - 1], seqB[j - 1], weightMatrix)) -> {
                    alignedA.append(seqA[i - 1])
                    alignedB.append(seqB[j - 1])
                    i--
                    j--
                }

                i > 0 && scoreMatrix[i][j] == scoreMatrix[i - 1][j] + gapFine -> {
                    alignedA.append(seqA[i - 1])
                    alignedB.append('-')
                    i--
                }

                j > 0 && scoreMatrix[i][j] == scoreMatrix[i][j - 1] + gapFine -> {
                    alignedA.append('-')
                    alignedB.append(seqB[j - 1])
                    j--
                }
            }
        }

        return Pair(alignedA.reverse().toString(), alignedB.reverse().toString()) to maxScore
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
        seqA: String, seqB: String, weightMatrix: Array<IntArray>, gapFine: Int
    ): Pair<Pair<String, String>, Int> {
        val lenA = seqA.length
        val lenB = seqB.length
        val matrix = Array(lenA + 1) { IntArray(lenB + 1) }
        var maxScore = 0
        var maxI = 0
        var maxJ = 0

        for (i in 1..lenA) {
            for (j in 1..lenB) {
                val score = getWeight(seqA[i - 1], seqB[j - 1], weightMatrix)
                val diagonal = matrix[i - 1][j - 1] + score
                val up = matrix[i - 1][j] + gapFine
                val left = matrix[i][j - 1] + gapFine
                matrix[i][j] = maxOf(0, diagonal, up, left)

                if (matrix[i][j] > maxScore) {
                    maxScore = matrix[i][j]
                    maxI = i
                    maxJ = j
                }
            }
        }

        val alignedA = StringBuilder()
        val alignedB = StringBuilder()
        var i = maxI
        var j = maxJ

        while (i > 0 && j > 0 && matrix[i][j] > 0) {
            if (matrix[i][j] == matrix[i - 1][j] + gapFine) {
                alignedA.append(seqA[i - 1])
                alignedB.append('-')
                i--
            } else if (matrix[i][j] == matrix[i][j - 1] + gapFine) {
                alignedA.append('-')
                alignedB.append(seqB[j - 1])
                j--
            } else {
                alignedA.append(seqA[i - 1])
                alignedB.append(seqB[j - 1])
                i--
                j--
            }
        }

        return Pair(alignedA.reverse().toString(), alignedB.reverse().toString()) to maxScore
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