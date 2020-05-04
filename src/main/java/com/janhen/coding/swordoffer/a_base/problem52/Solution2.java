package main.java.janhen.swordoffer.a_base.problem52;

import main.java.janhen.swordoffer.structures.ListNode;

public class Solution2 {
    // Same length, From left to Right visit
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = length(pHead1);
        int len2 = length(pHead2);
        int diff = Math.abs(len1-len2);
        if (len1 > len2) {
            while (diff -- > 0)
                pHead1 = pHead1.next;
        } else {
            while (diff -- > 0)
                pHead2 = pHead2.next;
        }
        while (pHead1 != pHead2) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }

    private int length(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len ++;
            cur = cur.next;
        }
        return len;
    }
}
