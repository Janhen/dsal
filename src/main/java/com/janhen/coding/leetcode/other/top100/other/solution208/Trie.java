package com.janhen.coding.leetcode.other.top100.other.solution208;

class Trie {

    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i ++) {
            int index = indexForChar(word.charAt(i));
            if (cur.nexts[index] == null)
                cur.nexts[index] = new TrieNode();
            cur = cur.nexts[index];
        }
        if (!cur.isWord)
            cur.isWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i ++) {
            int index = indexForChar(word.charAt(i));
            if (cur.nexts[index] == null)
                return false;
            cur = cur.nexts[index];
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i ++) {
            int index = indexForChar(prefix.charAt(i));
            if (cur.nexts[index] == null)
                return false;
            cur = cur.nexts[index];
        }
        return true;
    }

    private int indexForChar(char c) {
        return c - 'a';
    }

    class TrieNode {
        boolean isWord;
        TrieNode[] nexts;

        TrieNode() {
            nexts = new TrieNode[26];
        }
    }
}
