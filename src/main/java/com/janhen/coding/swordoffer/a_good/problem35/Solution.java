package com.janhen.coding.swordoffer.a_good.problem35;

import com.janhen.coding.swordoffer.structures.RandomListNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public RandomListNode Clone(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;                 // use for
        RandomListNode tail = new RandomListNode(-1);   // make the line connect AND as pre
        while (cur != null) {
            RandomListNode copy = new RandomListNode(cur.label);            // ⇔ insertAfter(cur, copy)
            map.put(cur, copy);
            tail.next = copy;
            tail = copy;
            cur = cur.next;
        }
        for (Map.Entry<RandomListNode, RandomListNode> entry : map.entrySet()) {
            entry.getValue().random = map.get(entry.getKey().random);
        }
        return map.get(head);
    }
}
