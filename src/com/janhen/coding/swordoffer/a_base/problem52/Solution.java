package com.janhen.swordoffer.a_base.problem52;

import com.janhen.swordoffer.structures.ListNode;

public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        while (cur1 != cur2) {
            cur1 = cur1 != null ? cur1.next : pHead2;
            cur2 = cur2 != null ? cur2.next : pHead1;
        }
        return cur1;
    }
}
