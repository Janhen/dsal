package com.janhen.coding.leetcode.linkedlist.sm_split_sort_merge_copy_build.solution138;

import com.janhen.coding.leetcode.structures.RandomListNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        // record origin node -> copy node
        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        // use for iteration original list
        RandomListNode cur1 = head;
        // use for link copy node
        RandomListNode cur2 = new RandomListNode(-1);
        while (cur1 != null) {
            RandomListNode copy = new RandomListNode(cur1.label);
            // save origin -> copy
            map.put(cur1, copy);
            // link copy list
            cur2.next = copy;
            cur2 = copy;
            // continue to iteration
            cur1 = cur1.next;
        }

        // set copy node random attribute link, get cloned origin Node and oriNode.random Node
        map.keySet().stream().forEach(oriNode -> map.get(oriNode).random = map.get(oriNode.random));
        return map.get(head);
    }
}