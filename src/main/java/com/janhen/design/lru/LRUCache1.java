package com.janhen.design.lru;

import java.util.HashMap;

/**
 * 通过两个 dummy head, tail 的双端节点实现
 */
class LRUCache1 {
  private Node head;
  private Node tail;
  private HashMap<Integer, Node> map;
  private int capacity;

  private class Node {
    Node prev;
    Node next;
    Integer key;
    Integer val;

    public Node(Integer k, Integer v) {
      this.key = k;
      this.val = v;
    }
  }

  public LRUCache1(int capacity) {
    this.capacity = capacity;
    this.map = new HashMap<>(capacity * 4 / 3);
    head = new Node(null, null);
    tail = new Node(null, null); // two dummy
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    if (!map.containsKey(key)) {
      return -1;
    }
    Node node = map.get(key);
    unlink(node);
    appendHead(node);
    return node.val;
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      Node node = map.get(key);
      unlink(node);
    }
    Node node = new Node(key, value);
    map.put(key, node);
    appendHead(node);
    if (map.size() > capacity) {
      Node toRemove = removeTail();
      map.remove(toRemove.key);
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