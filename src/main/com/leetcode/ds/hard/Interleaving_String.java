/**
 *
 */
package com.leetcode.ds.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * 97. Interleaving String
 * {@link https://leetcode.com/problems/interleaving-string/}
 *
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 *
 * @author s0t010t
 *
 */
public class Interleaving_String {

	static Set<InterleavingStrings> interleavingSet = new HashSet<>();
	static Set<InterleavingStrings> nonInterleavingSet = new HashSet<>();

	public static void main(String[] args) {

		String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
		//		String s1 = "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa";
		//		String s2 = "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
		//		String s3 = "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";

		System.out.println(isInterleave(s1, s2, s3));
	}

	public static boolean isInterleave(String s1, String s2, String s3) {

		InterleavingStrings is = new InterleavingStrings(s1, s2, s3);
		if (Interleaving_String.interleavingSet.contains(is)) {
			return true;
		} else if (Interleaving_String.nonInterleavingSet.contains(is)) {
			return false;
		}
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}

		//		System.out.println("s1: " + s1);
		//		System.out.println("s2: " + s2);
		//		System.out.println("s3: " + s3);

		if (s1.equals("") && s2.equals("") && s3.equals(""))
			return true;

		char[] s1Arr = s1.toCharArray();
		char[] s2Arr = s2.toCharArray();
		char[] s3Arr = s3.toCharArray();

		Map<Character, Integer> map1 = new HashMap<>();
		Map<Character, Integer> map2 = new HashMap<>();

		for (int i = 0; i < s1Arr.length; i++) {
			char ch = s1Arr[i];
			if (map1.containsKey(ch)) {
				map1.put(ch, map1.get(ch) + 1);
			} else {
				map1.put(ch, 1);
			}
		}

		for (int i = 0; i < s2Arr.length; i++) {
			char ch = s2Arr[i];
			if (map1.containsKey(ch)) {
				map1.put(ch, map1.get(ch) + 1);
			} else {
				map1.put(ch, 1);
			}
		}

		for (int i = 0; i < s3Arr.length; i++) {
			char ch = s3Arr[i];
			if (map2.containsKey(ch)) {
				map2.put(ch, map2.get(ch) + 1);
			} else {
				map2.put(ch, 1);
			}
		}

		if (!map1.equals(map2))
			return false;

		boolean interleaving = false;

		int s1p = 0, s2p = 0;

		for (int i = 0; i < s3Arr.length; i++) {
			char ch = s3Arr[i];

			if ((s1p < s1Arr.length && s1Arr[s1p] == ch) && (s2p < s2Arr.length && s2Arr[s2p] != ch)) {
				s1p++;
				continue;

			} else if ((s1p < s1Arr.length && s1Arr[s1p] != ch) && (s2p < s2Arr.length && s2Arr[s2p] == ch)) {
				s2p++;
				continue;

			} else if ((s1p < s1Arr.length && s1Arr[s1p] == ch) && (s2p < s2Arr.length && s2Arr[s2p] == ch)) {

				if (i + 1 == s3.length() && s1p == s1Arr.length && s2p == s2Arr.length) {
					interleaving = true;
					break;
				}

				if (s1p < s1.length() && s2p < s2.length()) {
					interleaving = isInterleave(s1.substring(s1p + 1), s2.substring(s2p), s3.substring(i + 1))
							|| isInterleave(s1.substring(s1p), s2.substring(s2p + 1), s3.substring(i + 1));
					break;
				} else {
					break;
				}

			}

			if (s1p == s1Arr.length) {
				interleaving = s3.substring(i).equals(s2.substring(s2p));
				s2p++;
				break;

			} else if (s2p == s2.length()) {
				interleaving = s3.substring(i).equals(s1.substring(s1p));
				s1p++;
				break;
			}
		}

		if (interleaving == true)
			Interleaving_String.interleavingSet.add(is);
		else
			Interleaving_String.nonInterleavingSet.add(is);

		return interleaving;
	}

	static class InterleavingStrings
	{
		private String first;
		private String second;
		private String third;

		public InterleavingStrings(String first, String second, String third) {
			this.first = first;
			this.second = second;
			this.third = third;
		}

		public InterleavingStrings() {
		}

		public String getFirst() {
			return this.first;
		}

		public void setFirst(String first) {
			this.first = first;
		}

		public String getSecond() {
			return this.second;
		}

		public void setSecond(String second) {
			this.second = second;
		}

		public String getThird() {
			return this.third;
		}

		public void setThird(String third) {
			this.third = third;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((this.first == null) ? 0 : this.first.hashCode());
			result = prime * result + ((this.second == null) ? 0 : this.second.hashCode());
			result = prime * result + ((this.third == null) ? 0 : this.third.hashCode());
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
			InterleavingStrings other = (InterleavingStrings) obj;
			if (this.first == null) {
				if (other.first != null)
					return false;
			} else if (!this.first.equals(other.first))
				return false;
			if (this.second == null) {
				if (other.second != null)
					return false;
			} else if (!this.second.equals(other.second))
				return false;
			if (this.third == null) {
				if (other.third != null)
					return false;
			} else if (!this.third.equals(other.third))
				return false;
			return true;
		}
	}
}