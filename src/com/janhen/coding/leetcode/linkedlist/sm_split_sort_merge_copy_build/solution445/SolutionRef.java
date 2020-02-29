package com.janhen.leetcode.linkedlist.sm_split_sort_merge_copy_build.solution445;

// 445. Add Two Numbers II
// https://leetcode.com/problems/add-two-numbers-ii/
// Medium  595:82

/*
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
 */

import com.janhen.leetcode.structures.ListNode;

class SolutionRef {

    // 22 ms, faster than 93.15%
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = length(l1);
        int len2 = length(l2);
        if (len1 < len2)
            l1 = padList(l1, len2-len1);
        else
            l2 = padList(l2, len1-len2);

        Pair pair = addListHelper(l1, l2);
        if (pair.carry == 0) {
            return pair.sum;
        }
        else {
            ListNode node = new ListNode(pair.carry);
            node.next = pair.sum;
            return node;
        }
    }

    private Pair addListHelper(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {      // tail end
            return new Pair(null, 0);
        }

        // calculate smaller bit
        Pair pair = addListHelper(l1.next, l2.next);// l1 and l2 ia same length

        // note: assemble cur result, and need joint
        int val = l1.val + l2.val + pair.carry;

        ListNode node = new ListNode(val % 10);
        node.next = pair.sum;
        return new Pair(node, val / 10);
    }


    // partial sum
    public class Pair {
        private ListNode sum;
        private int carry;

        Pair(ListNode sum, int carry) {
            this.sum = sum;
            this.carry = carry;
        }
    }

    private ListNode padList(ListNode head, int len) {
        ListNode cur = head;
        while (len -- > 0) {
            // first interpolation
            ListNode node = new ListNode(0);
            node.next = cur;
            cur = node;
        }
        return cur;   // now cur is head
    }

    private int length(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len ++;
            cur = cur.next;
        }
        return len;
    }
}