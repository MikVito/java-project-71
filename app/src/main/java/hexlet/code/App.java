package hexlet.code;

import picocli.CommandLine;

@CommandLine.Command(
        name = "app",
        mixinStandardHelpOptions = true,
        version = "1.0",
        description = "this example for use picocli."
)

public class App implements Runnable{

    @Override
    public void run() {
        System.out.println("Welcome to Picocli app!");
    }

    public static void main(String[] args) {
        var exitCode = new CommandLine(new App()).execute(args);
        System.out.println(exitCode);
    }
}
