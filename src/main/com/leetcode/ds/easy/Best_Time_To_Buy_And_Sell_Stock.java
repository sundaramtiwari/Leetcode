/**
 *
 */
package com.leetcode.ds.easy;

/**
 * 121. Best Time to Buy and Sell Stock
 * {@link https://leetcode.com/problems/best-time-to-buy-and-sell-stock/}
 *
 * Say you have an array for which the ith element is the price of a given stock
 * on day i. If you were only permitted to complete at most one transaction
 * (i.e., buy one and sell one share of the stock), design an algorithm to find
 * the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *
 * Example 1: Input: [7,1,5,3,6,4] Output: 5 Explanation: Buy on day 2 (price =
 * 1) and sell on day 5 (price = 6), profit = 6-1 = 5. Not 7-1 = 6, as selling
 * price needs to be larger than buying price.
 *
 * Example 2: Input: [7,6,4,3,1] Output: 0 Explanation: In this case, no
 * transaction is done, i.e. max profit = 0.
 *
 * @author s0t010t
 *
 */
public class Best_Time_To_Buy_And_Sell_Stock {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4, 8};
        //		int[] prices = { 7, 6, 4, 3, 1 };
        System.out.println(maxProfitNew(prices));
    }

    static public int maxProfit(int[] prices) {

        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];

            for (int j = i + 1; j < prices.length; j++) {
                int curPrice = prices[j];

                // If price is increased, we can sell
                if (price < curPrice && ((curPrice - price) > maxProfit)) {
                    maxProfit = curPrice - price;
                }
            }
        }

        return maxProfit;
    }

    static public int maxProfitNew(int[] prices) {

        // { 7, 1, 5, 3, 6, 4, 8 }

        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int n = prices.length;
        int[] minPrice = new int[n]; // {0, 0, 0, 0 ,0 ,0}
        int[] maxProfit = new int[n];// {0, 0, 4, 4, 5, 5}
        minPrice[0] = prices[0]; // {7, 1, 1, 1, 1, 1, 1}
        maxProfit[0] = 0; // {0, 0, 0, 0 ,0 ,0}

        for (int i = 1; i < n; i++) {
            minPrice[i] = Math.min(minPrice[i - 1], prices[i]);
            maxProfit[i] = Math.max(maxProfit[i - 1], prices[i] - minPrice[i - 1]);
        }

        return maxProfit[n - 1];
    }

    static public int maxProfitBest(int[] prices) {

        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int price : prices) {
            if (price < minprice)
                minprice = price;
            else if (price - minprice > maxprofit)
                maxprofit = price - minprice;
        }

        return maxprofit;

    }
}
