package com.leetcode.ds.medium;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 5. Longest Palindromic Substring
 *
 * {@link https://leetcode.com/problems/longest-palindromic-substring/}
 *
 * Given a string s, find the longest palindromic substring in s. You may assume
 * that the maximum length of s is 1000.
 *
 * @author s0t010t
 *
 */
public class Longest_Palindromic_Substring {

	public static void main(String[] args) {
		//		System.out.println(Longest_Palindromic_Substring.newLongestPalindrome("a"));
		//		System.out.println(Longest_Palindromic_Substring.newLongestPalindrome("aaaa"));
		//		System.out.println(Longest_Palindromic_Substring.newLongestPalindrome("aaaabaaa"));
		//		System.out.println(Longest_Palindromic_Substring.newLongestPalindrome("tattarrattat"));
		//		System.out.println(Longest_Palindromic_Substring.newLongestPalindrome("bb"));
		// System.out.println(Longest_Palindromic_Substring.newLongestPalindrome("bbb"));
		System.out.println("Palindrome:   " + Longest_Palindromic_Substring.newLongestPalindrome("dddddddd"));
	}

	static public String newLongestPalindrome(String s) {

		System.out.println("Input string: " + s);
		if ((s == null) || s.equals("")) {
			return "";
		}

		char[] strArr = s.toCharArray();
		Set<Node> palindromes = new HashSet<>();

		for (int i = 0; i < strArr.length; i++) {
			if ((i >= 0) && (i < (strArr.length - 1)) && (strArr[i] == strArr[i + 1])) {
				palindromes.add(new Node(i, i + 1));
			}

			if ((i > 0) && ((i < (strArr.length - 1)) && (strArr[i - 1] == strArr[i + 1]))) {
				palindromes.add(new Node(i, i));
			}
		}

		int maxIndex = -1;
		int maxLength = 0;
		int maxYIndex = -1;

		for (Node node : palindromes) {
			int i = 1;
			int index = node.getX();
			int yIndex = node.getY();
			// babadcda
			while ((((index - i) >= 0) && ((yIndex + i) < strArr.length))
					&& (strArr[index - i] == strArr[yIndex + i])) {
				i++;
			}

			if (i > maxLength) {
				maxIndex = index;
				maxYIndex = yIndex;
				maxLength = i - 1;
			}
		}

		if (!palindromes.isEmpty()) {

			int startIndex = maxIndex - maxLength;
			int endIndex = maxYIndex + maxLength + 1;

			String palindrome = s.substring(startIndex, endIndex);

			return palindrome;

		} else {
			return String.valueOf(strArr[0]);
		}

	}

	static public String longestPalindrome(String s) {

		if ((s == null) || s.equals("")) {
			return "";
		}

		char[] strArr = s.toCharArray();
		Set<Integer> palindromes = new HashSet<>();

		for (int i = 0; i < strArr.length; i++) {
			if ((i > 0) && (i < (strArr.length - 1))) {
				if (strArr[i-1] == strArr[i+1]) {
					palindromes.add(i);
				}
			}
		}

		int maxIndex = -1;
		int maxLength = 0;

		for (int index : palindromes) {
			int i = 1;
			// babadcda
			while((((index-i) >= 0) && ((index+i) < strArr.length)) && (strArr[index - i] == strArr[index + i])) {
				i++;
			}

			if (i > maxLength) {
				maxIndex = index;
				maxLength = i-1;
			}
		}

		if (maxLength >= 1) {
			int startIndex = maxIndex-maxLength;
			int endIndex = maxIndex+maxLength+1;

			String palindrome = s.substring(startIndex, endIndex);

			char[] charArray = palindrome.toCharArray();

			boolean sameFlag = true;
			char ch = charArray[0];
			for (char element : charArray) {
				if (ch != element) {
					sameFlag = false;
					break;
				}
			}

			if (sameFlag) {
				char lastChar = palindrome.charAt(palindrome.length() - 1);
				char startChar = palindrome.charAt(0);

				if ((startIndex > 0) && (s.charAt(startIndex - 1) == startChar)) {
					palindrome = startChar + palindrome;
				}

				if ((endIndex < (s.length() - 1)) && (s.charAt(endIndex + 1) == lastChar)) {
					palindrome = palindrome + lastChar;
				}
			}
			return palindrome;

		} else {
			// abb
			char[] charArray = s.toCharArray();

			for (int i = 0; i < (charArray.length-1); i++) {
				char c = charArray[i];
				if (c == charArray[i+1]) {
					return String.valueOf(c) + String.valueOf(c);
				}
			}

			return String.valueOf(charArray[0]);
		}
	}

	static class Node {
		private int x;
		private int y;

		public Node() {
		};

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return this.x;
		}

		public int getY() {
			return this.y;
		}
	}
}
