package com.janhen.coding.leetcode.other.top100.other.solution146;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

  private class Node {
    Integer key;
    Integer val;
    Node prev;
    Node next;

    public Node(Integer key, Integer val) {
      this.key = key;
      this.val = val;
    }
  }

  private Map<Integer, Node> cache;
  private Integer capacity;
  private Node head;
  private Node tail;


  public LRUCache(int capacity) {
    this.cache = new HashMap<>(capacity / 4 * 3);
    this.capacity = capacity;
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
      Node node = cache.get(key);
      node.val = value;
      remove(node);
      setHead(node);
    } else {
      Node node = new Node(key, value);
      if (cache.size() >= capacity) {
        System.out.println("Cache is full, Removing element: " + tail.key);
        cache.remove(tail.key);
        remove(tail);
        setHead(node);
        cache.put(key, node);
      } else {
        setHead(node);
        cache.put(key, node);
      }
    }
  }

  // remove node from dequeue
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

  // node is new node
  private void setHead(Node node) {
    node.next = head;
    node.prev = null;
    if (head == null) {
      head = node;
    } else {
      head.prev = node;
      head = node;
    }
    if (tail == null) {
      tail = node;
    }
  }
}