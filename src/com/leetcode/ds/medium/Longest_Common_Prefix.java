package com.leetcode.ds.medium;

/**
 *
 * 11. Container With Most Water
 *
 * {@link https://leetcode.com/problems/container-with-most-water/}
 * 
 * Given n non-negative integers a1, a2, ..., an , where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container and n is at least 2.
 *
 * Example:
 *
 * Input: [1,8,6,2,5,4,8,3,7] Output: 49
 *
 * @author s0t010t
 *
 */

public class Longest_Common_Prefix {

	public static void main(String[] args) {
		String[] strs = {"flower","flow","flight"};
		System.out.println(longestCommonPrefix(strs));
	}

	static public String longestCommonPrefix(String[] strs) {
        String result = "";
        
        if (strs == null || strs.length == 0)
        	return result;
        
        if (strs.length == 1)
        	return strs[0];
        
        String start = strs[0];
        char[] resultArr = start.toCharArray();
        
        for (int j=1; j < strs.length; j++) {
        	String str = strs[j];
        	char[] charArray = str.toCharArray();
        	
        	StringBuilder sbr = new StringBuilder();
        	
        	int min = resultArr.length > charArray.length ? charArray.length : resultArr.length;

        	for (int i=0; i<min; i++) {

        		if (resultArr[i] == charArray[i]) {
        			sbr.append(resultArr[i]);
        			continue;

        		} else  break;
        	}

        	if (result.length() == 0)
        		result = sbr.toString();

        	else if (sbr.toString().length() < result.length())
        		result = sbr.toString();
        }
        
        return result;
    }
}