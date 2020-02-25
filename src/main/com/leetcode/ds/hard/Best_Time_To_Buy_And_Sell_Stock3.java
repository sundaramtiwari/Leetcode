/**
 *
 */
package com.leetcode.ds.hard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 123. Best Time to Buy and Sell Stock III
 * {@link https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/}
 *
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most two
 * transactions.
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you
 * must sell the stock before you buy again).
 *
 * Example 1: Input: [3,3,5,0,0,3,1,4] Output: 6 Explanation: Buy on day 4
 * (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3. Then buy on day
 * 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
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
public class Best_Time_To_Buy_And_Sell_Stock3 {

	public static void main(String[] args) {
		// int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
		// int[] prices = { 1, 2, 3, 4, 5 };
		// int[] prices = { 7, 6, 4, 3, 1 };
		int[] prices = { 1, 2, 4, 2, 5, 7, 2, 4, 9, 0 };
		// 1,4 = 3; 2,7 = 5; 2,9 = 7. Total = 7 + 5 = 12;
		System.out.println(maxProfit(prices));
	}

	static public int maxProfit(int[] prices) {
		int maxProfit = 0;

		int minPrice = Integer.MAX_VALUE;

		Map<Integer, List<Node>> map = new HashMap<>();

		for (int i = 0; i < prices.length-1; i++) {
			int price = prices[i];

			for (int j=i+1; j < prices.length; j++) {
				int profit = 0;
				int curPrice = prices[j];

				if (curPrice > minPrice) {
					profit = curPrice - minPrice;
					Node node = new Node(i, j, profit);
					// map.put(j, value)
				}
			}

		}


		return maxProfit;
	}

	public static class Node {
		int x;
		int y;
		int profit;

		public int getX() {
			return this.x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return this.y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public int getProfit() {
			return this.profit;
		}

		public void setProfit(int profit) {
			this.profit = profit;
		}

		public Node(int x, int y, int profit) {
			super();
			this.x = x;
			this.y = y;
			this.profit = profit;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + this.profit;
			result = prime * result + this.x;
			result = prime * result + this.y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (this.getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (this.profit != other.profit)
				return false;
			if (this.x != other.x)
				return false;
			if (this.y != other.y)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Node [x=" + this.x + ", y=" + this.y + ", profit=" + this.profit + "]";
		}

	}
}
