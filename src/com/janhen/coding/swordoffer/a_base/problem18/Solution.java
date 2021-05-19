package com.janhen.coding.swordoffer.a_base.problem18;

import com.janhen.coding.swordoffer.structures.ListNode;

public class Solution {
    // 删除节点为 {head, tail, middle node}
    public ListNode deleteNode(ListNode head, ListNode tobeDelete) {
        if (head == null || tobeDelete == null) {
            return null;
        }
        if (tobeDelete.next != null) {
            ListNode next = tobeDelete.next;
            tobeDelete.val = next.val;
            tobeDelete.next = next.next;
        } else {
            if (tobeDelete == head) {
                // head node
                head = null;
            } else {
                // tail node, make back 2th node point to null
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
