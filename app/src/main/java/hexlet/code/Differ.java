package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        return "";
    }

    public static String fileReader(String file) throws Exception {
        Path pathFile = Paths.get(file).toAbsolutePath().normalize();
        return Files.readString(pathFile);
    }
}

