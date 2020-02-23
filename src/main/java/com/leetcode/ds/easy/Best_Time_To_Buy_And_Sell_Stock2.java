/**
 *
 */
package com.leetcode.ds.easy;

/**
 * 122. Best Time to Buy and Sell Stock II
 * {@link https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/}
 *
 * Say you have an array for which the ith element is the price of a given stock
 * on day i. Design an algorithm to find the maximum profit. You may complete as
 * many transactions as you like (i.e., buy one and sell one share of the stock
 * multiple times).
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you
 * must sell the stock before you buy again).
 *
 * Example 1: Input: [7,1,5,3,6,4] Output: 7 Explanation: Buy on day 2 (price =
 * 1) and sell on day 3 (price = 5), profit = 5-1 = 4. Then buy on day 4 (price
 * = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 *
 * Example 2: Input: [1,2,3,4,5] Output: 4 Explanation: Buy on day 1 (price = 1)
 * and sell on day 5 (price = 5), profit = 5-1 = 4. Note that you cannot buy on
 * day 1, buy on day 2 and sell them later, as you are engaging multiple
 * transactions at the same time. You must sell before buying again.
 *
 * Example 3: Input: [7,6,4,3,1] Output: 0 Explanation: In this case, no
 * transaction is done, i.e. max profit = 0.
 *
 * @author s0t010t
 *
 */
public class Best_Time_To_Buy_And_Sell_Stock2 {

	public static void main(String[] args) {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		// int[] prices = { 1, 2, 3, 4, 5 };
		// int[] prices = { 7, 6, 4, 3, 1 };
		// int[] prices = { 7, 6, 4, 3, 1 };
		System.out.println(maxProfit(prices));
	}

	static public int maxProfit(int[] prices) {

		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;
		int profit = 0;

		for (int i = 0; i < prices.length; i++) {

			int curPrice = prices[i]; // 7, 1, 5

			// if curPrice < minPrice, assign it to minPrice
			if (curPrice < minPrice)
				minPrice = curPrice; // 7, 1, MAX_VAL,

			if (curPrice - minPrice > profit) {
				maxProfit += curPrice - minPrice;
				minPrice = curPrice;
				profit = 0;
			}
		}

		return maxProfit;
	}
}
