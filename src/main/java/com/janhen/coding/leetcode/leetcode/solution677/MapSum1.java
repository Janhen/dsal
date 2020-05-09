package com.janhen.coding.leetcode.leetcode.solution677;

import java.util.HashMap;
import java.util.Map;

// 67 ms, faster than 49.61%
class MapSum1 {

    private class TrieNode {
        public int                  count;   // 0 -> not word, other word AND count
        public Map<Character, TrieNode> next;

        public TrieNode() {
            next = new HashMap<>();
        }
    }

    private TrieNode root;

    public MapSum1() {
        root = new TrieNode();
    }

    public void insert(String word, int count) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i ++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                cur.next.put(c, new TrieNode());
            cur = cur.next.get(c);
        }
        cur.count = count;
    }

    // search + sum
    public int sum(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i ++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null)
                return 0;
            cur = cur.next.get(c);
        }
        return sum(cur);
    }

    // R, get all sub node  AND sum
    private int sum(TrieNode node) {
        if (node.next.size() == 0)
            return node.count;
        int sum = node.count;
        for (char c : node.next.keySet())
            sum += sum(node.next.get(c));
        return sum;
    }
}