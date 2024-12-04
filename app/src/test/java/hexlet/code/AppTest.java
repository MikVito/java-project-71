package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);

    @Test
  public void testMain() {
        System.out.println(printStream);
        App.main(new String[]{});

        assertEquals("Hello, World!\n", outputStream.toString());

        System.out.println(System.out);
    }
}
