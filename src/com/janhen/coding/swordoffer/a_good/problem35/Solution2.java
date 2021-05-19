package com.janhen.coding.swordoffer.a_good.problem35;

import com.janhen.coding.swordoffer.structures.RandomListNode;

public class Solution2 {
    // step1. insert redundancy node
    // step2. copy random pointer
    // step3. split the redundancy node
    public RandomListNode Clone(RandomListNode head) {
        if (head == null) return null;
        RandomListNode cur = head;
        while (cur != null) {           // cur always point to original list node
            RandomListNode copy = new RandomListNode(cur.label);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }
        cur = head;
        while (cur != null) {              // cur point to original list
            RandomListNode copy = cur.next;
            if (cur.random != null)
                copy.random = cur.random.next;
            cur = copy.next;
        }
        cur = head;
        RandomListNode copyHead = cur.next;
        while (cur.next != null) {        // cur point to all merged linked list AND split list
            RandomListNode next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return copyHead;
    }
}
