package com.leetcode.ds.medium;

/**
 *
 * 2. Add Two Numbers {@link https://leetcode.com/problems/add-two-numbers/}
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers.
 *
 * The digits are stored in reverse order and each of their nodes contain a
 * single digit.
 *
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *
 * Output: 7 -> 0 -> 8
 *
 * Explanation: 342 + 465 = 807.
 *
 *
 * @author s0t010t
 *
 */

public class AddTwoNumbers {

	public static void main(String[] args) {
		//		ListNode l1 = new ListNode(3);
		//		ListNode l2 = new ListNode(4);
		//		ListNode l3 = new ListNode(2);
		//
		//		l3.next = l2;
		//		l2.next = l1;
		//
		//		ListNode n1 = new ListNode(5);
		//		ListNode n2 = new ListNode(6);
		//		ListNode n3 = new ListNode(4);
		//
		//		n1.next = n2;
		//		n2.next = n3;


		ListNode l3 = new ListNode(5);
		ListNode n1 = new ListNode(5);

		System.out.println(addTwoNumbers(l3, n1));

	}

	static public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode result = new ListNode(0);
		ListNode cur = result;

		// Iterate through both the lists and keep appending the result to a variable
		int carry = 0;

		while (l1 != null || l2 != null || carry > 0) {
			int l1Val = 0;
			int l2Val = 0;

			if (l1 != null)
				l1Val = l1.val;

			if (l2 != null)
				l2Val = l2.val;

			int sum = l1Val + l2Val + carry;

			if (sum > 9) {
				carry = (int) (Math.log10(sum));
				sum = sum % 10;
			} else {
				carry = 0;
			}

			cur.val = sum;

			if (l1 != null)
				l1 = l1.next;

			if (l2 != null)
				l2 = l2.next;

			if (l1 != null || l2 != null || carry > 0) {
				cur.next = new ListNode(0);
				cur = cur.next;
			}

		}

		return result;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		this.val = x;
	}

	@Override
	public String toString() {
		return this.val + " -> " + this.next;
	}
}