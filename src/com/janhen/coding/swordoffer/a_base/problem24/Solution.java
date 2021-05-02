package com.janhen.coding.swordoffer.a_base.problem24;

import com.janhen.coding.swordoffer.structures.ListNode;

public class Solution {
    public ListNode ReverseList(ListNode head) {
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
