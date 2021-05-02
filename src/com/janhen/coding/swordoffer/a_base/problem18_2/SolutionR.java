package com.janhen.coding.swordoffer.a_base.problem18_2;

import com.janhen.coding.swordoffer.structures.ListNode;

public class SolutionR {
    public ListNode deleteDuplication(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        if (head.val == next.val) {
            // find first not equal val AND pHead save duplication value to compare
            while (next != null && next.val == head.val) {
                next = next.next;
            }
            return deleteDuplication(next);           // remove cur pHead
        } else {
            head.next = deleteDuplication(next);
            return head;
        }
    }
}
