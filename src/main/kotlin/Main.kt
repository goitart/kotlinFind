//Поиск файла(ов) с заданным в командной строке именем в указанной ключом -d
//директории, по умолчанию в текущей директории. Ключ -r указывает на необходимость
//поиска также во всех поддиректориях.
//Command Line: find [-r] [-d directory] filename.txt
//Кроме самой программы, следует написать автоматические тесты к ней.

import com.sun.tools.javac.Main
import java.io.File

fun main() {
    val directory = File("C:\\Users\\chevy\\OneDrive\\Документы")
    val currentFile = File("aаd.docx")
    val filThatFind1 = "край_Водоросли.wld"

    fun findInThis(files: File) {
        val br = files.list()
        val brbr = files.listFiles()
        if (br == null) {
            return
        }
        if (brbr.toList().isNotEmpty()) {
            if (currentFile.toString() in br.toList()) {
                //true
                println(files.absolutePath + "\\" + currentFile)
                return
            } else println("Файл не найден пппппппппппп")
        }
    }

    fun findInAll(files: File) {
        val br = files.list()
        val brbr = files.listFiles()
        if (br == null) {
            return
        }
        if (brbr.toList().isNotEmpty()) {
            if (currentFile.toString() in br.toList()) {
                //true
                println(files.absolutePath + "\\" + currentFile)
                return
            }

            for (file in brbr.toList()) {
//                if (currentFile.toString() in br.toList()) {
//                    return
//                } else findInAll(file)
                findInAll(file)
            }
        }
    }
    findInAll(directory)
    findInThis(directory)
}