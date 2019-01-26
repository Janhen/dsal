package com.janhen.structures.trie;

import java.util.TreeMap;

public class Trie implements ITrie {

    private class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int N;

    public Trie() {
        root = new Node();
        N = 0;
    }

    public int size() {
        return N;
    }

    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i ++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                cur.next.put(c, new Node());

            cur = cur.next.get(c);
        }
        // tail and cur not word that mean not in trie
        if (!cur.isWord) {
            cur.isWord = true;
            N ++;
        }
    }

    // panda  , search pan
    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return cur.isWord;
        // return true;
    }

    public boolean isPrefix(String prefix) {

        Node cur = root;
        for (int i = 0; i < prefix.length(); i ++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return true;
    }
}
