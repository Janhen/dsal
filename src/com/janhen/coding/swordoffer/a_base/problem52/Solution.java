package com.janhen.coding.swordoffer.a_base.problem52;

import com.janhen.coding.swordoffer.structures.ListNode;

public class Solution {
    // 模拟成环进行判断
    public ListNode FindFirstCommonNode(ListNode list1, ListNode list2) {
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        while (cur1 != cur2) {
            cur1 = cur1 != null ? cur1.next : list2;
            cur2 = cur2 != null ? cur2.next : list1;
        }
        return cur1;
    }
}
