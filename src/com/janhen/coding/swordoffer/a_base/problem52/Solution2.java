package com.janhen.coding.swordoffer.a_base.problem52;

import com.janhen.coding.swordoffer.structures.ListNode;

public class Solution2 {
    // Same length, From left to Right visit
    // time: O(N), space: O(1)
    public ListNode FindFirstCommonNode(ListNode list1, ListNode list2) {
        int len1 = length(list1);
        int len2 = length(list2);
        int diff = Math.abs(len1 - len2);
        // 1. fast run diff step
        if (len1 > len2) {
            while (diff-- > 0) {
                list1 = list1.next;
            }
        } else {
            while (diff-- > 0) {
                list2 = list2.next;
            }
        }
        // 2. sync to traverse ...
        while (list1 != list2) {
            list1 = list1.next;
            list2 = list2.next;
        }
        return list1;
    }

    private int length(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }
}
