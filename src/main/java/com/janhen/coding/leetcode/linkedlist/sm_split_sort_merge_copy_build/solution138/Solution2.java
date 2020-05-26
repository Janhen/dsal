package com.janhen.coding.leetcode.linkedlist.sm_split_sort_merge_copy_build.solution138;

import com.janhen.coding.leetcode.structures.RandomListNode;

public class Solution2 {
    // step1. insert to cur and cur.next
    // step2. random connect
    // step3. split by one point
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head ==  null) return null;
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode copy = new RandomListNode(cur.label);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }

        cur = head;    // traverse original list
        while (cur != null) {
            RandomListNode clone = cur.next;
            if (cur.random != null) clone.random = cur.random.next;     // random not every node have
            cur = clone.next;
        }

        cur = head;     // traverse combined list and split it
        RandomListNode copyHead = cur.next;
        while (cur.next != null) {
            RandomListNode next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return copyHead;
    }
}