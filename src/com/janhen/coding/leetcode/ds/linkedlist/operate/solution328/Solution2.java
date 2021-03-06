package com.janhen.coding.leetcode.ds.linkedlist.operate.solution328;

import com.janhen.coding.leetcode.structures.ListNode;

class Solution2 {
    public ListNode oddEvenList(ListNode head) {
        // define four pointer to joint, one pointer to iteration
        ListNode oddTail = null, oddHead = null;
        ListNode evenHead = null, evenTail = null;
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            ListNode next = cur.next;  // truncate list
            cur.next = null;     // cur as tail element
            len++;
            if (len % 2 == 1) {
                if (oddHead == null) {
                    oddHead = cur;
                    oddTail = oddHead;
                } else {
                    oddTail.next = cur;
                    oddTail = cur;
                }
            } else {
                if (evenHead == null) {
                    evenHead = cur;
                    evenTail = evenHead;
                } else {
                    evenTail.next = cur;
                    evenTail = cur;
                }
            }
            cur = next;
        }
        // joint list
        if (evenTail == null) {
            return oddTail;
        }
        oddTail.next = evenHead;
        return oddHead;
    }
}