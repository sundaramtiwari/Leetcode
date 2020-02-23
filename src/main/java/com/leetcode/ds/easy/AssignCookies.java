/**
 *
 */
package com.leetcode.ds.easy;

import java.util.Arrays;

/**
 * 455. Assign Cookies
 *
 * {@linkplain https://leetcode.com/problems/assign-cookies/}
 *
 * Assume you are an awesome parent and want to give your children some cookies.
 * But, you should give each child at most one cookie. Each child i has a greed
 * factor gi, which is the minimum size of a cookie that the child will be
 * content with; and each cookie j has a size sj. If sj >= gi, we can assign the
 * cookie j to the child i, and the child i will be content. Your goal is to
 * maximize the number of your content children and output the maximum number.
 *
 * Note: You may assume the greed factor is always positive. You cannot assign
 * more than one cookie to one child.
 *
 * @author s0t010t
 *
 */
public class AssignCookies {

	public static void main(String[] args) {

		int[] g = { 1, 2, 3 };
		int[] s = { 1, 1 };

		System.out.println(findContentChildren(g, s));
	}

	static public int findContentChildren(int[] g, int[] s) {
		int count = 0;

		Arrays.sort(s);
		Arrays.sort(g);

		for (int i = 0; i < g.length; i++) {
			int j = i;

			while (j < s.length && g[i] > s[j]) {
				j++;
			}

			if (j >= s.length)
				break;

			count++;
		}

		return count;
	}
}
