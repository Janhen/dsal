package com.janhen.coding.swordoffer.a_base.problem25;

import com.janhen.coding.swordoffer.structures.ListNode;

public class Solution {
    // dummy head, cut and join list
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        // link list
        ListNode first = new ListNode(-1);
        ListNode cur = first;
        while (list1 != null && list2 != null) {
           if (list1.val <= list2.val) {
                cur.next = list1;
                cur = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                cur = list2;
                list2 = list2.next;
            }
        }
        // remaining handle
        if (list1 == null) {
            cur.next = list2;
        }
        if (list2 == null) {
            cur.next = list1;
        }
        return first.next;
    }
}
