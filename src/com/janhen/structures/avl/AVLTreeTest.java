package com.janhen.structures.avl;

import java.util.ArrayList;
import java.util.List;

/**
 * 验证平衡树的平衡性和有序性
 *
 * @param <K>
 * @param <V>
 */
public class AVLTreeTest<K extends Comparable<K>, V> extends AVLTree<K, V> {

  public boolean isBST() {
    // inOrder is order
    List<K> keys = new ArrayList<>();
    inOrder(root, keys);

    for (int i = 1; i < keys.size(); i++)
      if (keys.get(i - 1).compareTo(keys.get(i)) > 0)
        return false;

    return true;
  }

  private void inOrder(Node node, List<K> list) {
    if (node == null)
      return;

    inOrder(node.left, list);
    list.add(node.key);
    inOrder(node.right, list);
  }

  public boolean isBalanced() {
    return isBalanced(root);
  }

  private boolean isBalanced(Node node) {
    if (node == null)
      return true;

    int balanceFactor = getBalanceFactor(node);
    if (Math.abs(balanceFactor) > 1)
      return false;

    return isBalanced(node.left) && isBalanced(node.right);
  }
}
