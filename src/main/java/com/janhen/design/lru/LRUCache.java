package com.janhen.design.lru;

import java.util.HashMap;

class LRUCache {
  private HashMap<Integer, Node> cache;
  private int capacity;
  private Node head;
  private Node tail;

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

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.cache = new HashMap<>(capacity * 4 / 3);
  }

  public int get(int key) {
    if (!cache.containsKey(key)) {
      return -1;
    }
    Node node = cache.get(key);
    remove(node);
    setHead(node);
    return node.val;
  }

  public void put(int key, int value) {
    if (cache.containsKey(key)) {
      Node oldNode = cache.get(key);
      oldNode.val = value;
      remove(oldNode);
      setHead(oldNode);
    } else {
      Node newNode = new Node(key, value);
      if (cache.size() >= capacity) {
        System.out.println("Cache is FULL! Removing " + tail.val + " from cache...");
        cache.remove(tail.key);
        remove(tail);
      }
      setHead(newNode);
      cache.put(key, newNode);
    }
  }

  // remove from list node, note head tail edge
  private void remove(Node node) {
    if (node.prev != null) {
      node.prev.next = node.next;
    } else {
      head = node.next;
    }
    if (node.next != null) {
      node.next.prev = node.prev;
    } else {
      tail = node.prev;
    }
  }

  // make node(newNode or accessed node) to head
  private void setHead(Node node) {
    node.next = head;
    node.prev = null;

    // init or remove no element
    if (head != null) {
      head.prev = node;
    }
    head = node;

    // init or remove no element
    if (tail == null) {
      tail = head;
    }
  }
}