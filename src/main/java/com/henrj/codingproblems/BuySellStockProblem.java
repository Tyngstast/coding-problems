package com.henrj.codingproblems;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class BuySellStockProblem {

    int getMaxProfit(int[] stockPrices) {
        if (stockPrices.length < 2) {
            throw new IllegalArgumentException("Cannot get profit with only one value");
        }

        int minPrice = stockPrices[0];
        int maxProfit = stockPrices[1] - stockPrices[0];

        for (int i = 1; i < stockPrices.length; i++) {
            maxProfit = Math.max(maxProfit, stockPrices[i] - minPrice);
            minPrice = Math.min(minPrice, stockPrices[i]);
        }

        return maxProfit;
    }

    BuySellObject getMaxProfitBuyDaySellDaySingleMethod(int[] stockPrices) {
        if (stockPrices == null || stockPrices.length < 2) {
            throw new IllegalArgumentException("Cannot get profit with only one value");
        }

        BuySellObject buySellObject = new BuySellObject();
        buySellObject.setMaxProfit(stockPrices[1] - stockPrices[0]);
        buySellObject.setSellDay(1);
        buySellObject.setBuyDay(0);

        int minPrice = stockPrices[0];

        for (int i = 1; i < stockPrices.length; i++) {
            int potentialProfit = stockPrices[i] - minPrice;
            if (potentialProfit > buySellObject.getMaxProfit()) {
                buySellObject.setMaxProfit(potentialProfit);
                buySellObject.setSellDay(i);
            }
            if (stockPrices[i] < minPrice) {
                minPrice = stockPrices[i];
                buySellObject.setBuyDay(i);
            }
        }

        // When price goes down all day we always buy the day before we optimally sell
        if (buySellObject.getMaxProfit() < 0) {
            buySellObject.setBuyDay(buySellObject.getSellDay() - 1);
        }

        return buySellObject;
    }

    BuySellObject getMaxProfitBuyDayAndSellDay(int[] stockPrices) {
        if (stockPrices == null || stockPrices.length < 2) {
            throw new IllegalArgumentException("Cannot get profit with only one value");
        }

        BuySellObject buySellObject = new BuySellObject();
        buySellObject.setBuyDay(getBuyDay(stockPrices));
        buySellObject.setSellDay(getSellDay(stockPrices));

        return buySellObject;
    }


    private int getBuyDay(int[] stockPrices) {
        int buyDay = 0;
        int maxProfit = stockPrices[stockPrices.length - 1] - stockPrices[stockPrices.length - 2];
        int maxPrice = stockPrices[stockPrices.length - 1];

        for (int i = stockPrices.length - 2; i >= 0; i--) {

            int potentialProfit = maxPrice - stockPrices[i];

            if (potentialProfit > maxProfit) {
                maxProfit = potentialProfit;
                buyDay = i;
            }

            maxPrice = Math.max(maxPrice, stockPrices[i]);
        }

        return buyDay;
    }

    private int getSellDay(int[] stockPrices) {
        int sellDay = 1;
        int minPrice = stockPrices[0];
        int maxProfit = stockPrices[1] - stockPrices[0];

        for (int i = 1; i < stockPrices.length; i++) {

            int potentialProfit = stockPrices[i] - minPrice;

            if (potentialProfit > maxProfit) {
                maxProfit = potentialProfit;
                sellDay = i;
            }

            minPrice = Math.min(minPrice, stockPrices[i]);
        }

        return sellDay;
    }

    BuySellObject getMaxProfitInefficiently(int[] stockPrices) {
        if (stockPrices == null || stockPrices.length < 2) {
            throw new IllegalArgumentException("Cannot get profit with only one value");
        }

        BuySellObject buySellObject = new BuySellObject();
        buySellObject.setMaxProfit(stockPrices[1] - stockPrices[0]);
        buySellObject.setSellDay(1);
        buySellObject.setBuyDay(0);

        int minPrice = stockPrices[0];

        for (int i = 0; i < stockPrices.length-1; i++) {
            if (stockPrices[i] < minPrice) {
                minPrice = stockPrices[i];
                buySellObject.setBuyDay(i);
            }
            for (int j = i+1; j < stockPrices.length; j++) {
                if (stockPrices[j] - minPrice > buySellObject.getMaxProfit()) {
                    buySellObject.setMaxProfit(stockPrices[j] - minPrice);
                    buySellObject.setSellDay(j);
                }
            }
        }
        return buySellObject;
    }

    int maxProfitWithUnlimitedTransactions(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = prices[1] - prices[0];
        int maxProfitTotal = 0;

        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);

            // Price goes down so we sell and re-buy at higher price
            if (prices.length > i+1 && maxProfit != 0 && prices[i+1] < prices[i]) {
                maxProfitTotal += maxProfit;
                maxProfit = 0;
                minPrice = prices[i+1];
            }
        }

        // Add final profit (0 if there was no increase in price after last sell)
        maxProfitTotal += maxProfit;

        return maxProfitTotal;
    }

    int maxProfitWithKTransactions(int[] prices, int k) {
        if (prices.length < 2) {
            return 0;
        }

        List<Integer> maxProfits = new ArrayList<>();
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);

            // Price goes down so we sell and re-buy at higher price
            if (prices.length > i+1 && maxProfit != 0 && prices[i+1] < prices[i]) {
                maxProfits.add(maxProfit);
                maxProfit = 0;
                minPrice = prices[i+1];
            }
        }

        maxProfits.add(maxProfit);

        int maxTotal = 0;

        maxProfits.sort(Comparator.reverseOrder());
        maxProfits = maxProfits.subList(0, Math.min(maxProfits.size(), k));

        for (Integer profit : maxProfits) {
            maxTotal += profit;
        }

        return maxTotal;
    }
}

@Data
@NoArgsConstructor
class BuySellObject {
    private int buyDay;
    private int sellDay;
    private int maxProfit;
}
