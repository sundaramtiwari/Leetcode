/**
 *
 */
package com.leetcode.ds.medium;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 3. Longest Substring Without Repeating Characters
 * {@link https://leetcode.com/problems/longest-substring-without-repeating-characters/}
 *
 * Longest Substring Without Repeating Characters
 *
 * Given a string, find the length of the longest substring without repeating
 * characters.
 *
 * @author s0t010t
 *
 */
public class Longest_SubString_WO_Repeating_Characters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(lengthOfLongestSubstring("abcabcbb"));

	}

	public static int lengthOfLongestSubstring(String s) {
		char[] strArr = s.toCharArray();
		String longestSubString = "";
		StringBuilder sbr = new StringBuilder();
		Set<Character> tempSubStringSet = new HashSet<Character>();

		// jbpnbwwd
		for (int i = 0; i < strArr.length; i++) {
			char ch = strArr[i];

			if (tempSubStringSet.contains(ch)) {
				if (sbr.length() > longestSubString.length()) {
					longestSubString = sbr.toString();
					sbr = new StringBuilder();

					int lastIndexOf = longestSubString.lastIndexOf(ch);
					String substring = longestSubString.substring(lastIndexOf+1);
					sbr.append(substring);
					sbr.append(ch);
					tempSubStringSet = new HashSet<>();
					char[] charArray = substring.toCharArray();
					for (int j=0; j<charArray.length; j++)
						tempSubStringSet.add(charArray[j]);
					tempSubStringSet.add(ch);

				} else {

					String temp = sbr.toString();
					int lastIndexOf = temp.lastIndexOf(ch);
					String substring = temp.substring(lastIndexOf+1);
					sbr = new StringBuilder();
					sbr.append(substring);
					sbr.append(ch);
					tempSubStringSet = new HashSet<>();
					char[] charArray = substring.toCharArray();
					for (int j=0; j<charArray.length; j++)
						tempSubStringSet.add(charArray[j]);
					tempSubStringSet.add(ch);
				}

			} else {
				sbr.append(ch);
				tempSubStringSet.add(ch);
			}

		}

		if (sbr.length() > longestSubString.length())
			longestSubString = sbr.toString();

		//System.out.println("Longest Substring: " + longestSubString);
		return longestSubString.length();
	}

}
