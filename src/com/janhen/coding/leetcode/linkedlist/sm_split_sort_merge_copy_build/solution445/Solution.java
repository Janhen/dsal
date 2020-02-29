package com.janhen.leetcode.linkedlist.sm_split_sort_merge_copy_build.solution445;

import com.janhen.leetcode.structures.ListNode;

class Solution {
    // 反转进行求和
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode resReverse = addTwoNumbers(l1, l2, 0);
        return reverse(resReverse);
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) return null;

        int val = (l1 == null ? 0 :l1.val) + (l2 == null ? 0 : l2.val) + carry;
        carry = val / 10;
        ListNode res = new ListNode(val % 10);
        res.next = addTwoNumbers(l1 == null ? null : l1.next, l2 == null ? null : l2.next, carry);  // prevent NullPointerException
        return res;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}