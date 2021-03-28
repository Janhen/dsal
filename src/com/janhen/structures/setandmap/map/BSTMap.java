package com.janhen.structures.setandmap.map;

/**
 * 基于二分查找树实现的Map
 *
 * @param <K>
 * @param <V>
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

  private Node root;
  private int N;

  public BSTMap() {
    root = null;
    N = 0;
  }

  @Override
  public int size() {
    return N;
  }

  @Override
  public boolean isEmpty() {
    return N == 0;
  }

  @Override
  public void put(K key, V val) {
    root = put(root, key, val);
  }

  private Node put(Node node, K key, V val) {

    if (node == null) {
      Node newNode = new Node(key, val);
      N++;
      return newNode;
    }

    int cmp = key.compareTo(node.key);
    if (cmp == 0) {
      node.val = val;
    } else if (cmp < 0) {
      node.left = put(node.left, key, val);
    } else {
      node.right = put(node.right, key, val);
    }

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
    else // cmp
      return node;
  }

  @Override
  public boolean contains(K key) {
    return getNode(root, key) != null;
  }

  @Override
  public V get(K key) {
    Node node = getNode(root, key);
    return node == null ? null : node.val;
  }

  @Override
  public void set(K key, V val) {
    Node node = getNode(root, key);
    if (node == null)
      throw new IllegalArgumentException();

    node.val = val;
  }

  @Override
  public V remove(K key) {
    Node node = getNode(root, key);
    if (node != null) {
      root = remove(root, key);
      N--;
      return node.val;
    }
    return null;
  }

  private Node remove(Node node, K key) {
    if (node == null)
      return null;

    int cmp = key.compareTo(node.key);
    if (cmp < 0) {
      node.left = remove(node.left, key);
      return node;
    } else if (cmp > 0) {
      node.right = remove(node.right, key);
      return node;
    } else { // cmp == 0
      // include leaf
      if (node.left == null) {
        Node rightNode = node.right;
        node.right = null;
        N--;
        return rightNode;
      }
      if (node.right == null) {
        Node leftNode = node.left;
        node.left = null;
        N--;
        return leftNode;
      }
      // have left and right node
      Node successor = minimum(node.right);
      node.key = successor.key;
      node.val = successor.val;
      node.right = remove(node.right, successor.key);
      return node;
    }
  }

  private Node minimum(Node node) {
    if (node.left == null)
      return node;
    return minimum(node.left);
  }

  private class Node {
    public K key;
    public V val;
    public Node left, right;

    public Node(K key, V val) {
      this.key = key;
      this.val = val;
      left = null;
      right = null;
    }
  }
}
