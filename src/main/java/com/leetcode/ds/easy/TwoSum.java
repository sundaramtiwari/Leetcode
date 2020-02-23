/**
 *
 */
package com.leetcode.ds.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 2. Two Sum {@linkplain https://leetcode.com/problems/two-sum/}
 *
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target. You may assume that each input would have
 * exactly one solution, and you may not use the same element twice.
 *
 * Example: Given nums = [2, 7, 11, 15], target = 9, Because nums[0] + nums[1] =
 * 2 + 7 = 9, return [0, 1].
 *
 * @author s0t010t
 *
 */

public class TwoSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {2, 11, 15, 7};
		System.out.println(twoSumNEW(arr, 9)[0] + " " + twoSumNEW(arr, 9)[1]);
	}

	public static int[] twoSum(int[] nums, int target) {
		int[] twoSum = new int[2];

		for (int i=0; i<nums.length; i++) {
			for (int j=i; j<nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					twoSum[0] = i;
					twoSum[1] = j;
					return twoSum;
				}
			}
		}

		// No match found, returning null;
		return null;
	}

	public static int[] twoSumNEW(int[] numbers, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(numbers.length);
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(target - numbers[i])) {
				result[1] = i;
				result[0] = map.get(target - numbers[i]);
				return result;
			}
			map.put(numbers[i], i);
		}
		return result;
	}

}
