package com.janhen.coding.leetcode.ds.linkedlist.sm_split_sort_merge_copy_build.solution138;


import com.janhen.coding.leetcode.structures.Node;

import java.util.HashMap;
import java.util.Map;

public class Tmp {
  public Node copyRandomList(Node head) {
    // record origin node -> copy node
    Map<Node, Node> map = new HashMap<>();

    // use for iteration original list
    Node cur1 = head;
    // use for link copy node
    Node cur2 = new Node(-1);
    while (cur1 != null) {
      Node copy = new Node(cur1.val);
      // save origin -> copy
      map.put(cur1, copy);
      // link copy list
      cur2.next = copy;
      cur2 = copy;
      // continue to iteration
      cur1 = cur1.next;
    }

    // set copy node random attribute link
    //
    map.keySet().stream().forEach(oriNode -> map.get(oriNode).random = map.get(oriNode.random));
    return map.get(head);
  }
}
