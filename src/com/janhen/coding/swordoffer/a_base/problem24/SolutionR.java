package com.janhen.coding.swordoffer.a_base.problem24;

import com.janhen.coding.swordoffer.structures.ListNode;

public class SolutionR {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reverseHead = ReverseList(head.next);
        head.next.next = head;
        head.next = null;  // as tail
        return reverseHead;
    }
}
