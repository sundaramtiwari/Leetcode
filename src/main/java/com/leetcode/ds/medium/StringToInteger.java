package com.leetcode.ds.medium;

/**
 * 8. String To Integer
 * {@link https://leetcode.com/problems/string-to-integer-atoi/}
 *
 * Implement atoi which converts a string to an integer.
 *
 * The function first discards as many whitespace characters as necessary until
 * the first non-whitespace character is found. Then, starting from this
 * character, takes an optional initial plus or minus sign followed by as many
 * numerical digits as possible, and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the
 * integral number, which are ignored and have no effect on the behavior of this
 * function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid
 * integral number, or if no such sequence exists because either str is empty or
 * it contains only whitespace characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned.
 *
 * Note: Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−2^31, 2^31 − 1]. If the numerical
 * value is out of the range of representable values, INT_MAX (2^31 − 1) or
 * INT_MIN (−2^31) is returned.
 *
 * @author s0t010t
 *
 */
public class StringToInteger {

	public static void main(String[] args) {

		System.out.println(myAtoi("20000000000000000000"));

		// Long.parseLong("20000000000000000000");
	}

	static public int myAtoi(String str) {

		long val = 0;
		boolean digitIdentified = false;
		StringBuilder sbr = new StringBuilder();
		char[] charArray = str.toCharArray();

		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];

			if (!digitIdentified && Character.isWhitespace(c)) {
				continue;

			} else if (!digitIdentified && c == '-') {
				digitIdentified = true;
				sbr.append(c);

			} else if (!digitIdentified && c == '+') {
				digitIdentified = true;
				continue;

			} else if (Character.isDigit(c)) {
				sbr.append(c);
				digitIdentified = true;
				if (!sbr.toString().equals("-")) {
					try {
						val = Long.parseLong(sbr.toString());
						if (val > Integer.MAX_VALUE) {
							val = Integer.MAX_VALUE;
							return (int) val;
						} else if (val < Integer.MIN_VALUE) {
							val = Integer.MIN_VALUE;
							return (int) val;
						}
					} catch (NumberFormatException e) {
					}
				}

			} else if (digitIdentified && !Character.isDigit(c)) {
				break;
			} else {
				break;
			}
		}

		if (!sbr.toString().equals("-") && !sbr.toString().equals("")) {
			try {
				val = Long.parseLong(sbr.toString());
			} catch (NumberFormatException e) {
			}
		}

		if (val > Integer.MAX_VALUE)
			val = Integer.MAX_VALUE;

		else if (val < Integer.MIN_VALUE)
			val = Integer.MIN_VALUE;

		return (int) val;
	}

}
