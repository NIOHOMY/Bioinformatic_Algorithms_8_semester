package labs.com.utils

import java.io.File

class FileReader {

    fun readFromFile(filePath: String, linesToDrop: Int = 0): String {
        val file = File(filePath)
        if (!file.exists()) {
            throw IllegalArgumentException("File does not exist")
        }

        return file.readLines().drop(linesToDrop).joinToString("\n").replace("\n", "")
    }
}