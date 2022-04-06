
import java.io.File;
import java.io.IOException;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

public class FindLauncher {

    @Option(name = "-d", required = false, usage = "Directory")
    private String directory;

    @Option(name = "-r", required = false, usage = "Find in subdirectories")
    private String subDirectories;

    @Argument(required = true, metaVar = "InputName", usage = "File to be found")
    private File InputFileName; //  FILE??

    public static void main(String[] args) {
        new FindLauncher().launch(args);
    }
    private void launch(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);

        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
//            System.err.println(e.getMessage());
            parser.printUsage(System.err);
            return;
        }

    }
}
