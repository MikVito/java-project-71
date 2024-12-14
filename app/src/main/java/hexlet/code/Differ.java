package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;


public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        String file1 = fileReader(filepath1);
        String file2 = fileReader(filepath2);
        String fileFormat = fileFormat(filepath1);

        HashMap<String, Object> getFileFormat1 = Parser.getFileParse(file1, fileFormat);
        HashMap<String, Object> getFileFormat2 = Parser.getFileParse(file2, fileFormat);

        var compareFileList = Tree.generateDifferenceTree(getFileFormat1, getFileFormat2);
        return Format.formatDifference(compareFileList, format);
    }

    public static String fileReader(String file) throws IOException {
        Path pathFile = Paths.get(file).toAbsolutePath().normalize();
        return Files.readString(pathFile);
    }

    public static String fileFormat(String filepath1) {
        return filepath1.substring(filepath1.lastIndexOf(".") + 1);
    }
}

