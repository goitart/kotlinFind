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
    val directoryList = directory.list()
    val dirListFiles = directory.listFiles()
    if (directoryList == null) {
        return setOf("not found")
    }
    if (dirListFiles != null) {
        if (dirListFiles.toList().isNotEmpty()) {
            if (file.toString() in directoryList.toList()) {
                setOfFiles.add(directory.absolutePath + "\\" + file)
            }
        }
    }
    if (setOfFiles.isEmpty()) return setOf("not found")
    return setOfFiles
}
var count = 0
var setOfFiles = mutableSetOf<String>()

fun findInAll(fileS: String, directoryS: String): Set<String> {
    val file = File(fileS)
    val directory = File(directoryS)
    val directoryList = directory.list()
    val dirListFiles = directory.listFiles()
    if (dirListFiles == null || directoryList == null) {
        return setOf("not found")
    }
    if (dirListFiles.toList().isNotEmpty()) {
        if (file.toString() in directoryList.toList()) {
            count ++
            setOfFiles.add(directory.absolutePath + "\\" + file)
        }
        for (files in dirListFiles.toList()) {
            findInAll(file.toString(), files.toString())
        }
    }
    if (setOfFiles.isEmpty()) return setOf("not found")
    return setOfFiles
}

fun start(subDirectories: Boolean, directory: String, InputFileName: String): Set<String> {
    if (!subDirectories) {
        for (file in findFile(InputFileName, directory)) {
            println("File: $file")
        }
        setOfFiles.clear()
        return findFile(InputFileName, directory)

    } else {
        for (file in findInAll(InputFileName, directory)) {
            println("File: $file")
        }
        setOfFiles.clear()
        return findInAll(InputFileName, directory)

    }
}

