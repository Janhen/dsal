package com.janhen.structures.trie;

// /// Leetcode 211. Add and Search Word - Data structures design
///// https://leetcode.com/problems/add-and-search-word-data-structure-design/description/

import com.janhen.structures.set_map.set.BSTSet;
import com.janhen.FileUtils;

import java.util.List;

public class Main {

  public static void main(String[] args) {

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
