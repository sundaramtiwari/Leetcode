/**
 *
 */
package com.leetcode.ds.easy;

/**
 * 7. Reverse Integer. {@link https://leetcode.com/problems/reverse-integer/}
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Input: -123 Output: -321
 *
 * Input: 120 Output: 21
 *
 * @author s0t010t
 *
 */
public class ReverseInteger {

	public static void main(String[] args) {

		System.out.println(reverseNew(-1234567700));
	}

	static public int reverseNew(int x) {

		String str = String.valueOf(x);
		StringBuilder sbr = new StringBuilder(str);
		StringBuilder reverse = sbr.reverse();
		if (reverse.charAt(reverse.length() - 1) == '-') {
			reverse.insert(0, '-');
			reverse.delete(reverse.length() - 1, reverse.length());
		}

		long reverseNum = Long.valueOf(reverse.toString());
		if (reverseNum > Integer.MAX_VALUE || reverseNum < Integer.MIN_VALUE)
			reverseNum = 0;
		return (int) reverseNum;
	}

	static public int reverse(int x) {

		int noOfDigits = countDigit(x);

		int digit = 0;
		long reverseNum = 0;

		for (int i = 1; i <= noOfDigits; i++) {
			digit = x % 10;
			reverseNum += digit * Math.pow(10, noOfDigits - i);
			x = (int) Math.floor(x / 10);
		}

		if (reverseNum > Integer.MAX_VALUE || reverseNum < Integer.MIN_VALUE)
			reverseNum = 0;

		return (int) reverseNum;
	}

	static int countDigit(int n) {
		int count = 0;
		while (n != 0) {
			n = n / 10;
			++count;
		}
		return count;
	}
}
