package hexlet.code;

import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.util.Objects;


import static org.junit.jupiter.api.Assertions.assertEquals;

class FormatterTest {
    @Test
    public void testDiffJsonWithoutFormat() throws Exception {
        String resourceName1 = "file1.json";
        String resourceName2 = "file2.json";
        String format = "stylish";
        String expectedValueFileName = "testExpectedStylish";
        String absolutePath1 = createAbsolutePath(resourceName1);
        String absolutePath2 = createAbsolutePath(resourceName2);
        String absolutePathExpectedValue = createAbsolutePath(expectedValueFileName);
        var expectedValue = fileReader(absolutePathExpectedValue);
        var actual = Differ.generate(absolutePath1, absolutePath2, format);
        assertEquals(expectedValue, actual);
    }

    @Test
    public void testDiffYmlWithoutFormat() throws Exception {
        String resourceName1 = "file1.yml";
        String resourceName2 = "file2.yml";
        String format = "stylish";
        String expectedValueFileName = "testExpectedStylish";
        String absolutePath1 = createAbsolutePath(resourceName1);
        String absolutePath2 = createAbsolutePath(resourceName2);
        String absolutePathExpectedValue = createAbsolutePath(expectedValueFileName);
        var expectedValue = fileReader(absolutePathExpectedValue);
        var actual = Differ.generate(absolutePath1, absolutePath2, format);
        assertEquals(expectedValue, actual);
    }

    @Test
    public void testDiffJsonStylish() throws Exception {
        String resourceName1 = "file1.json";
        String resourceName2 = "file2.json";
        String expectedValueFileName = "testExpectedStylish";
        String absolutePath1 = createAbsolutePath(resourceName1);
        String absolutePath2 = createAbsolutePath(resourceName2);
        String absolutePathExpectedValue = createAbsolutePath(expectedValueFileName);
        var expectedValue = fileReader(absolutePathExpectedValue);
        var actual = Differ.generate(absolutePath1, absolutePath2, "stylish");
        assertEquals(expectedValue, actual);
    }
    @Test
    public void testDiffYmlStylish() throws Exception {
        String resourceNameYml1 = "file1.yml";
        String resourceNameYml2 = "file2.yml";
        String expectedValueFileName = "testExpectedStylish";
        String absolutePath1 = createAbsolutePath(resourceNameYml1);
        String absolutePath2 = createAbsolutePath(resourceNameYml2);
        String absolutePathExpectedValue = createAbsolutePath(expectedValueFileName);
        var expectedValue = fileReader(absolutePathExpectedValue);
        var actual = Differ.generate(absolutePath1, absolutePath2, "stylish");
        assertEquals(expectedValue, actual);
    }
    @Test
    public void testDiffJsonPlain() throws Exception {
        String resourceNameYml1 = "file1.json";
        String resourceNameYml2 = "file2.json";
        String expectedValueFileName = "testExpectedPlain";
        String absolutePath1 = createAbsolutePath(resourceNameYml1);
        String absolutePath2 = createAbsolutePath(resourceNameYml2);
        String absolutePathExpectedValue = createAbsolutePath(expectedValueFileName);
        var expectedValue = fileReader(absolutePathExpectedValue);
        var actual = Differ.generate(absolutePath1, absolutePath2, "plain");
        assertEquals(expectedValue, actual);
    }
    @Test
    public void testDiffYmlPlain() throws Exception {
        String resourceNameYml1 = "file1.yml";
        String resourceNameYml2 = "file2.yml";
        String expectedValueFileName = "testExpectedPlain";
        String absolutePath1 = createAbsolutePath(resourceNameYml1);
        String absolutePath2 = createAbsolutePath(resourceNameYml2);
        String absolutePathExpectedValue = createAbsolutePath(expectedValueFileName);
        var expectedValue = fileReader(absolutePathExpectedValue);
        var actual = Differ.generate(absolutePath1, absolutePath2, "plain");
        assertEquals(expectedValue, actual);
    }
    @Test
    public void testDiffJsonInJson() throws Exception {
        String resourceNameYml1 = "file1.json";
        String resourceNameYml2 = "file2.json";
        String expectedValueFileName = "testExpectedJson";
        String absolutePath1 = createAbsolutePath(resourceNameYml1);
        String absolutePath2 = createAbsolutePath(resourceNameYml2);
        String absolutePathExpectedValue = createAbsolutePath(expectedValueFileName);
        var expectedValue = fileReader(absolutePathExpectedValue);
        var actual = Differ.generate(absolutePath1, absolutePath2, "json");
        assertEquals(expectedValue, actual);
    }

    @Test
    public void testDiffYmlInJson() throws Exception {
        String resourceNameYml1 = "file1.yml";
        String resourceNameYml2 = "file2.yml";
        String expectedValueFileName = "testExpectedJson";
        String absolutePath1 = createAbsolutePath(resourceNameYml1);
        String absolutePath2 = createAbsolutePath(resourceNameYml2);
        String absolutePathExpectedValue = createAbsolutePath(expectedValueFileName);
        var expectedValue = fileReader(absolutePathExpectedValue);
        var actual = Differ.generate(absolutePath1, absolutePath2, "json");
        assertEquals(expectedValue, actual);
    }

    public static String fileReader(String filepath) throws Exception {
        Path absolutePath1 = Paths.get(filepath).toAbsolutePath().normalize();
        return Files.readString(absolutePath1);
    }

    public static String createAbsolutePath(String resourceName) {
        ClassLoader classLoader = FormatterTest.class.getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource(resourceName)).getFile());
        return file.getAbsolutePath();
    }
}

