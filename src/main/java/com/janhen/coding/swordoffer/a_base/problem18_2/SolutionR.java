package com.janhen.coding.swordoffer.a_base.problem18_2;

import com.janhen.coding.swordoffer.structures.ListNode;

public class SolutionR {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;

        ListNode next = pHead.next;
        if (pHead.val == next.val) {
            while (next != null && next.val == pHead.val)      // // find first not equal val AND pHead save duplication value to compare
                next = next.next;
            return deleteDuplication(next);           // remove cur pHead
        } else {
            pHead.next = deleteDuplication(next);
            return pHead;
        }
    }
}
