package com.janhen.coding.leetcode.leetcode.solution677;

class MapSum {

    private class TrieNode {
        int count;
        TrieNode[] nexts;

        TrieNode() {
            nexts = new TrieNode[26];
        }
    }

    TrieNode root;

    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String word, int count) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i ++) {
            int index = indexForChar(word.charAt(i));
            if (cur.nexts[index] == null)
                cur.nexts[index] = new TrieNode();
            cur = cur.nexts[index];
        }
        cur.count = count;
    }

    public int sum(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i ++) {
            int index = indexForChar(prefix.charAt(i));
            if (cur.nexts[index] == null)
                return 0;
            cur = cur.nexts[index];
        }
        return sum(cur);
    }

    private int sum(TrieNode node) {
        int sum = node.count;
        for (TrieNode n : node.nexts)
            sum += n.count;
        return sum;
    }

    private int indexForChar(char c) {
        return c - 'a';
    }
}