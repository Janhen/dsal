package com.janhen.structures.hashtable.base;

import com.janhen.FileUtils;
import org.junit.Test;

import java.util.List;

public class Main {
    @Test
    // 桶中存满, 桶中的红黑树深度不断增加
    public void testHashTable() {
        System.out.println("pride-and-prejudice");

        HashTable<String, Integer> map = new HashTable();
        List<String> words = FileUtils.readFile("src//pride-and-prejudice.txt");
        System.out.println("Total words : " + words.size());

        for (String word : words) {
            if (map.contains(word))
                map.set(word, map.get(word) + 1);
            else
                map.add(word, 1);
        }

        System.out.println("Total different words : " + map.size());
        System.out.println("Frequency of PRIDE : " + map.get("pride"));
        System.out.println("Frequency of PREJUDICE : " + map.get("prejudice"));
    }
}
