package katas.exercises;

import static katas.exercises.DoNTimes.doNTimes;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DoNTimesTest {

    @Test
     void doNTimesTest() {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        PrintStream originalOut = System.out;
        System.setOut(printStream);

        Runnable func = () -> System.out.print("11");
        doNTimes(func, 3);

        String expectedOutput = "111111";
        assertEquals(expectedOutput, outputStream.toString());

        System.setOut(originalOut);
    }
}