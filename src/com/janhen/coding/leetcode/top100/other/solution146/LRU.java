package com.janhen.coding.leetcode.top100.other.solution146;

import java.util.HashMap;

class LRU<K, V> {

  private Node head;
  private Node tail;
  private HashMap<K, Node> map;
  private int capacity;

  private class Node {
    Node prev;
    Node next;
    K k;
    V v;

    public Node(K k, V v) {
      this.k = k;
      this.v = v;
    }
  }

  public LRU(int maxSize) {
    this.capacity = maxSize;
    this.map = new HashMap<>(maxSize * 4 / 3);
    head = new Node(null, null);
    tail = new Node(null, null);
    head.next = tail;
    tail.prev = head;
  }

  public V get(K key) {
    if (!map.containsKey(key)) {
      return null;
    }

    Node node = map.get(key);
    unlink(node);
    appendHead(node);

    return node.v;
  }

  public void put(K key, V value) {
    if (map.containsKey(key)) {
      Node node = map.get(key);
      unlink(node);
    }
    Node node = new Node(key, value);
    map.put(key, node);
    appendHead(node);
    if (map.size() > capacity) {
      Node toRemove = removeTail();
      map.remove(toRemove.k);
    }
  }

  private void unlink(Node node) {
    Node pre = node.prev;
    Node next = node.next;

    pre.next = next;
    next.prev = pre;

    node.prev = null;
    node.next = null;
  }

  private void appendHead(Node node) {
    Node next = head.next;
    node.next = next;
    next.prev = node;
    node.prev = head;
    head.next = node;
  }

  private Node removeTail() {
    Node node = tail.prev;

    Node pre = node.prev;
    tail.prev = pre;
    pre.next = tail;

    node.prev = null;
    node.next = null;

    return node;
  }
}