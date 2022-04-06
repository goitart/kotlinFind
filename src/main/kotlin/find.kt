//Поиск файла(ов) с заданным в командной строке именем в указанной ключом -d
//директории, по умолчанию в текущей директории. Ключ -r указывает на необходимость
//поиска также во всех поддиректориях.
//Command Line: find [-r] [-d directory] filename.txt
//Кроме самой программы, следует написать автоматические тесты к ней.

import java.io.File

//class Fin(InputFileName: String, directory: String) {
//    fun find(InputFileName: String, directory: String) {
//        val file = File(InputFileName)
//        val directoryF = File(directory)
//        val br = directoryF.list()
//        val brbr = directoryF.listFiles()
//        if (br == null) {
//            return
//        }
//        if (brbr != null) {
//            if (brbr.toList().isNotEmpty()) {
//                if (file.toString() in br.toList()) {
//                    //true
//                    println(directoryF.absolutePath + "\\" + file)
//                    return
//                } else println("Файл не найден")
//            }
//        }
//    }
//
//    fun findInAll(InputFileName: String, directory: String) {
//        val file = File(InputFileName)
//        val directoryF = File(directory)
//        val br = directoryF.list()
//        val brbr = directoryF.listFiles()
//        if (brbr == null) {
//            return
//        }
//        if (brbr.toList().isNotEmpty()) {
//            if (file.toString() in br.toList()) {
//                //true
//                count ++
//                println(directoryF.absolutePath + "\\" + file)
//                return
//            } else {
//                for (files in brbr.toList()) {
//                    findInAll(file.toString(), files.toString())
//                }
//            }
//        }
//
//    }
//    fun start(InputFileName: String, directory: String) {
//        if (directory == "") {
//            val file = File("find.kt")
//            val directoryN = file.absolutePath
//            find(InputFileName, directoryN)
//        }
//    }
//}

fun find(fileS: String, directoryS: String) {
    val file = File(fileS)
    val directory = File(directoryS)
    val br = directory.list()
    val brbr = directory.listFiles()
    if (br == null) {
        return
    }
    if (brbr != null) {
        if (brbr.toList().isNotEmpty()) {
            if (file.toString() in br.toList()) {
                //true
                println(directory.absolutePath + "\\" + file)
                return
            } else println("Файл не найден")
        }
    }
}
var count = 0

fun findInAll(fileS: String, directoryS: String) {
    val file = File(fileS)
    val directory = File(directoryS)
    val br = directory.list()
    val brbr = directory.listFiles()
    if (brbr == null) {
        return
    }
    if (brbr.toList().isNotEmpty()) {
        if (file.toString() in br.toList()) {
            //true
            count ++
            println(directory.absolutePath + "\\" + file)
            return
        } else {
            for (files in brbr.toList()) {
                findInAll(file.toString(), files.toString())
            }
        }
    }

}

fun start(InputFileName: String, directory: String, subDirectories: Boolean, isD: Boolean) {
    if (!isD) {
//        val file = File("find.kt")
//        val directoryN = file.absolutePath
//        find(InputFileName, directoryN)
    }
}

fun main(args : Array<String>) {
    FindLauncher.main(args)
//    val directory1 = "C:\\Users\\chevy\\OneDrive\\Документы\\Samsung"
//    val currentFile1 = "rty.txt"
//
//    findInAll(currentFile1, directory1)
//    find(currentFile1, directory1)

}