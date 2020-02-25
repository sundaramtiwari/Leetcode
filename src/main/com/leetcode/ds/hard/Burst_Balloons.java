/**
 *
 */
package com.leetcode.ds.hard;

import java.util.*;

/**
 * @author s0t010t
 *
 */
public class Burst_Balloons {

	public static void main(String[] args) {
		int[] input = { 3, 1, 5, 8 };
		System.out.println(maxCoins(input));

	}

	static public int maxCoins(int[] nums) {
		int maxCoins = 0;

		if (nums == null || nums.length == 0)
			return maxCoins;

		List<Integer> coinsList = new ArrayList<>();
		Map<Integer, List<Integer>> coinsMap = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			coinsList.add(num);

			if (coinsMap.containsKey(num)) {

				List<Integer> list = coinsMap.get(num);
				list.add(i);
				coinsMap.put(num, list);

			} else {

				List<Integer> list = new ArrayList<>();
				list.add(i);
				coinsMap.put(num, list);
			}
		}

		List<Integer> original = new ArrayList<>();
		original.addAll(coinsList);

		Collections.sort(coinsList);

		for (int i = 0; i < coinsList.size(); i++) {
			Integer num = coinsList.get(i);
			List<Integer> list = coinsMap.get(num);


			if (original.indexOf(Integer.valueOf(num)) > 0
					&& original.indexOf(Integer.valueOf(num)) < original.size() - 1) {
				// maxCoins +=1
			}
		}

		printCollections(coinsList, coinsMap, original);

		return maxCoins;
	}

	private static void printCollections(List<Integer> coinsList, Map<Integer, List<Integer>> coinsMap,
			List<Integer> original) {
		for (Integer integer : original) {
			System.out.print(integer + " ");
		}
		System.out.println();

		for (Integer integer : coinsList) {
			System.out.print(integer + " ");
		}

		System.out.println();

		for (Integer integer : coinsMap.keySet()) {
			System.out.println(integer + " : " + coinsMap.get(integer));
		}
	}
}
