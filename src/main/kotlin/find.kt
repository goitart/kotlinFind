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

fun findFile(fileS: String, directoryS: String): Set<String> {
    val file = File(fileS)
    val directory = File(directoryS)
    val br = directory.list()
    val brbr = directory.listFiles()
    if (br == null) {
        return setOfFiles
    }
    if (brbr != null) {
        if (brbr.toList().isNotEmpty()) {
            if (file.toString() in br.toList()) {
                setOfFiles.add(directory.absolutePath + "\\" + file)
            } else println("Файл не найден")
        }
    }
    if (setOfFiles.isEmpty()) return setOf("File not found")
    return setOfFiles
}
var count = 0
var setOfFiles = mutableSetOf<String>()

fun findInAll(fileS: String, directoryS: String): Set<String> {
    val file = File(fileS)
    val directory = File(directoryS)
    val br = directory.list()
    val brbr = directory.listFiles()
    if (brbr == null) {
        return setOfFiles
    }
    if (brbr.toList().isNotEmpty()) {
        if (file.toString() in br.toList()) {
            count ++
            setOfFiles.add(directory.absolutePath + "\\" + file)
        }
        for (files in brbr.toList()) {
            findInAll(file.toString(), files.toString())
        }
    }
    if (setOfFiles.isEmpty()) return setOf("File not found")
    return setOfFiles
}

fun start(subDirectories: Boolean, isD: Boolean, directory: String, InputFileName: String): Set<String> {
    if (!subDirectories) {
        println(findFile(InputFileName, directory))
        return findFile(InputFileName, directory)
    } else {
        println(findInAll(InputFileName, directory))
        return findInAll(InputFileName, directory)
    }
}

