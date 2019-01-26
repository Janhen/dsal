package com.janhen.structures.trie;

public interface ITrie {

    void add(String word);

    boolean contains(String word);

    boolean isPrefix(String prefix);
}
