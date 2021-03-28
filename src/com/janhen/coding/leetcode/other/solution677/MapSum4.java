package com.janhen.coding.leetcode.other.solution677;


import java.util.HashMap;
import java.util.Map;

// 61 ms, faster than 90.56%
class MapSum4 {

    private class Node {
        public int                  count;    // word record
        public int                  sum;      // pre sum record
        public Map<Character, Node> next;

        public Node() {
            next = new HashMap<>();
        }

        public boolean isWord() {
            return count != 0;
        }
    }

    private Node root;

    public MapSum4() {
        root = new Node();
    }

    // 直接维护该值
    public void insert(String word, int count) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.next.containsKey(c))
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
            cur.sum += count;
        }
        if (cur.isWord()) {
            int oldCount = cur.count;
            cur.count = 0;                // set not word
            insert(word, - oldCount);     // override
            cur.count = count;
            return;
        }
        cur.count = count;
    }

    // search
    public int sum(String prefix) {
        Node cur = root;
        for (char c : prefix.toCharArray()) {
            if (!cur.next.containsKey(c))
                return 0;
            cur = cur.next.get(c);
        }
        return cur.sum;
    }
}
