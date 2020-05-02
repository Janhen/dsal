package com.janhen.structures.redblacktree;

/**
 * 红黑树定义
 * 1 . 每个节点，要么是红色，要么是黑色
 * 2 . 根节点必须为 黑色
 * 3 . 每一个叶子节点（最后的节点）是黑色的
 * 4 . 如果一个节点是红色的，那么他的孩子节点都是黑色的
 * 5 . 从任意一个节点到叶子节点，经过的黑色节点是一样的（核心）
 */
public class RBTree<K extends Comparable<K>, V>{

  private Node root;
  private int N;

  public RBTree() {
    root = null;
    N = 0;
  }

  public int size() {
    return N;
  }

  public boolean isEmpty() {
    return N == 0;
  }

  // use for red black tree adjust

  private boolean isRed(Node node) {
    if (node == null)            // method to handle null as BLACK
      return BLACK;
    return node.color == RED;
  }

  /**
   *    node                     x               x.color=node.color, judge is or not mix up ↑
   *   /   \     左旋转         /  \
   *  T1   x   --------->   node   T3            node.color=RED, mean is mixed up to 3-node
   *      / \              /   \
   *     T2 T3            T1   T2
   */
  private Node leftRotate(Node node){
    Node x = node.right;
    // 左旋转
    node.right = x.left;
    x.left = node;

    x.color = node.color;
    node.color = RED;

    return x;
  }

  /**
   * y, x ALL RED
   *     node                   x
   *    /   \     右旋转       /  \
   *   x    T2   ------->   y   node
   *  / \                       /  \
   * y  T1                     T1  T2
   */
  private Node rightRotate(Node node) {
    Node x = node.left;

    // 右旋转
    node.left = x.right;
    x.right = node;

    x.color = node.color;
    node.color = RED;

    return x;
  }

  private void flipColors(Node node) {
    node.color = RED;
    node.left.color = BLACK;
    node.right.color = BLACK;
  }

  public void put(K key, V val) {
    root = put(root, key, val);
    root.color = BLACK; // use for definition2
  }

  private Node put(Node node, K key, V value) {
    if (node == null) {
      N++;
      return new Node(key, value); // insert a RED node
    }
    int cmp = key.compareTo(node.key);
    if (cmp == 0)
      node.val = value; // cover
    else if (cmp < 0)
      node.left = put(node.left, key, value);
    else if (cmp > 0)
      node.right = put(node.right, key, value);

    return reBalanceByColor(node);
  }

  private Node reBalanceByColor(Node node) {
    if (isRed(node.right) && !isRed(node.left))
      node = leftRotate(node);
    if (isRed(node.left) && isRed(node.left.left))
      node = rightRotate(node);
    if (isRed(node.left) && isRed(node.right))
      flipColors(node);
    return node;
  }

  private Node getNode(Node node, K key) {
    if (node == null)
      return null;

    int cmp = key.compareTo(node.key);
    if (cmp < 0)
      return getNode(node.left, key);
    else if (cmp > 0)
      return getNode(node.right, key);
    else
      return node;
  }

  public boolean contains(K key) {
    return getNode(root, key) != null;
  }

  public V get(K key) {
    Node node = getNode(root, key);
    return node == null ? null : node.val;
  }

  public void set(K key, V val) {
    Node node = getNode(root, key);
    if (node == null)
      throw new IllegalArgumentException();

    node.val = val;
  }

  private static final boolean RED = true;
  private static final boolean BLACK = false;

  private class Node {
    public K key;
    public V val;
    public Node left, right;
    public boolean color; // color use for 2-3tree equivalent

    public Node(K key, V val) {
      this.key = key;
      this.val = val;
      left = null;
      right = null;
      color = RED; // 默认 RED 用于与 BLACK 融合
    }
  }
}