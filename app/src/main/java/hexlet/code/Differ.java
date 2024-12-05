package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        var file1 = fileReader(filepath1);
        var file2 = fileReader(filepath2);

        var getFileFormat1 = Parser.getJasonData(file1);
        var getFileFormat2 = Parser.getJasonData(file2);

        var compareFile = Tree.generateDifferenceTree(getFileFormat1, getFileFormat2);
        return Format.formatDifference(compareFile);
    }

    public static String fileReader(String file) throws Exception {
        Path pathFile = Paths.get(file).toAbsolutePath().normalize();
        return Files.readString(pathFile);
    }
}

