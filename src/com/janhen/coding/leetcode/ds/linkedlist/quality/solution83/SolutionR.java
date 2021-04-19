package com.janhen.coding.leetcode.ds.linkedlist.quality.solution83;

import com.janhen.coding.leetcode.structures.ListNode;

class SolutionR {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        if (head.val == head.next.val) {
            ListNode cur = next;
            while (cur.next != null && head.val == cur.next.val) {
                cur = cur.next;   // next is last excepted
            }
            cur.next = deleteDuplicates(cur.next);
            return cur;
        } else {
            head.next = deleteDuplicates(next);
            return head;
        }
    }
}