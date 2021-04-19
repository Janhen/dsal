package com.janhen.coding.leetcode.ds.linkedlist.quality.solution24;

import com.janhen.coding.leetcode.structures.ListNode;

class Solution {
    public ListNode swapPairs(ListNode head) {
        // 1. dummy node
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode pre = first;

        // 2. pre record before two node
        while (pre.next != null && pre.next.next != null) {    // note : must first judge pre.next != null
            // define four node
            //    pre -> n1 -> n2 -> next
            // => pre -> n2 -> n1 -> next
            ListNode n1 = pre.next, n2 = n1.next, next = n2.next;
            n1.next = next;
            n2.next = n1;
            pre.next = n2;
            pre = n1;
        }
        return first.next;
    }
}