package com.janhen.coding.leetcode.ds.linkedlist.quality.solution92;

import com.janhen.coding.leetcode.structures.ListNode;

class SolutionGRef {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return null;
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode pre = first;
        for(int i = 0; i<m-1; i++) pre = pre.next;   // find mth node previous

        ListNode cur = pre.next; // a pointer to the beginning of a sub-list that will be reversed
        ListNode next = cur.next; // a pointer to a node that will be reversed

        // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5

        for(int i=0; i<n-m; i++) {
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
            next = cur.next;
        }

        // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)

        return first.next;

    }
}