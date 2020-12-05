package com.janhen.coding.leetcode.structures;

import java.util.*;

public class TreeNode {

  public int val;
  public TreeNode left, right;

  public TreeNode(int val) {
    this.val = val;
  }

  public TreeNode(Integer[] arr) {
    int index = 0;
    TreeNode cur = this;
    cur.val = arr[index++];    // insure root node

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(cur);
    while (!q.isEmpty()) {
      cur = q.poll();
      cur.left = index < arr.length ? generateNode(arr[index++]) : null;          // must judge: leaf left and right child not include in arr
      cur.right = index < arr.length ? generateNode(arr[index++]) : null;
      if (cur.left != null)
        q.offer(cur.left);
      if (cur.right != null)
        q.offer(cur.right);
    }
  }

  private TreeNode generateNode(Integer val) {
    if (val == null)
      return null;
    return new TreeNode(val);
  }

  public void printTree() {
    System.out.println("Binary Tree:");
    printInOrder(this, 0, "H", 17);
    System.out.println();
  }

  public void printLevel() {
    List<Integer> levelList = new ArrayList<>();
    int level = getDepthAndLevel(this, levelList);
    boolean[][] positions = getPositions(level);
    System.out.println("Level : " + level);

    int index = 0;
    for (boolean[] position : positions) {
      for (boolean isFill : position) {
        if (isFill)
          System.out.print(generateEle(levelList.get(index++)));
        else
          System.out.print(generateEle(null));
      }
      System.out.println();
    }
  }

  private static boolean[][] getPositions(int level) {
    int cols = (int) Math.pow(2, level - 1) * 2 - 1;
    boolean[][] res = new boolean[level][cols];

    for (int i = level - 1; i >= 0; i--) {
      int cnt = (int) Math.pow(2, i);
      int[] position = new int[cnt];

      int first = (cols / cnt) / 2;
      int gap = first + 1;
      position[0] = first;
      for (int j = 1; j < cnt; j++)
        position[j] = position[j - 1] + gap * 2;

      int index = 0;
      for (int j = 0; j < cols; j++) {
        if (index < position.length && j == position[index]) {
          res[i][j] = true;
          index++;
        }
      }
    }
    return res;
  }

  private void printInOrder(TreeNode head, int height, String to, int len) {
    if (head == null)
      return;

    printInOrder(head.right, height + 1, "v", len);
    String val = to + head.val + to;
    int lenM = val.length();
    int lenL = (len - lenM) / 2;
    int lenR = len - lenM - lenL;
    val = getSpace(lenL) + val + getSpace(lenR);

    System.out.println(getSpace(height * len) + val);
    printInOrder(head.left, height + 1, "^", len);
  }

  private String getSpace(int num) {
    String space = " ";
    StringBuffer buf = new StringBuffer();
    for (int i = 0; i < num; i++) {
      buf.append(space);
    }
    return buf.toString();
  }

  // original level : null as leaf
  // return level : not include null level
  private int getDepthAndLevel(TreeNode root, List<Integer> list) {
    if (root == null)
      return 0;

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    int level = 0;
    while (!q.isEmpty()) {
      int cnt = q.size();
      while (cnt-- > 0) {
        TreeNode node = q.poll();
        if (node == null) {
          list.add(null);
          continue;
        }
        list.add(node.val);
        q.offer(node.left);
        q.offer(node.right);
      }
      level++;
    }
    level--;
    int allCnt = (int) Math.pow(2, level) - 1;
    while (list.size() <= allCnt)
      list.add(null);
    return level;
  }

  private String generateEle(Integer val) {
    if (val == null)
      return "     ";
    else {
      int len = 5;
      int valLen = String.valueOf(val).length();
      char[] chs = new char[5];

      int index = (len - valLen) / 2;
      for (char c : String.valueOf(val).toCharArray())
        chs[index++] = c;

      return new String(chs);
    }
  }

  public int leftSideDepth(TreeNode node) {
    int depth = 0;
    while (node != null) {
      depth++;
      node = node.left;
    }
    return depth;
  }

  public int rightSideDepth(TreeNode node) {
    int depth = 0;
    while (node != null) {
      depth++;
      node = node.right;
    }
    return depth;
  }

  // traverse
  public void preOrder() {
    TreeNode cur = this;
    if (cur == null) return;
    System.out.print("PRE  : ");

    Stack<TreeNode> s = new Stack<>();
    s.push(cur);
    while (!s.isEmpty()) {
      TreeNode node = s.pop();
      System.out.print(node.val + " ");
      if (node.right != null)
        s.push(node.right);
      if (node.left != null)
        s.push(node.left);
    }
    System.out.println();
  }

  public void inOrder() {
    TreeNode cur = this;
    if (cur == null) return;
    System.out.print("IN   : ");

    Stack<TreeNode> s = new Stack<>();
    while (!s.isEmpty() || cur != null) {
      while (cur != null) {
        s.push(cur);
        cur = cur.left;
      }
      // LDR
      cur = s.pop();
      System.out.print(cur.val + " ");
      cur = cur.right;
    }
    System.out.println();
  }

  public void postOrder() {
    TreeNode cur = this;
    if (cur == null) return;
    System.out.print("POST : ");

    Stack<TreeNode> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    s1.push(cur);
    while (!s1.isEmpty()) {
      // DRL
      cur = s1.pop();
      s2.push(cur.val);

      if (cur.left != null)
        s1.push(cur.left);
      if (cur.right != null)
        s1.push(cur.right);
    }
    // LRD
    while (!s2.isEmpty())
      System.out.print(s2.pop() + " ");
    System.out.println();
  }

  public void levelOrder() {
    TreeNode cur = this;
    if (cur == null) return;
    System.out.println("LEVEL : ");

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(cur);
    while (!q.isEmpty()) {
      int cnt = q.size();
      while (cnt-- > 0) {
        cur = q.poll();
        System.out.print(cur.val + " ");
        if (cur.left != null) q.offer(cur.left);
        if (cur.right != null) q.offer(cur.right);
      }
      System.out.println();
    }
  }
}

