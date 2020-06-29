package com.janhen.coding.leetcode.ds.linkedlist.quality.solution19;

import com.janhen.coding.leetcode.structures.ListNode;

class SolutionRef2 {

    // fast.next 来确定位置
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        while (n -- > 0)
            fast = fast.next;
        if (fast == null)         // handle remove head, n == head.len
            return head.next;
        ListNode slow = head;
        while (fast.next != null) {    // Note: fast.next != null to find previous
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}