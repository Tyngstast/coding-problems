package com.henrj.codingproblems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BuySellStockProblemTest {

    private final BuySellStockProblem problem = new BuySellStockProblem();

    @Test
    void priceGoesUpThenDownTest() {
        BuySellObject buySellObject = problem.getMaxProfitBuyDayAndSellDay(new int[] {1, 5, 3, 2});
        final int expected = 4;
        final int expectedBuyDay = 0;
        final int expectedSellDay = 1;
//        assertEquals(expected, buySellObject.maxProfit);
        assertEquals(expectedBuyDay, buySellObject.getBuyDay());
        assertEquals(expectedSellDay, buySellObject.getSellDay());
    }

    @Test
    void priceGoesDownThenUpTest() {
        BuySellObject buySellObject = problem.getMaxProfitBuyDayAndSellDay(new int[] {7, 2, 8, 9});
        final int expected = 7;
        final int expectedBuyDay = 1;
        final int expectedSellDay = 3;
//        assertEquals(expected, buySellObject.maxProfit);
        assertEquals(expectedBuyDay, buySellObject.getBuyDay());
        assertEquals(expectedSellDay, buySellObject.getSellDay());
    }

    @Test
    void priceGoesUpAllDayTest() {
        BuySellObject buySellObject = problem.getMaxProfitBuyDayAndSellDay(new int[] {1, 6, 7, 9});
        final int expected = 8;
        final int expectedBuyDay = 0;
        final int expectedSellDay = 3;
//        assertEquals(expected, buySellObject.maxProfit);
        assertEquals(expectedBuyDay, buySellObject.getBuyDay());
        assertEquals(expectedSellDay, buySellObject.getSellDay());
    }

    @Test
    void priceVariesTest() {
        BuySellObject buySellObject = problem.getMaxProfitBuyDayAndSellDay(new int[] {7, 12, 5, 3, 11, 5, 10, 2, 9});
        final int expected = 8;
        final int expectedBuyDay = 3;
        final int expectedSellDay = 4;
//        assertEquals(expected, buySellObject.maxProfit);
        assertEquals(expectedBuyDay, buySellObject.getBuyDay());
        assertEquals(expectedSellDay, buySellObject.getSellDay());
    }

    @Test
    void priceGoesDownAllDayTest() {
        BuySellObject buySellObject = problem.getMaxProfitBuyDayAndSellDay(new int[] {9, 7, 4, 1});
        final int expected = -2;
        final int expectedBuyDay = 0;
        final int expectedSellDay = 1;
//        assertEquals(expected, buySellObject.maxProfit);
        assertEquals(expectedBuyDay, buySellObject.getBuyDay());
        assertEquals(expectedSellDay, buySellObject.getSellDay());
    }

    @Test
    void priceGoesDownAllDay2Test() {
        BuySellObject buySellObject = problem.getMaxProfitBuyDayAndSellDay(new int[] {9, 7, 6, 1});
        final int expected = -1;
        final int expectedBuyDay = 1;
        final int expectedSellDay = 2;
//        assertEquals(expected, buySellObject.maxProfit);
        assertEquals(expectedBuyDay, buySellObject.getBuyDay());
        assertEquals(expectedSellDay, buySellObject.getSellDay());
    }

    @Test
    void priceStaysTheSameAllDayTest() {
        BuySellObject buySellObject = problem.getMaxProfitBuyDayAndSellDay(new int[] {1, 1, 1, 1});
        final int expected = 0;
        final int expectedBuyDay = 0;
        final int expectedSellDay = 1;
//        assertEquals(expected, buySellObject.maxProfit);
        assertEquals(expectedBuyDay, buySellObject.getBuyDay());
        assertEquals(expectedSellDay, buySellObject.getSellDay());
    }

    @Test
    void exceptionWithOnePriceTest() {
        assertThrows(Exception.class, () -> problem.getMaxProfitBuyDayAndSellDay(new int[] {5}));
    }

    @Test
    void exceptionWithEmptyPricesTest() {
        assertThrows(Exception.class, () -> problem.getMaxProfitBuyDayAndSellDay(new int[] {}));
    }

    @Test
    void priceVariesUnlimitedTransactionsTest() {
        int profit = problem.maxProfitWithUnlimitedTransactions(new int[]{7,1,5,3,6,4});
        final int expectedProfit = 7;
        assertEquals(expectedProfit, profit);
    }

    @Test
    void priceGoesDownAllDayWithUnlimitedTransactionsTest() {
        int profit = problem.maxProfitWithUnlimitedTransactions(new int[] {9, 7, 4, 1});
        final int expectedProfit = -2;
        assertEquals(expectedProfit, profit);
    }

    @Test
    void priceGoesUpAllDayWithUnlimitedTransactionsTest() {
        int profit = problem.maxProfitWithUnlimitedTransactions(new int[] {1,2,3,4,5});
        final int expectedProfit = 4;
        assertEquals(expectedProfit, profit);
    }

    @Test
    void priceGoesUpAndDown2WithUnlimitedTransactionsTest() {
        int profit = problem.maxProfitWithUnlimitedTransactions(new int[] {6,1,3,2,4,7});
        final int expectedProfit = 7;
        assertEquals(expectedProfit, profit);
    }

    @Test
    void priceGoesUpAndDown3WithUnlimitedTransactionsTest() {
        int profit = problem.maxProfitWithUnlimitedTransactions(new int[] {2,1,2,0,1});
        final int expectedProfit = 2;
        assertEquals(expectedProfit, profit);
    }

    @Test
    void priceGoesUpAndDownWithKTransactionsTest() {
        int profit = problem.maxProfitWithKTransactions(new int[] {2,4,1}, 2);
        final int expectedProfit = 2;
        assertEquals(expectedProfit, profit);
    }

    @Test
    void priceGoesUpAndDown2WithKTransactionsTest() {
        int profit = problem.maxProfitWithKTransactions(new int[] {3,2,6,5,0,3}, 2);
        final int expectedProfit = 7;
        assertEquals(expectedProfit, profit);
    }

    @Test
    void priceGoesUpAndDown3WithKTransactionsTest() {
        int profit = problem.maxProfitWithKTransactions(new int[] {2,1,2,0,1}, 2);
        final int expectedProfit = 2;
        assertEquals(expectedProfit, profit);
    }

    @Test
    void priceDownAllDayWithKTransactionsTest() {
        int profit = problem.maxProfitWithKTransactions(new int[] {9,8,5,3,1}, 3);
        final int expectedProfit = 0;
        assertEquals(expectedProfit, profit);
    }


}
