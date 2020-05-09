package com.janhen.coding.swordoffer.a_base.problem22;

import com.janhen.coding.swordoffer.structures.ListNode;

public class SolutionR {

    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k <= 0)
            return null;
        return FindKthToTail(head, k, new IntWrapper());
    }

    private ListNode FindKthToTail(ListNode head, int k, IntWrapper i) {
        if (head == null)
            return null;

        ListNode node = FindKthToTail(head.next, k, i);
        if (++i.value == k)
            return head;
        return node;
    }

    private class IntWrapper {
        public int value = 0;
    }
}
