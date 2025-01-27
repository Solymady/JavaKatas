package katas.exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NginxLogsParser {

    /**
     * Parses a single Nginx access log entry into a structured map.
     *
     * The log format is:
     * 122.176.223.47 - - [05/Feb/2024:08:29:40 +0000] "GET /web-enabled/Enhanced-portal/bifurcated-forecast.js HTTP/1.1" 200 1684 "-" "Opera/9.58 (X11; Linux i686; en-US) Presto/2.12.344 Version/13.00"
     *
     * The parsed log data should be returned as a map:
     * {
     *   "client_ip": "122.176.223.47",
     *   "date": "05/Feb/2024:08:29:40 +0000",
     *   "http_method": "GET",
     *   "path": "/web-enabled/Enhanced-portal/bifurcated-forecast.js",
     *   "http_version": "1.1",
     *   "status": "200",
     *   "response_bytes": "1684",
     *   "user_agent": "Opera/9.58 (X11; Linux i686; en-US) Presto/2.12.344 Version/13.00"
     * }
     *
     * Hint: Use regex
     *
     * @param log the Nginx log string
     * @return a map containing parsed log data
     * @throws IllegalArgumentException if the log format is invalid
     */
    public static Map<String, String> parseLog(String log) {
        Map<String, String> parsedData = new HashMap<>();

        // Updated regex pattern
        String regex =
                "(\\d+\\.\\d+\\.\\d+\\.\\d+)\\s-\\s-\\s" + // client_ip
                        "\\[([\\w:/]+\\s[+\\-]\\d{4})\\]\\s" + // date
                        "\"(\\w+)\\s" + // http_method
                        "([^\\s]+)\\s" + // path
                        "(HTTP\\/\\d\\.\\d+)\"\\s" + // http_version
                        "(\\d{3})\\s" + // status
                        "(\\d+)\\s" + // response_bytes
                        "\"([^\"]*)\"\\s" + // user_agent (can be "-" or any valid string)
                        "\"([^\"]*)\""; // second user_agent or "-"

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(log);

        if (matcher.find()) {
            parsedData.put("client_ip", matcher.group(1));
            parsedData.put("date", matcher.group(2));
            parsedData.put("http_method", matcher.group(3));
            parsedData.put("path", matcher.group(4));
            parsedData.put("http_version", matcher.group(5));
            parsedData.put("status", matcher.group(6));
            parsedData.put("response_bytes", matcher.group(7));
            parsedData.put("user_agent", matcher.group(8));
        } else {
            throw new IllegalArgumentException("Invalid log format");
        }

        return parsedData;
    }


    public static void main(String[] args) {
        String logEntry = "122.176.223.47 - - [05/Feb/2024:08:29:40 +0000] " +
                "\"GET /web-enabled/Enhanced-portal/bifurcated-forecast.js HTTP/1.1\" 200 1684 " +
                "\"-\" \"Opera/9.58 (X11; Linux i686; en-US) Presto/2.12.344 Version/13.00\"";

        String logEntry1 = "122.176.223.47 - - [05/Feb/2024:08:29:40 +0000] " +
                "\"POST /api/v1/resource HTTP/2.0\" 404 2048 " +
                "\"-\" \" Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36\"";

        Map<String, String> parsedLog = parseLog(logEntry1);
        System.out.println("Parsed log data: " + parsedLog);
    }
}
