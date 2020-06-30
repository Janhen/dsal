package com.janhen.coding.leetcode.ds.linkedlist.sm_split_sort_merge_copy_build.solution138;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public Node copyRandomList(Node head) {
    // 1. record origin node -> copy node
    Map<Node, Node> map = new HashMap<>();

    // 2. iterate, copy, link, store origin node -> copy node
    Node cur1 = head;             // use for iteration original list
    Node cur2 = new Node(-1); // use for link copy node
    while (cur1 != null) {
      Node copy = new Node(cur1.val);
      map.put(cur1, copy);        // save origin -> copy
      cur2.next = copy;           // link copy list
      cur2 = copy;
      cur1 = cur1.next;
    }

    // 3. set copy node random attribute link,
    // get copy origin Node and oriNode.random Node
    map.keySet().stream().forEach(oriNode -> map.get(oriNode).random = map.get(oriNode.random));
    return map.get(head);
  }
}