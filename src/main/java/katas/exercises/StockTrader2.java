package katas.exercises;

public class StockTrader2 {

    /**
     * Finds the maximum profit that can be achieved by buying and selling the stock MULTIPLE times.
     *
     * O(n) is the best complexity
     *
     * @param prices an array of prices on each day
     * @return the maximum profit, or 0 if no profit can be achieved
     */
    public static int maxProfit(int[] prices) {

        // Edge case: If there are fewer than 2 prices, no profit can be made
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int high = 0;
        int low = 0;
        int profit = 0;
        int i = 0;
        int n = prices.length;

        while (i < n - 1) {
            // Find the next valley (local minimum)
            while (i < n - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            if (i < n) {
                low = prices[i]; // Set the low (buy price)
            }

            // Find the next peak (local maximum)
            while (i < n - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            if (i < n) {
                high = prices[i]; // Set the high (sell price)
            }

            // Add the profit for this transaction
            profit += high - low;
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] stockPrices = {7, 1, 5, 3, 6, 4};
        int profit = maxProfit(stockPrices);
        System.out.println("Maximum Profit: " + profit);  // should be 7
    }
}
