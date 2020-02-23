package com.leetcode.ds.medium;

/**
 *
 * 6. ZigZag Conversion
 *
 * {@link https://leetcode.com/problems/zigzag-conversion/}
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility) P A H N A P L S I I G Y I R And then read line by line:
 * "PAHNAPLSIIGYIR"
 *
 * @author s0t010t
 *
 */
public class ZigZag_Conversion {

	public static void main(String[] args) {

		String s = "A"; // "PAYPALISHIRING";
		System.out.println(s.length());
		int numRows = 1;

		System.out.println(convert(s, numRows));
	}

	static public String convert(String s, int numRows) {
		if (numRows == 1)
			return s;

		StringBuilder sbr = new StringBuilder();

		int mul = numRows * 2 - 2; // 3*2 - 2 = 4

		char[] sArr = s.toCharArray();


		int tempI = 0;
		int secMul = 0;
		int tempMul = mul;

		boolean flag = false;

		for (int i = 0; i < numRows; i++) {
			tempI = i;

			if (tempMul == mul) {
				while (tempI < sArr.length) {
					sbr.append(sArr[tempI]);
					tempI += tempMul;
				}

			} else {

				secMul = mul - tempMul; // 4 - 2 = 2

				while (tempI < sArr.length) {
					sbr.append(sArr[tempI]);
					// System.out.println(sbr.toString());
					if (flag) {
						tempI += secMul;
						flag = false;
					} else {
						tempI += tempMul;
						flag = true;
					}
				}

			}
			// System.out.println(sbr.toString());

			tempMul = tempMul - 2 > 0 ? tempMul - 2 : mul; // 4 - 2 = 2
			// System.out.println("TempMul: " + tempMul);
		}

		// System.out.println(sbr.length());
		return sbr.toString();
	}
}
