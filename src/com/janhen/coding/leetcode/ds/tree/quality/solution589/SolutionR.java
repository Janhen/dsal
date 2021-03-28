package com.janhen.coding.leetcode.ds.tree.quality.solution589;

import java.util.ArrayList;
import java.util.List;

class SolutionR {
  List<Integer> list = new ArrayList<>();

  public List<Integer> preorder(Node root) {
    if (root == null)
      return list;

    list.add(root.val);
    for (Node node : root.children)
      preorder(node);

    return list;
  }
}