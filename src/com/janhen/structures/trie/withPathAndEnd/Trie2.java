package com.janhen.structures.trie.withPathAndEnd;

public class Trie2 {

    public final static int R = 256;

    public class Node {
        public int path;
        public int end;
        public Node[] nexts;

        public Node() {
            nexts = new Node[256];
            path = 0;
            end = 0;
        }
    }

    private Node root;
    private int N;   // 一共有多少个不重复的 word

    public void insert(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (cur.nexts[c] == null) {
                cur.nexts[c] = new Node();
            }
            cur = cur.nexts[c];
            cur.path ++;
        }
        cur.end ++;
        if (cur.end == 1)  // ★
            N ++;
    }

    public boolean search(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (cur.nexts[c] == null) {
                return false;
            }
            cur = cur.nexts[c];
        }
        return cur.end != 0;
    }

    public int prefixNumber(String prefix) {
        Node cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.nexts[c] == null) {
                return 0;
            }
            cur = cur.nexts[c];
        }
        return cur.path;
    }

    public void delete(String word) {
        if (search(word)) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                if (-- cur.nexts[c].path == 0) {
                    cur.nexts[c] = null;
                    N --; // ★  terminal in advance
                    return;
                }
                cur = cur.nexts[c];
            }
            cur.end --;
            if (cur.end == 0)
                N --;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println(trie.search("zuo"));  // F
        trie.insert("zuo");
        System.out.println(trie.search("zuo"));  // T
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));  // F
        trie.insert("zuo");
        trie.insert("zuo");
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));// T
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));  // F
        trie.insert("zuoa");
        trie.insert("zuoac");
        trie.insert("zuoab");
        trie.insert("zuoad");
        trie.delete("zuoa");
        System.out.println(trie.search("zuoa"));  // F
        System.out.println(trie.prefixNumber("zuo"));  // 3

    }

}
