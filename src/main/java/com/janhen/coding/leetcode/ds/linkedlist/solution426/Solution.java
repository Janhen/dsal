package com.janhen.coding.leetcode.ds.linkedlist.solution426;

// https://leetcode-cn.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/

class Solution {
  public Node treeToDoublyList(Node root) {
    if (root == null) {
      return null;
    }
    inorder(root);
    first.left = last;
    last.right = first;
    return first;
  }

  private Node first = null;
  private Node last = null;

  public void inorder(Node node) {
    if (node == null) {
      return;
    }
    inorder(node.left);
    if (last == null) {
      first = node; // first
    } else {
      last.right = node;
      node.left = last;
    }
    last = node;
    inorder(node.right);
  }
}