package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        String file1 = fileReader(filepath1);
        String file2 = fileReader(filepath2);
        String formatFile = fileReader(format);

        var getFileFormat1 = Parser.getFileData(file1, formatFile);
        var getFileFormat2 = Parser.getFileData(file2, formatFile);

        var compareFile = Tree.generateDifferenceTree(getFileFormat1, getFileFormat2);
        return Format.formatDifference(compareFile);
    }

    public static String fileReader(String file) throws Exception {
        Path pathFile = Paths.get(file).toAbsolutePath().normalize();
        return Files.readString(pathFile);
    }
}

