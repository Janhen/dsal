package com.janhen.leetcode.top100.other.solution208;

import java.util.*;

class Trie1 {

    TrieNode root = new TrieNode();;

    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i ++) {
            char c = word.charAt(i);
            if (cur.nexts.get(c) == null)
                cur.nexts.put(c, new TrieNode());
            cur = cur.nexts.get(c);
        }
        if (!cur.isWord)
            cur.isWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i ++) {
            char c = word.charAt(i);
            if (cur.nexts.get(c) == null)
                return false;
            cur = cur.nexts.get(c);
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i ++) {
            char c= prefix.charAt(i);
            if (cur.nexts.get(c) == null)
                return false;
            cur = cur.nexts.get(c);
        }
        return true;
    }

    class TrieNode {
        boolean isWord;
        Map<Character, TrieNode> nexts;    // char Unicode

        TrieNode() {
            nexts = new HashMap<>();
        }
    }
}
