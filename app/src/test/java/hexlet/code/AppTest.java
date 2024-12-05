package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void call() {
        assertEquals(1, 1);
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