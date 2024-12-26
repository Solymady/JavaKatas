package katas.exercises;

public class StockTrader {

    /**
     * Finds the maximum profit that can be achieved by buying and selling the stock ONCE.
     *
     * Aim for O(n)
     *
     * @param prices an array of prices on each day
     * @return the maximum profit, or 0 if no profit can be achieved
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0; // No profit can be made if there are fewer than 2 prices
        }

        int maxProfit = 0;
        int l= prices[0];

        for (int i = 1; i < prices.length; i++) {
            int r=prices[i];
            if(l>r){
                l=r;
            }else{
                maxProfit = Math.max(maxProfit,r-l);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] stockPrices = {7, 1, 5, 3, 6, 4};
        int profit = maxProfit(stockPrices);
        System.out.println("Maximum Profit: " + profit);  // should be 5
    }
}
