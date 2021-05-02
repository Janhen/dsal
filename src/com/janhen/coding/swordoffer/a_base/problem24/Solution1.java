package com.janhen.coding.swordoffer.a_base.problem24;

import com.janhen.coding.swordoffer.structures.ListNode;

public class Solution1 {
    // dummy head node
    public ListNode ReverseList(ListNode head) {
        // head insert
        ListNode first = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = first.next;
            first.next = head;
            head = next;
        }
        return first.next;
    }
}
