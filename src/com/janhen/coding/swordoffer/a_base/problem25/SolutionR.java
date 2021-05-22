package com.janhen.coding.swordoffer.a_base.problem25;

import com.janhen.coding.swordoffer.structures.ListNode;

public class SolutionR {
    public ListNode Merge(ListNode list1, ListNode list2) {
        // skip condition ...
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        // list1.val < list2.val, select list1
        if (list1.val < list2.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }
}
