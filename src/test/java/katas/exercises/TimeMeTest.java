package katas.exercises;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TimeMeTest {

    @Test
    public void testMeasureExecutionTime_SampleFunction() {
        Runnable sampleFunction = () -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        long timeTaken = TimeMe.measureExecutionTime(sampleFunction);
        assertTrue(timeTaken >= 500);
    }

    @Test
    public void testMeasureExecutionTime_QuickFunction() {
        Runnable quickFunction = () -> System.out.println("Quick task done!");
        long timeTaken = TimeMe.measureExecutionTime(quickFunction);
        assertTrue(timeTaken < 100);
    }

    @Test
    public void testMeasureExecutionTime_EmptyFunction() {
        Runnable emptyFunction = () -> {};
        long timeTaken = TimeMe.measureExecutionTime(emptyFunction);
        assertTrue(timeTaken < 10);
    }
}