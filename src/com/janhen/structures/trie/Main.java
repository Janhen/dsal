package com.janhen.structures.trie;

// /// Leetcode 211. Add and Search Word - Data structures design
///// https://leetcode.com/problems/add-and-search-word-data-structure-design/description/

import com.janhen.FileUtils;
import com.janhen.structures.setandmap.set.BSTSet;
import org.junit.Test;

import java.util.List;

public class Main {

    //  @Test
    public void testTrie2() {
        Trie2 trie = new Trie2();
        System.out.println(trie.search("zuo")); // F
        trie.insert("zuo");
        System.out.println(trie.search("zuo")); // T
        trie.delete("zuo");
        System.out.println(trie.search("zuo")); // F
        trie.insert("zuo");
        trie.insert("zuo");
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));// T
        trie.delete("zuo");
        System.out.println(trie.search("zuo")); // F
        trie.insert("zuoa");
        trie.insert("zuoac");
        trie.insert("zuoab");
        trie.insert("zuoad");
        trie.delete("zuoa");
        System.out.println(trie.search("zuoa")); // F
        System.out.println(trie.prefixNumber("zuo")); // 3
    }

    @Test
    public void testTrie() {
        System.out.println("pride-and-prejjudice");

        List<String> words = FileUtils.readFile(
          "E:\\Data\\workspace_idea\\Play-with-Data-structures\\src\\main\\java\\com\\janhen\\pride-and-prejudice.txt");

        long start = System.nanoTime();

        BSTSet<String> set = new BSTSet<>();
        for (String word : words)
            set.add(word);

        double t1 = (System.nanoTime() - start) / 1E9;

        System.out.println("Total different words : " + set.size());
        System.out.println("BSTSet run : " + t1);

        // ------------

        start = System.nanoTime();

        Trie trie = new Trie();
        for (String word : words)
            trie.add(word);

        double t2 = (System.nanoTime() - start) / 1E9;

        System.out.println("Total different words : " + set.size());
        System.out.println("BSTSet run : " + t2);
    }
}
