package main.java.janhen.leetcode.linkedlist.sm_split_sort_merge_copy_build.solution138;

import main.java.janhen.leetcode.structures.RandomListNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();   // record origin node -> copy node
        RandomListNode cur1 = head;               // use for iteration
        RandomListNode tail = new RandomListNode(-1);  // use for link copy node
        while (cur1 != null) {
            RandomListNode copy = new RandomListNode(cur1.label);
            map.put(cur1, copy);
            tail.next = copy;             // NOTE: need to link list
            tail = copy;
            cur1 = cur1.next;
        }
        for (Map.Entry<RandomListNode, RandomListNode> entry : map.entrySet())
            entry.getValue().random = map.get(entry.getKey().random);
        return map.get(head);
    }
}