package com.janhen.coding.swordoffer.a_base.problem6;

import com.janhen.coding.swordoffer.structures.ListNode;

import java.util.ArrayList;

public class Solution {
    // 将链表反转后，逐个遍历
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return list;
        }
        ListNode pre = reverse(listNode);
        while (pre != null) {
            list.add(pre.val);
            pre = pre.next;
        }
        return list;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
