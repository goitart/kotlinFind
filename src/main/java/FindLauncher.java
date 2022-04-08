
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.File;

public class FindLauncher {

    @Option(name = "-d", usage = "Directory")
    private Boolean isD = false;

    @Option(name = "-r", usage = "Find in subdirectories")
    private Boolean subDirectories = false;

    @Argument(required = true, metaVar = "InputName", index = 0, usage = "File to be found")
    private String InputFileName;

    @Argument(metaVar = "InputDirectory", index = 1, usage = "Directory")
    private String directory = new File("").getAbsolutePath().toString();
//    private String directory = "C:\\Users\\chevy\\IdeaProjects\\kotlinFind";

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

//        System.out.println(directory);
//        System.out.println(isD);
//        System.out.println(subDirectories);

        FindKt.start(subDirectories, isD, directory, InputFileName);

    }
}
