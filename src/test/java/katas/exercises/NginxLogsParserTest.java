package katas.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

public class NginxLogsParserTest {

    @Test
    public void testParseLog_InvalidLog_MissingField() {
        String invalidLogEntry = "122.176.223.47 - - [05/Feb/2024:08:29:40 +0000] " +
                "\"GET /web-enabled/Enhanced-portal/bifurcated-forecast.js HTTP/1.1\" 200";

        // Test that the method throws IllegalArgumentException when the log format is invalid
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            NginxLogsParser.parseLog(invalidLogEntry);
        });
        assertEquals("Invalid log format", exception.getMessage());
    }

    @Test
    public void testParseLog_InvalidLog_WrongFormat() {
        String malformedLogEntry = "INVALID_LOG_FORMAT";

        // Test that the method throws IllegalArgumentException when the log format is not matched
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            NginxLogsParser.parseLog(malformedLogEntry);
        });
        assertEquals("Invalid log format", exception.getMessage());
    }

    @Test
    public void testParseLog_EmptyLog() {
        String emptyLogEntry = "";

        // Test that the method throws IllegalArgumentException for empty log entry
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            NginxLogsParser.parseLog(emptyLogEntry);
        });
        assertEquals("Invalid log format", exception.getMessage());
    }

}
