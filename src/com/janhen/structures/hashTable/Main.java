package com.janhen.structures.hashtable;

import com.janhen.FileUtils;
import com.janhen.structures.hashtable.resizeOptimize.HashTable;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class Main {

    @Test
    public void testHashCode() {
        System.out.println(Integer.valueOf(666).hashCode());

        System.out.println(Integer.valueOf(999).hashCode());


        System.out.println(Double.valueOf(3.1415926).hashCode());

        System.out.println("sdfsdfskfjlksjk".hashCode());


        Student student = new Student(3, 54, "DDD", "eee");
        System.out.println(student.hashCode());
        Student student2 = new Student(3, 54, "ddd", "eee");
        System.out.println(student2.hashCode());

    }

    @Test
    public void testHashTable() {
        System.out.println("pride-and-prejudice");

        HashTable<String, Integer> map = new com.janhen.structures.hashtable.resizeOptimize.HashTable<>();
        List<String> words = FileUtils.readFile("src//pride-and-prejudice.txt");
        System.out.println("Total words : " + words.size());

        for (String word : words) {
            if (map.contains(word))
                map.set(word, map.get(word) + 1);
            else
                map.put(word, 1);
        }

        System.out.println("Total different words : " + map.size());
        System.out.println("Frequency of PRIDE : " + map.get("pride"));
        System.out.println("Frequency of PREJUDICE : " + map.get("prejudice"));
    }

    @Test
    public void hashTable() {
        System.out.println("pride-and-prejudice");

        HashMap<String, Integer> map = new HashMap<>();
        List<String> words = FileUtils.readFile("src//pride-and-prejudice.txt");
        System.out.println("Total words : " + words.size());

        for (String word : words) {
            if (map.containsKey(word))
                map.replace(word, map.get(word) + 1);
            else
                map.put(word, 1);
        }
        System.out.println("Total different words : " + map.size());
        System.out.println("Frequency of PRIDE : " + map.get("pride"));
        System.out.println("Frequency of PREJUDICE : " + map.get("prejudice"));
    }
}
