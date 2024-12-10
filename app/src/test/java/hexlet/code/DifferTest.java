package hexlet.code;

import org.skyscreamer.jsonassert.JSONAssert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {
    private static String filepathJson1;
    private static String filepathJson2;
    private static String filepathYaml1;
    private static String filepathYaml2;
    private static String fileFormat;

    public static String getPath(String path) {
        Path pathFile = Paths.get(path);
        return pathFile.toAbsolutePath().toString();
    }

    public static String generatePath(String absolutePath, String pathFile) {
        return absolutePath + pathFile;
    }

    @BeforeAll
    public static void beforeAll() {
        String path = getPath("src/test/java/resources");

        filepathJson1 = generatePath(path, "/filepath1.json");
        filepathJson2 = generatePath(path, "/filepath2.json");
        filepathYaml1 = generatePath(path, "/filepath1.yml");
        filepathYaml2 = generatePath(path, "/filepath2.yml");
        fileFormat = generatePath(path, "stylish");
    }

    @Test
    public void testGenJsonYaml() throws Exception {
        var actual = Differ.generate(filepathYaml1, filepathYaml2, "json");
        var expectedJson = Differ.generate(filepathYaml1, filepathYaml2, fileFormat);
        JSONAssert.assertEquals(expectedJson, actual, false);
    }

    @Test
    public void testGenStylishYaml() throws Exception {
        var actual = Differ.generate(filepathYaml1, filepathYaml2, "stylish");
        var expectedStylish = Differ.generate(filepathYaml1, filepathYaml2, fileFormat);
        assertEquals(expectedStylish, actual);
    }

    @Test
    public void testGenStylishJs() throws Exception {
        var actual = Differ.generate(filepathJson1, filepathJson2, "stylish");
        var expectedStylish = Differ.generate(filepathYaml1, filepathYaml2, fileFormat);
        assertEquals(expectedStylish, actual);
    }

    @Test
    public void testGenPlainJs() throws Exception {
        var actual = Differ.generate(filepathJson1, filepathJson2, "plain");
        var expectedPlain = Differ.generate(filepathYaml1, filepathYaml2, fileFormat);
        assertEquals(expectedPlain, actual);
    }

    @Test
    public void testGenPlainYml() throws Exception {
        var actual = Differ.generate(filepathYaml1, filepathYaml2, "plain");
        var expectedPlain = Differ.generate(filepathYaml1, filepathYaml2, fileFormat);
        assertEquals(expectedPlain, actual);
    }
}
