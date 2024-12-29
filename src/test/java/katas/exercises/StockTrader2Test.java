package katas.exercises;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class StockTrader2Test {

    @Test
    public void testNormalCase() {
        int[] stockPrices = {7, 1, 5, 3, 6, 4};
        int expectedProfit = 7; // Buy at 1, sell at 5, buy at 3, sell at 6
        assertEquals(expectedProfit, StockTrader2.maxProfit(stockPrices));
    }

    @Test
    public void testDescendingPrices() {
        int[] stockPrices = {5, 4, 3, 2, 1};
        int expectedProfit = 0; // No profit can be made
        assertEquals(expectedProfit, StockTrader2.maxProfit(stockPrices));
    }

    @Test
    public void testSinglePrice() {
        int[] stockPrices = {5};
        int expectedProfit = 0; // Only one price, no transactions possible
        assertEquals(expectedProfit, StockTrader2.maxProfit(stockPrices));
    }

    @Test
    public void testEmptyArray() {
        int[] stockPrices = {};
        int expectedProfit = 0; // No prices, no transactions possible
        assertEquals(expectedProfit, StockTrader2.maxProfit(stockPrices));
    }

    @Test
    public void testAllSamePrices() {
        int[] stockPrices = {3, 3, 3, 3};
        int expectedProfit = 0; // No price changes, no profit possible
        assertEquals(expectedProfit, StockTrader2.maxProfit(stockPrices));
    }

    @Test
    public void testFluctuatingPrices() {
        int[] stockPrices = {1, 2, 3, 2, 3, 4, 1};
        int expectedProfit = 4;
        assertEquals(expectedProfit, StockTrader2.maxProfit(stockPrices));
    }

    @Test
    public void testPeakAtEnd() {
        int[] stockPrices = {1, 2, 3, 4, 5};
        int expectedProfit = 4; // Buy at 1, sell at 5
        assertEquals(expectedProfit, StockTrader2.maxProfit(stockPrices));
    }
}
