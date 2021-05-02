package com.janhen.coding.swordoffer.a_good.problem35;

import com.janhen.coding.swordoffer.structures.RandomListNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public RandomListNode Clone(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur1 = head;                 // use for
        RandomListNode cur2 = new RandomListNode(-1);   // make the line connect AND as pre
        while (cur1 != null) {
            RandomListNode copy = new RandomListNode(cur1.label);            // ⇔ insertAfter(cur, copy)
            map.put(cur1, copy);
            cur2.next = copy;
            cur2 = copy;
            cur1 = cur1.next;
        }
        for (Map.Entry<RandomListNode, RandomListNode> entry : map.entrySet()) {
            entry.getValue().random = map.get(entry.getKey().random);
        }
        return map.get(head);
    }
}
