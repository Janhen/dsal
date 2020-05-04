package com.janhen.structures.skipList;

import java.util.ArrayList;
import java.util.Iterator;

public class SkipList {

  class SkipListNode {
    public Integer value;
    public ArrayList<SkipListNode> nextNodes; // 10 --> 10 level
    // nextNode[9] == 第 9 层下一个节点

    public SkipListNode(Integer value) {
      this.value = value;
      nextNodes = new ArrayList<SkipListNode>();
    }
  }

  private SkipListNode head; // 巨小
  private int maxLevel; // 根据所有数据的最大层
  private int size; // key
  private static final double PROBABILITY = 0.5; // P

  public SkipList() {
    size = 0;
    maxLevel = 0;
    head = new SkipListNode(null);
    head.nextNodes.add(null);
  }

  public SkipListNode getHead() {
    return head;
  }

  //                  ___10
  // ___7             |o|
  // |o|  ___8    o   |o|   add 9 5
  // |o|  |o|     o   |o|
  // |o|  |o|         |o|
  // |o|  |o|         |o|
  // |o|  |o|         |o|
  // ￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣
  // 过程 : 高层一旦跳一个, 底层跳 1 <<< x  个
  // 概率来实现
  public void add(Integer newValue) {
    if (!contains(newValue)) {
      size++;
      int level = 0;
      // random to decide level
      while (Math.random() < PROBABILITY) {
        level++;
      }
      // maintain maxLevel and smallest
      while (level > maxLevel) {
        head.nextNodes.add(null);
        maxLevel++;
      }
      // from smallest to search
      // find 0 level
      SkipListNode newNode = new SkipListNode(newValue);
      SkipListNode current = head;
      do { // **Core
        current = findNext(newValue, current, level); // 小于， 向下直到 0 层
        newNode.nextNodes.add(0, current.nextNodes.get(level)); // add 0 list 性质, 放在第一个索引位置
        current.nextNodes.set(level, newNode);
      } while (level-- > 0);
    }
  }

  public void delete(Integer deleteValue) {
    if (contains(deleteValue)) {
      SkipListNode deleteNode = find(deleteValue);
      size--;
      int level = maxLevel;
      SkipListNode current = head;
      do {
        current = findNext(deleteNode.value, current, level);
        if (deleteNode.nextNodes.size() > level) {
          current.nextNodes.set(level, deleteNode.nextNodes.get(level));
        }
      } while (level-- > 0);
    }
  }

  // Returns the skiplist node with greatest value <= e
  private SkipListNode find(Integer e) {
    return find(e, head, maxLevel);
  }

  // Returns the skiplist node with greatest value <= e
  // Starts at node start and level
  private SkipListNode find(Integer e, SkipListNode current, int level) {
    do {
      current = findNext(e, current, level);
    } while (level-- > 0);
    return current;
  }

  // ￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣
  //     _                           ___17
  //    |o|                  _ 15    |o|
  //    |o|  ___10          |o|      |o|							              0 -> null
  //    |o|  |o|    ___14   |o|      |o|     add 14   对于 10 节点 nextNodes     1 -> 14 节点
  //    |o|  |o|    |o|     |o|      |o|                                        2 -> 15  节点
  // ￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣
  // Returns the node at a given level with highest value less than e
  private SkipListNode findNext(Integer e, SkipListNode current, int level) {
    SkipListNode next = current.nextNodes.get(level);  // levelth node
    while (next != null) {
      Integer value = next.value;
      if (lessThan(e, value)) { // e < value    //  7 -> 10   add 8
        break;
      }                  // right move
      current = next;   // e > value         // 5 -> 8 -> 10    add 10
      next = current.nextNodes.get(level);
    }
    // current 为当前层最后一个小于当前数的
    return current;
  }

  public int size() {
    return size;
  }

  public boolean contains(Integer value) {
    SkipListNode node = find(value);
    return node != null && node.value != null && equalTo(node.value, value);
  }

  public Iterator<Integer> iterator() {
    return new SkipListIterator(this);
  }


  private boolean lessThan(Integer a, Integer b) {
    return a.compareTo(b) < 0;
  }

  private boolean equalTo(Integer a, Integer b) {
    return a.compareTo(b) == 0;
  }

  public class SkipListIterator implements Iterator<Integer> {
    SkipList     list;
    SkipListNode current;

    public SkipListIterator(SkipList list) {
      this.list = list;
      this.current = list.getHead();
    }

    @Override
    public boolean hasNext() {
      return current.nextNodes.get(0) != null;
    }

    @Override
    public Integer next() {
      current = current.nextNodes.get(0);
      return current.value;
    }
  }
}
