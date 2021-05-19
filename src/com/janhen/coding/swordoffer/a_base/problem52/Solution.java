package com.janhen.coding.swordoffer.a_base.problem52;

import com.janhen.coding.swordoffer.structures.ListNode;

public class Solution {
    // time: O(1), space: O(1)
    public ListNode FindFirstCommonNode(ListNode list1, ListNode list2) {
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        while (cur1 != cur2) {
            // mock loop cycle to find, continue to find or to list2 to find
            cur1 = cur1 != null ? cur1.next : list2;
            cur2 = cur2 != null ? cur2.next : list1;
        }
        return cur1;
    }
}
