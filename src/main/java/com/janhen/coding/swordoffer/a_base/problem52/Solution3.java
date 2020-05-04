package main.java.janhen.swordoffer.a_base.problem52;

import main.java.janhen.swordoffer.structures.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {
    // 借助 Map 特性实现
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Set<ListNode> record = new HashSet<>();
        while (pHead1 != null) {
            record.add(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            if (record.contains(pHead2))
                return pHead2;
            pHead2 = pHead2.next;
        }
        return null;
    }
}
