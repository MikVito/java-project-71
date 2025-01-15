package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;


public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        String file1 = fileReader(filepath1);
        String file2 = fileReader(filepath2);
        String fileFormat1 = getFileFormat(filepath1);
        String fileFormat2 = getFileFormat(filepath2);

        Map<String, Object> parsedData1 = Parser.parse(file1, fileFormat1);
        Map<String, Object> parsedData2 = Parser.parse(file2, fileFormat2);

        var compareFileList = Tree.getDifferenceTree(parsedData1, parsedData2);
        return Formatter.formatDifference(compareFileList, format);
    }

    public static String fileReader(String file) throws IOException {
        Path pathFile = Paths.get(file).toAbsolutePath().normalize();
        return Files.readString(pathFile);
    }

    public static String getFileFormat(String filepath) {
        int dotIndex = filepath.lastIndexOf(".");
        if (dotIndex == -1 || dotIndex == filepath.length() - 1) {
            throw new IllegalArgumentException("File does not have a valid extension: " + filepath);
        }
        return filepath.substring(dotIndex + 1).toLowerCase();
    }
}

