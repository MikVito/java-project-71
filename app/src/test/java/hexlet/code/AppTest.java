package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


class DifferTest {
    private static String jsonFilePath1;
    private static String jsonFilePath2;
    private static String format;

    public static String fileRead(String filePath) throws Exception {
        Path path = Paths.get(filePath).toAbsolutePath().normalize();
        return Files.readString(path);
    }

    @BeforeAll
    public static void initialSetup() throws Exception {
        jsonFilePath1 = fileRead(
                "/home/mikhail/IdeaProjects/java-project-71/app/src/test/resources/testJson1.json");
        jsonFilePath2 = fileRead(
                "/home/mikhail/IdeaProjects/java-project-71/app/src/test/resources/testJson2.json");
        format = "stylish";
    }

    @Test
    public void callTest() throws Exception {
        String expectResult = "{...}";
        String resultJson = Differ.generate(jsonFilePath1, jsonFilePath2, format);
        Assertions.assertEquals(expectResult, resultJson);
    }
}

