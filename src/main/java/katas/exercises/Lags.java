package katas.exercises;

import java.util.*;

public class Lags {
    static class Request {
        String id;
        int startTime;
        int duration;
        int payment;
        int endTime; // End time = startTime + duration

        public Request(String id, int startTime, int duration, int payment) {
            this.id = id;
            this.startTime = startTime;
            this.duration = duration;
            this.payment = payment;
            this.endTime = startTime + duration;
        }
    }

    /**
     * Finds the maximum profit from a list of delivery requests that do not overlap.
     *
     * @param requests the list of delivery requests
     * @return the maximum profit
     */
    public static int maximizeProfit(List<Request> requests) {
        // Step 1: Sort requests by their END time
        requests.sort(Comparator.comparingInt(r -> r.endTime));

        int n = requests.size();
        int[] dp = new int[n];

        // Step 2: Binary Search to find the latest non-overlapping request
        int[] prev = new int[n];
        for (int i = 0; i < n; i++) {
            prev[i] = findNonOverlapping(requests, i);
        }

        // Step 3: DP Calculation
        dp[0] = requests.get(0).payment;
        for (int i = 1; i < n; i++) {
            int includeProfit = requests.get(i).payment;
            if (prev[i] != -1) {
                includeProfit += dp[prev[i]];
            }
            dp[i] = Math.max(dp[i - 1], includeProfit);
        }

        return dp[n - 1];
    }

    /**
     * Uses binary search to find the latest request that ends before the given index starts.
     */
    private static int findNonOverlapping(List<Request> requests, int index) {
        int left = 0, right = index - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (requests.get(mid).endTime <= requests.get(index).startTime) {
                if (requests.get(mid + 1).endTime <= requests.get(index).startTime) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Request> requests = new ArrayList<>();
        requests.add(new Request("REQ01", 0, 5, 50));
        requests.add(new Request("REQ02", 3, 7, 80));
        requests.add(new Request("REQ03", 5, 4, 60));
        requests.add(new Request("REQ04", 6, 3, 70));

        int maxProfit = maximizeProfit(requests);
        System.out.println("Maximum Profit: " + maxProfit);
    }
}
