/**
 *
 */
package com.leetcode.ds.medium;

/**
 *
 * 200. Number of Islands
 * {@linkplain https://leetcode.com/problems/number-of-islands/}
 *
 * @author s0t010t
 *
 */
public class Number_Of_Islands {

	public static void main(String[] args) {

		char[][] grid = { { '1', '1', '1' }, { '0', '1', '0' }, { '1', '1', '1' } };

		System.out.println(numIslands(grid));
	}

	static public int numIslands(char[][] grid) {

		if (grid == null || grid.length == 0)
			return 0;

		int count = 0;

		char[][] visitedGrid = new char[grid.length][grid[0].length];

		for (int i = 0; i < grid.length; i++) {

			char[] gridRow = grid[i];

			for (int j = 0; j < gridRow.length; j++) {
				char ch = gridRow[j];

				if (ch == '1') {

					if (visitedGrid[i][j] != '1') {
						// mark current node visited
						visitedGrid[i][j] = '1';
						if ((i - 1 >= 0 && visitedGrid[i - 1][j] == '1')
								|| (i + 1 < grid.length && visitedGrid[i + 1][j] == '1')
								|| (j - 1 >= 0 && visitedGrid[i][j - 1] == '1')
								|| (j + 1 < grid.length && visitedGrid[i][j + 1] == '1')) {

						} else {
							count++;
						}
					}

					// Mark node before and after this node as '1'
					if (j - 1 >= 0)
						visitedGrid[i][j - 1] = '1';

					if (j + 1 < visitedGrid[i].length)
						visitedGrid[i][j + 1] = '1';

					if (i - 1 >= 0) {
						visitedGrid[i - 1][j] = '1';
					}

					if (i + 1 < grid.length) {
						visitedGrid[i + 1][j] = '1';
					}
				}
			}
		}
		return count;
	}

}
