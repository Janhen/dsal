package com.janhen.coding.swordoffer.a_base.problem52;

import com.janhen.coding.swordoffer.structures.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {
    // 借助 Map 特性实现
    public ListNode FindFirstCommonNode(ListNode list1, ListNode list2) {
        Set<ListNode> record = new HashSet<>();
        while (list1 != null) {
            record.add(list1);
            list1 = list1.next;
        }
        while (list2 != null) {
            if (record.contains(list2)) {
                return list2;
            }
            list2 = list2.next;
        }
        return null;
    }
}
