package katas.exercises;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class LagsTest {

    @Test
    public void testMaximizeProfit() {
        List<Lags.Request> requests = new ArrayList<>();
        requests.add(new Lags.Request("REQ01", 0, 5, 50));
        requests.add(new Lags.Request("REQ02", 3, 7, 80));
        requests.add(new Lags.Request("REQ03", 5, 4, 60));
        requests.add(new Lags.Request("REQ04", 6, 3, 70));

        assertEquals(120, Lags.maximizeProfit(requests), "Expected max profit is 120 (REQ01 + REQ04)");
    }


    @Test
    public void testNoOverlappingRequests() {
        List<Lags.Request> requests = new ArrayList<>();
        requests.add(new Lags.Request("REQ01", 0, 3, 30));
        requests.add(new Lags.Request("REQ02", 4, 3, 40));
        requests.add(new Lags.Request("REQ03", 8, 2, 50));

        assertEquals(120, Lags.maximizeProfit(requests), "Expected max profit is 30+40+50 = 120");
    }

    @Test
    public void testAllOverlappingRequests() {
        List<Lags.Request> requests = new ArrayList<>();
        requests.add(new Lags.Request("REQ01", 0, 10, 100));
        requests.add(new Lags.Request("REQ02", 1, 10, 120));
        requests.add(new Lags.Request("REQ03", 2, 10, 150));

        assertEquals(150, Lags.maximizeProfit(requests), "Expected max profit is 150 (highest paying request)");
    }

    @Test
    public void testOptimalSelection() {
        List<Lags.Request> requests = new ArrayList<>();
        requests.add(new Lags.Request("REQ01", 1, 2, 30));
        requests.add(new Lags.Request("REQ02", 3, 2, 40));
        requests.add(new Lags.Request("REQ03", 4, 3, 50));
        requests.add(new Lags.Request("REQ04", 6, 1, 60));

        assertEquals(130, Lags.maximizeProfit(requests), "Expected max profit is 30 + 50 + 60 = 130");
    }

    @Test
    public void testOverlappingRequestsWithHigherProfit() {
        List<Lags.Request> requests = new ArrayList<>();
        requests.add(new Lags.Request("REQ01", 0, 3, 50));
        requests.add(new Lags.Request("REQ02", 2, 5, 90));
        requests.add(new Lags.Request("REQ03", 5, 3, 40));

        assertEquals(90, Lags.maximizeProfit(requests), "Expected max profit is 90 (REQ02 is better alone)");
    }

    @Test
    public void testPerformanceWithLargeInput() {
        List<Lags.Request> requests = new ArrayList<>();
        for (int i = 0; i < 1000; i += 2) {
            requests.add(new Lags.Request("REQ" + i, i, 1, i + 1));
        }

        assertEquals(250000, Lags.maximizeProfit(requests), "Expected max profit is the sum of all even payments");
    }
}
