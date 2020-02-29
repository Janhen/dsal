package com.janhen.swordoffer.a_base.problem18_2;

import com.janhen.swordoffer.structures.ListNode;

public class Solution {

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null)  return pHead;
        ListNode first = new ListNode(-1);
        first.next = pHead;
        ListNode pre = first;
        while (pre.next != null && pre.next.next != null) {
            if (pre.next.val == pre.next.next.val) {
                ListNode cur = pre.next;
                while (cur != null && cur.val == pre.next.val) {
                    cur = cur.next;
                }
                pre.next = cur;
            } else {
                pre = pre.next;
            }

        }
        return first.next;
    }
}
