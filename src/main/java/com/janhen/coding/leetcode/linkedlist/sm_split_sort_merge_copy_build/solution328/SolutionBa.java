package main.java.janhen.leetcode.linkedlist.sm_split_sort_merge_copy_build.solution328;

// 328. Odd Even Linked List
//https://leetcode.com/problems/odd-even-linked-list/

import main.java.janhen.leetcode.structures.ListNode;

class SolutionBa {

    // COMMON handle
    public ListNode oddEvenList(ListNode head) {
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