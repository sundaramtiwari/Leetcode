/**
 *
 */
package com.leetcode.ds.medium;

import com.leetcode.ds.medium.Search_In_Rotated_Sorted_Array.RotatedSortedArrayBinarySearch;

/**
 * 153. Find Minimum in Rotated Sorted Array
 * {@linkplain https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/}
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 *
 * You may assume no duplicate exists in the array.
 *
 * @author s0t010t
 *
 */
public class Find_Minimum_In_Rotated_Sorted_Array {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 1, 2 };
		System.out.println(findMin(nums));
	}

	static public int findMin(int[] nums) {
		int pivot = RotatedSortedArrayBinarySearch.getPivot(nums);

		System.out.println(pivot);
		if (pivot + 1 < nums.length)
			return nums[pivot + 1];
		else
			return nums[pivot];
	}

}
