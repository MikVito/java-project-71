package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {
    private static String filepathJson1;
    private static String filepathJson2;
    private static String filepathYaml1;
    private static String filepathYaml2;

    private static String expectedJson;
    private static String expectedStylish;
    private static String expectedPlain;

    public static String getPath(String file) {
        Path pathFile = Paths.get(file);
        return pathFile.toAbsolutePath().toString();
    }

    public static String generatePath(String pathFile1, String pathFile2) {
        return Paths.get(pathFile1, pathFile2).toString();
    }

    public static String fileReader(String path, String file) throws IOException {
        return Files.readString(Paths.get(generatePath(path, file)));
    }

    @BeforeAll
    public static void beforeAll() throws IOException {
        String path = getPath("src/test/resources");

        filepathJson1 = generatePath(path, "/testFile1.json");
        filepathJson2 = generatePath(path, "/testFile2.json");
        filepathYaml1 = generatePath(path, "/testFile1.yml");
        filepathYaml2 = generatePath(path, "/testFile2.yml");

        expectedJson = fileReader(path, "/expectedJson.json");
        expectedStylish = fileReader(path, "/expectedStylish.text");
        expectedPlain = fileReader(path, "/expectedPlain.text");
    }

    @Test
    public void testJsonYaml() throws Exception {
        var actual = Differ.generate(filepathJson1, filepathJson2, "json");
        assertEquals(expectedJson, actual);
    }

    @Test
    public void testYamlJson() throws Exception {
        var actual = Differ.generate(filepathYaml1, filepathYaml2, "json");
        assertEquals(expectedJson, actual);
    }

    @Test
    public void testStylishYaml() throws Exception {
        var actual = Differ.generate(filepathYaml1, filepathYaml2, "stylish");
        assertEquals(expectedStylish, actual);
    }

    @Test
    public void testStylishJson() throws Exception {
        var actual = Differ.generate(filepathJson1, filepathJson2, "stylish");
        assertEquals(expectedStylish, actual);
    }

    @Test
    public void testPlainJson() throws Exception {
        var actual = Differ.generate(filepathJson1, filepathJson2, "plain");
        assertEquals(expectedPlain, actual);
    }

    @Test
    public void testPlainYml() throws Exception {
        var actual = Differ.generate(filepathYaml1, filepathYaml2, "plain");
        assertEquals(expectedPlain, actual);
    }

    @Test
    public void testJsonFile() throws Exception {
        var actual = Differ.generate(filepathJson1, filepathJson2, "json");
        JSONAssert.assertEquals(expectedJson, actual, false);
    }

    @Test
    public void testYamlFile() throws Exception {
        var actual = Differ.generate(filepathYaml1, filepathYaml2, "json");
        JSONAssert.assertEquals(expectedJson, actual, false);
    }
}


