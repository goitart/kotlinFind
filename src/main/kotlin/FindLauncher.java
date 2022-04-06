import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

public class FindLauncher {

    @Option(name = "-d", usage = "Directory")
    private String directory;
    private Boolean isD;

    @Option(name = "-r", usage = "Find in subdirectories")
    private Boolean subDirectories;

    @Argument(required = true, metaVar = "InputName", usage = "File to be found")
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
//            System.err.println(e.getMessage());
            parser.printUsage(System.err);
            throw new IllegalArgumentException("");
        }
//        FindK find = new FindK(InputFileName, directory);
        FindKt.start(InputFileName, directory, subDirectories, isD);
    }
}
