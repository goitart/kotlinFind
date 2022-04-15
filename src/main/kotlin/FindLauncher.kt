import org.kohsuke.args4j.Argument
import org.kohsuke.args4j.CmdLineException
import org.kohsuke.args4j.CmdLineParser
import org.kohsuke.args4j.Option
import java.io.File

class FindLauncher {
    @Option(name = "-d", usage = "Directory")
    private var directory = File("").absolutePath

    @Option(name = "-r", usage = "Find in subDirectories")
    private var subDirectories = false

    @Argument(required = true, metaVar = "InputName", usage = "File to be found")
    private var inputFileName: String = ""


    private fun launch(args: Array<String>) {
        val parser = CmdLineParser(this)
        try {
            parser.parseArgument(*args)
        } catch (e: CmdLineException) {
            System.err.println(e.message)
            System.err.println("find [-r] [-d directory] filename.txt")
            parser.printUsage(System.err)
            throw IllegalArgumentException("")
        }
        val find = start(subDirectories, directory, inputFileName)
        if (find.isEmpty()) println("File not found")
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            FindLauncher().launch(args)
        }
    }
}