package com.janhen.coding.leetcode.other.solution211;

// 211. Add and Search Word - Data structures design
// https://leetcode.com/problems/add-and-search-word-data-structure-design/description/

import java.util.HashMap;
import java.util.Map;

class WordDictionary2 {

    private class Node {
        public int                  path;
        public int                  end;
        public Map<Character, Node> nexts;

        public Node() {
            path = 0;
            end = 0;
            nexts = new HashMap<>();
        }
    }

    private Node root;

    public WordDictionary2() {
        root = new Node();
    }

    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char v = word.charAt(i);
            if (cur.nexts.get(v) == null)
                cur.nexts.put(v, new Node());
            cur = cur.nexts.get(v);
            cur.path++;
        }
        cur.end++;
    }

    public boolean search(String word) {

        return match(root, word, 0);
    }


    private boolean match(Node node, String word, int index) {
        if (index == word.length())
            return node.end != 0;

        char c = word.charAt(index);
        if (c != '.') {
            if (node.nexts.get(c) == null)
                return false;
            // next char
            return match(node.nexts.get(c), word, index + 1);
        } else {
            for (char nextChar : node.nexts.keySet()) {
                if (match(node.nexts.get(nextChar), word, index + 1))
                    return true;
            }
            return false;
        }
    }
}
