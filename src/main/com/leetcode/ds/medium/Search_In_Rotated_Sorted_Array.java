/**
 *
 */
package com.leetcode.ds.medium;

/**
 *
 * 33. Search in Rotated Sorted Array
 *
 * {@linkplain https://leetcode.com/problems/search-in-rotated-sorted-array/}
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * @author s0t010t
 *
 */
public class Search_In_Rotated_Sorted_Array {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] num = {4,5,6,7,8,1,3};
		int target = 0;

		System.out.println(search(num, target));
	}

	static public int search(int[] nums, int target) {
		return RotatedSortedArrayBinarySearch.rotatedBinarySearch(target, nums);
	}

	public static class RotatedSortedArrayBinarySearch {

		public static int rotatedBinarySearch(int key, int[] arr) {
			int index = -1;

			if (arr != null && arr.length != 0) {

				int pivot = getPivot(arr);

				index = BinarySearch.binarySearch(key, 0, pivot, arr);

				if (index == -1 && pivot + 1 < arr.length)
					index = BinarySearch.binarySearch(key, pivot + 1, arr.length - 1, arr);
			}

			return index;
		}

		public static int getPivot(int[] arr) {
			return getPivot(arr, 0, arr.length - 1);
		}

		private static int getPivot(int[] arr, int min, int max) {
			int pivot = 0;
			int mid = (max + min) / 2;

			if (max - min == 1) {
				pivot = min;

			} else {
				if (arr[max] < arr[min]) {
					int midEle = arr[mid];

					if (midEle < arr[min]) {
						// Pivot lies in first half
						return getPivot(arr, min, mid);

					} else {
						return getPivot(arr, mid, max);
					}

				}
			}

			return pivot;
		}
	}
	public static class BinarySearch {

		public static int binarySearch(int key, int[] arr) {

			if (arr == null || arr.length == 0)
				return -1;

			else
				return binarySearch(key, 0, arr.length - 1, arr);
		}

		public static int binarySearch(int key, int min, int max, int[] arr) {

			long _min = min;
			long _max = max;

			int index = -1;
			int mid = (int) ((_min + _max) / 2);

			if (arr[min] == key)
				index = min;

			else if (arr[max] == key)
				index = max;

			else if (arr[mid] == key)
				index = mid;

			else if (arr[mid] > key && mid - 1 > 0 && min <= mid - 1) {
				return binarySearch(key, min, mid - 1, arr);

			} else if (arr[mid] < key && mid + 1 < arr.length && mid + 1 <= max) {
				return binarySearch(key, mid + 1, max, arr);
			}

			return index;
		}

	}
}
