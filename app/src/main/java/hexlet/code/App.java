package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.nio.file.Path;

@Command(
        name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "1.0",
        description = "Compares two configuration files and shows a difference."
)

public class App implements Runnable {

    @Option(
            names = {"-f", "--format",},
            description = "output format[default: stylish]",
            defaultValue = "stylish"
    )
    String format;

    @Parameters(
            index = "0",
            description = "path to the first file"
    )
    Path filepath1;

    @Parameters(
            index = "1",
            description = "path to the second file"
    )
    Path filepath2;

    @Override
    public void run() {
        System.out.println("Comparing files: " + filepath1 + " and " + filepath2);
        System.out.println("Using format: " + format);
    }

    public static void main(String[] args) {
        var exitCode = new CommandLine(new App()).execute(args);
        System.out.println(exitCode);
    }
}
