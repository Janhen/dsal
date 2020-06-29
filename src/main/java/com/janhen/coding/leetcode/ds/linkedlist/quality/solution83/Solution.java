package com.janhen.coding.leetcode.ds.linkedlist.quality.solution83;

import com.janhen.coding.leetcode.structures.ListNode;

class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = head;
        ListNode cur = pre.next;
        while (cur != null) {
            if (pre.val == cur.val) {
                while (cur.next != null && pre.val == cur.next.val)   // find last duplication
                    cur = cur.next;
                pre.next = cur.next;
                pre = cur;
                cur = cur.next;
            } else  {
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}