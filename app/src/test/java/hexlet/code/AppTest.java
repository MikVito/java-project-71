package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    @Test
    void callTest() {
        var filepath1 = "file1.json";
        var filepath2 = "file2.json";
        var formatFile = "stylish";
        var expected = List.of(filepath1, filepath2, formatFile);
        assertEquals(expected, new ArrayList<>(List.of(filepath1, filepath2, formatFile)));
    }

    @Test
    void testMain() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        System.out.println(printStream);
        App.main(new String[]{});

        assertEquals("Hello, World!\n", outputStream.toString());

        System.out.println(System.out);
    }
}
