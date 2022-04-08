//Поиск файла(ов) с заданным в командной строке именем в указанной ключом -d
//директории, по умолчанию в текущей директории. Ключ -r указывает на необходимость
//поиска также во всех поддиректориях.
//Command Line: find [-r] [-d directory] filename.txt
//Кроме самой программы, следует написать автоматические тесты к ней.

import java.io.File

fun main(args : Array<String>) {
    FindLauncher.main(args)
    println(args.toList())
}

fun findFile(fileS: String, directoryS: String) {
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

fun start(subDirectories: Boolean, isD: Boolean, directory: String, InputFileName: String) {
    if (!subDirectories) {
        findFile(InputFileName, directory)
    } else findInAll(InputFileName, directory)
}

