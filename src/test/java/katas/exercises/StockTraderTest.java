package katas.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StockTraderTest {

    @Test
    void testMaxProfitWithValidInput() {
        int[] stockPrices = {7, 1, 5, 3, 6, 4};
        assertEquals(5, StockTrader.maxProfit(stockPrices));
    }

    @Test
    void testMaxProfitNoProfitPossible() {
        int[] stockPrices = {7, 6, 4, 3, 1};
        assertEquals(0, StockTrader.maxProfit(stockPrices));
    }

    @Test
    void testMaxProfitWithSinglePrice() {
        int[] stockPrices = {5};
        assertEquals(0, StockTrader.maxProfit(stockPrices));
    }

    @Test
    void testMaxProfitWithEmptyArray() {
        int[] stockPrices = {};
        assertEquals(0, StockTrader.maxProfit(stockPrices));
    }

    @Test
    void testMaxProfitWithNullArray() {
        int[] stockPrices = null;
        assertEquals(0, StockTrader.maxProfit(stockPrices));
    }

    @Test
    void testMaxProfitWithIncreasingPrices() {
        int[] stockPrices = {1, 2, 3, 4, 5};
        assertEquals(4, StockTrader.maxProfit(stockPrices));
    }

    @Test
    void testMaxProfitWithDecreasingAndThenIncreasingPrices() {
        int[] stockPrices = {10, 7, 1, 3, 9};
        assertEquals(8, StockTrader.maxProfit(stockPrices));
    }
}
