package libs.file

import java.io.File

abstract class FileUtils {

    companion object {
        // Reads the given file and maps each line to a string in a list. Returns null in case the file isn't readable.
        fun readFileAsLinesOrNull(fileName: String): List<String>? =
            File(fileName).takeIf { it.canRead() }?.useLines { it.toList() }
    }
}
