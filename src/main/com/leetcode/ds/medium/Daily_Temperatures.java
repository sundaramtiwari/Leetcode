/**
 *
 */
package com.leetcode.ds.medium;

import java.util.Stack;

/**
 * 739. Daily Temperatures
 *
 * {@linkplain https://leetcode.com/problems/daily-temperatures/}
 *
 * Given a list of daily temperatures T, return a list such that, for each day
 * in the input, tells you how many days you would have to wait until a warmer
 * temperature. If there is no future day for which this is possible, put 0
 * instead.
 *
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76,
 * 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 *
 * Note: The length of temperatures will be in the range [1, 30000]. Each
 * temperature will be an integer in the range [30, 100].
 *
 * @author s0t010t
 *
 */
public class Daily_Temperatures {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// int[] T = { 55, 38, 53, 81, 61, 93, 97, 32, 43, 78 };
		// int[] T = { 73, 74, 75, 71, 69, 72, 76, 73 };
		int[] T = { 89, 62, 70, 58, 47, 47, 46, 76, 100, 70 };
		int[] dailyTemps = Daily_Temperatures.dailyTemperatures(T);

		for (int i = 0; i < dailyTemps.length; i++) {
			System.out.print(dailyTemps[i] + " ");
		}

	}

	static public int[] dailyTemperatures(int[] temperatures) {
		int[] stack = new int[temperatures.length];
		int top = -1;
		int[] ret = new int[temperatures.length];
		for (int i = 0; i < temperatures.length; i++) {
			if (top > -1) {
				System.out.println(temperatures[i]);
				System.out.println(top);
				System.out.println(stack[top]);
				System.out.println(temperatures[stack[top]]);
			}
			while (top > -1 && temperatures[i] > temperatures[stack[top]]) {
				int idx = stack[top--];
				ret[idx] = i - idx;
			}
			stack[++top] = i;
		}
		return ret;
	}

	public static class Node {
		int index;
		int val;

		public int getIndex() {
			return this.index;
		}

		public int getVal() {
			return this.val;
		}

		public Node(int index, int val) {
			super();
			this.index = index;
			this.val = val;
		}

	}

	static public int[] dailyTemperatures46(int[] T) {

		int[] dailyTemp = new int[T.length];
		dailyTemp[dailyTemp.length - 1] = 0;

		Stack<Node> stack = new Stack<Node>();
		stack.push(new Node(dailyTemp.length - 1, T[T.length - 1]));

		if (T == null || T.length < 2)
			return dailyTemp;

		for (int i = T.length - 2; i >= 0; i--) {
			int temp = T[i];

			while (!stack.isEmpty() && stack.peek().getVal() <= temp) {
				stack.pop();
			}

			if (!stack.isEmpty()) {
				Node pop = stack.pop();
				dailyTemp[i] = pop.getIndex() - i;
				stack.push(pop);

			} else {
				dailyTemp[i] = 0;
			}

			stack.push(new Node(i, temp));
		}

		return dailyTemp;
	}

	static public int[] dailyTemperaturesBruteForce(int[] T) {

		int[] dailyTemp = new int[T.length];

		if (T == null || T.length < 2)
			return dailyTemp;

		for (int i = 0; i < T.length - 1; i++) {

			int temp = T[i];
			if (temp == 100) {
				dailyTemp[i] = 0;
				continue;
			}

			for (int j = i + 1; j < T.length; j++) {
				int curTemp = T[j];
				if (curTemp > temp) {
					dailyTemp[i] = j - i;
					break;
				}
			}
		}

		return dailyTemp;
	}
}
