package com.janhen.leetcode.top100.other.solution208;

class TrieR {

    class TrieNode {
        boolean isWord;
        TrieNode[] nexts;

        TrieNode() {
            nexts = new TrieNode[26];
        }
    }

    TrieNode root;

    public TrieR() {
        root = new TrieNode();
    }

    public void insert(String word) {
        insert(word, 0, root);
    }

    private void insert(String word, int path, TrieNode node) {
        if (node == null) return;
        if (path == word.length()) {
            node.isWord = true;
            return;
        }
        int index = indexForChar(word.charAt(path));
        if (node.nexts[index] == null)
            node.nexts[index] = new TrieNode();
        insert(word, path + 1, node.nexts[index]);
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int path, TrieNode node) {
        if (node == null)
            return false;
        if (path == word.length())
            return node.isWord;
        int index = indexForChar(word.charAt(path));
        if (node.nexts[index] == null)
            return false;
        return search(word, path + 1,  node.nexts[index]);
    }

    public boolean startsWith(String prefix) {
        return startsWith(prefix, 0, root);
    }

    private boolean startsWith(String prefix, int path, TrieNode node) {
        if (node == null)
            return false;
        if (prefix.length() == path)
            return true;
        int index = indexForChar(prefix.charAt(path));
        if (node.nexts[index] == null)
            return false;
        return startsWith(prefix, path + 1, node.nexts[index]);
    }

    private int indexForChar(char c) {
        return c - 'a';
    }
}
