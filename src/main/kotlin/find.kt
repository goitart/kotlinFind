import java.io.File
import org.apache.commons.io.FileUtils.isEmptyDirectory

fun main(args: Array<String>) {
    FindLauncher.main(args)
}

fun findInAll(fileS: String, directoryS: String, subDir: Boolean): Set<String> {
    val setOfFiles = mutableSetOf<String>()

    val file = File(fileS)
    val directory = File(directoryS)
    val directoryList = directory.list()
    val dirListFiles = directory.listFiles()

    if (dirListFiles == null || directoryList == null) {
        return setOf()
    }

    if (!isEmptyDirectory(directory)) {
        if (fileS in directoryList.toList()) {
            if (subDir) {
                setOfFiles.add(directory.absolutePath + "\\" + file)
            } else setOfFiles.add(file.toString())
        }
        if (subDir && directory.isDirectory) {
            for (files in dirListFiles.toList()) {
                setOfFiles.addAll(findInAll(fileS, files.toString(), true))
            }
        }
    }
    if (setOfFiles.isEmpty()) return setOf()
    return setOfFiles
}

fun start(subDirectories: Boolean, directory: String, InputFileName: String): Set<String> {
    val finalList = findInAll(InputFileName, directory, subDirectories)
    for (file in finalList) {
        val invFile = File(file).invariantSeparatorsPath
        val pattern = File(directory).invariantSeparatorsPath.toRegex()
        val finalPath = pattern.replace(invFile, "")
        val directoryFile = File(directory).name
        println("$directoryFile$finalPath")
    }
    return findInAll(InputFileName, directory, subDirectories).toSet()
}