package com.janhen.structures.setandmap.map;

public class LinkedListMap<K, V> implements Map<K, V> {

  private Node dummyHead;
  private int N;

  public LinkedListMap() {
    dummyHead = new Node();
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

  private Node getNode(K key) {
    Node cur = dummyHead.next;
    while (cur != null) {
      if (cur.key.equals(key)) { // ★ reference
        return cur;
      }
      cur = cur.next;
    }
    return null;
  }

  @Override
  public boolean contains(K key) {
    return getNode(key) != null;
  }

  @Override
  public V get(K key) {
    return getNode(key).val;
  }

  @Override
  public void put(K key, V val) {
    Node node = getNode(key);
    if (node == null) {
      // put to head
      dummyHead.next = new Node(key, val, dummyHead.next);
      // Node newNode = new Node(key, val);
      // newNode.next = dummyHead.next;
      // dummyHead.next = newNode;
      N++;
    } else {
      node.val = val;
    }
  }

  @Override
  public void set(K key, V val) {
    Node node = getNode(key);
    if (node == null) {
      throw new IllegalArgumentException();
    }
    node.val = val;
  }

  @Override
  public V remove(K key) {
    Node prev = dummyHead;
    while (prev.next != null) {
      if (prev.next.key.equals(key)) {
        break;
      }
      prev = prev.next;
    }

    // have the node
    if (prev.next != null) {
      Node delNode = prev.next;
      prev.next = delNode.next;

      delNode.next = null;
      N--;
      return delNode.val;
    }

    return null;
  }

  private class Node {
    public K key;
    public V val;
    public Node next;

    public Node() {
      this(null, null, null);
    }

    public Node(K key, V val) {
      this(key, val, null);
    }

    public Node(K key, V val, Node next) {
      this.key = key;
      this.val = val;
      this.next = next;
    }

    @Override
    public String toString() {
      return key.toString() + " : " + val.toString();
    }
  }
}
