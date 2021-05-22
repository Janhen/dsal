package com.janhen.coding.swordoffer.a_base.problem18;

import com.janhen.coding.swordoffer.structures.ListNode;

public class Solution {
    // tobeDelete ∈ {head, tail, middle node}
    public ListNode deleteNode(ListNode head, ListNode tobeDelete) {
        if (head == null || tobeDelete == null) {
            return null;
        }
        // case1： have next
        if (tobeDelete.next != null) {
            // update tobeDelete value and unlink next node
            ListNode next = tobeDelete.next;
            tobeDelete.val = next.val;
            tobeDelete.next = next.next;
        } else {
            // case2： tobeDelete is tail and head
            if (tobeDelete == head) {
                // head node
                head = null;
            } else {
                // case3： tail node, make back 2th node point to null
                ListNode cur = head;
                while (cur.next != tobeDelete) {
                    cur = cur.next;
                }
                cur.next = null;
            }
        }
        return head;
    }
}
