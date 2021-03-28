package com.janhen.coding.leetcode.other.solution203;

import com.janhen.coding.leetcode.structures.ListNode;

public class Solution3 {

    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        while (prev != null && prev.next != null) {
            if (prev.next.val == val) {
                ListNode cur = prev.next;
                prev.next = cur.next;
                cur.next = null;
            } else
                prev = prev.next;
        }
        return dummy.next;
    }
}
