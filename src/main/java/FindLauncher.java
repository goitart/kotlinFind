
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.File;

public class FindLauncher {

    @Option(name = "-d", usage = "Directory")
    private String directory = new File("").getAbsolutePath().toString();;

    @Option(name = "-r", usage = "Find in subdirectories")
    private Boolean subDirectories = false;

    @Argument(required = true, metaVar = "InputName", index = 0, usage = "File to be found")
    private String InputFileName;

    public static void main(String[] args) {
        new FindLauncher().launch(args);
    }

    private void launch(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("find [-r] [-d directory] filename.txt");
            parser.printUsage(System.err);
            throw new IllegalArgumentException("");
        }

        FindKt.start(subDirectories, directory, InputFileName);

    }
}
