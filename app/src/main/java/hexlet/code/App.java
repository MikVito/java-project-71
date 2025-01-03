package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Command;

import java.util.concurrent.Callable;

@Command(
        name = "MikVito",
        mixinStandardHelpOptions = true,
        version = "1.0",
        description = "Compares two configuration files and shows a difference."
)

public class App implements Callable<Integer> {
    @Parameters(
            index = "0",
            paramLabel = "filepath1",
            description = "path to first file"
    )
    String filepath1;

    @Parameters(
            index = "1",
            paramLabel = "filepath2",
            description = "path to second file"
    )
    String filepath2;

    @Option(
            names = {"-f", "--format"},
            paramLabel = "format",
            defaultValue = "stylish",
            description = "output format [default: stylish]"
    )
    String format;

    @Override
    public Integer call() {
        try {
            String generate = Differ.generate(filepath1, filepath2);
            System.out.println(generate);
            return 0;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return 1;
        }
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.out.println(exitCode);
    }
}
