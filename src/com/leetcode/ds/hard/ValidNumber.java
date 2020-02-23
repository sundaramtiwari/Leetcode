/**
 *
 */
package com.leetcode.ds.hard;

/**
 * 65. Valid Number
 *
 * {@link https://leetcode.com/problems/valid-number/}
 *
 * Validate if a given string can be interpreted as a decimal number.
 *
 * Some examples: "0" => true " 0.1 " => true "abc" => false "1 a" => false
 * "2e10" => true " -90e3 " => true " 1e" => false "e3" => false " 6e-1" => true
 * " 99e2.5 " => false "53.5e93" => true " --6 " => false "-+3" => false
 * "95a54e53" => false
 *
 * Note: It is intended for the problem statement to be ambiguous. You should
 * gather all requirements up front before implementing one. However, here is a
 * list of characters that can be in a valid decimal number:
 *
 * Numbers 0-9 Exponent - "e" Positive/negative sign - "+"/"-" Decimal point -
 * "." Of course, the context of these characters also matters in the input.
 *
 *
 * @author s0t010t
 *
 */
public class ValidNumber {

	public static void main(String[] args) {
		// "46.e3" ".e1"
		String s = "32.e-80123";
		System.out.println(String.format("String %s is a valid numer: %s", s, isNumber(s)));
	}

	static public boolean isNumber(String s) {
		s = s.trim();
		boolean signFound = false;
		boolean digitFound = false;
		boolean expFound = false;
		boolean decimalFound = false;

		char[] charArray = s.toCharArray();

		boolean digitAvail = false;
		for (int i = 0; i < charArray.length; i++) {
			if (Character.isDigit(charArray[i])) {
				digitAvail = true;
				break;
			} else if (charArray[i] == 'e')
				break;
		}

		if (!digitAvail) {
			return false;
		}

		for (int i = 0; i < charArray.length; i++) {
			char ch = charArray[i];

			if ((ch == '+' || ch == '-') && (!digitFound || expFound) && !signFound) {
				signFound = true;
				digitFound = false;
				continue;

			} else if (Character.isDigit(ch)) {
				digitFound = true;
				continue;

			} else if (ch == '.' && !decimalFound && !expFound) {
				decimalFound = true;
				digitFound = false;
				continue;

			} else if (ch == 'e' && !expFound && (digitFound || decimalFound)) {
				expFound = true;
				digitFound = false;
				signFound = false;
				continue;
			} else {
				return false;
			}
		}

		if (expFound && !digitFound)
			return false;

		return true;
	}

}
