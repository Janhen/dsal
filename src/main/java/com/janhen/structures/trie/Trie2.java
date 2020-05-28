package com.janhen.structures.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie2 {

  public class Node {
    public int path;
    public int end;
    public Map<Character, Node> nexts;

    public Node() {
      nexts = new HashMap<>();
      path = 0;
      end = 0;
    }
  }

  private Node root;
  private int N;

  public Trie2() {
    root = new Node();
    N = 0;
  }

  public void insert(String word) {
    Node cur = root;
    for (char c : word.toCharArray()) {
      if (cur.nexts.get(c) == null) {
        cur.nexts.put(c, new Node());
      }
      cur = cur.nexts.get(c);
      cur.path++;
    }
    cur.end++;
  }

  public int getWordCount(String word) {
    Node cur = root;
    for (char c : word.toCharArray()) {
      if (cur.nexts.get(c) == null) {
        return 0;
      }
      cur = cur.nexts.get(c);
    }
    return cur.end;
  }

  public int prefixNumber(String prefix) {
    Node cur = root;
    for (char c : prefix.toCharArray()) {
      if (cur.nexts.get(c) == null) {
        return 0;
      }
      cur = cur.nexts.get(c);
    }
    return cur.path;
  }

  public boolean search(String word) {
    return getWordCount(word) != 0;
  }

  public void delete(String word) {
    if (search(word)) {
      Node cur = root;
      for (char c : word.toCharArray()) {
        if (--cur.nexts.get(c).path == 0) {
          cur.nexts.remove(c); // terminal in advance
          return; // ★ return
        }
        cur = cur.nexts.get(c);
      }
      cur.end--;
    }
  }
}
