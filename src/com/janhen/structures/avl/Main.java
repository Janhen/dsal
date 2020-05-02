package com.janhen.structures.avl;

import com.janhen.FileUtils;
import com.janhen.TestUtil;
import com.janhen.structures.set_map.map.BSTMap;
import com.janhen.structures.set_map.map.LinkedListMap;
import com.janhen.structures.set_map.map.Map;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class Main {
  private double t1;
  private double t2;

  public static void main(String[] args) {
//        double t1 = testMap(new AVLTree<String, Integer>(), "E:\\Data\\workspace_idea\\Play-with-Data-structures\\src\\main\\java\\com\\janhen\\pride-and-prejudice.txt");
//        double t2 = testMap(new LinkedListMap<String, Integer>(), "E:\\Data\\workspace_idea\\Play-with-Data-structures\\src\\main\\java\\com\\janhen\\pride-and-prejudice.txt");
//        System.out.printf("AVLTree run : %f s\nLinkedListMap run : %f s\n", t1, t2);
  }

  private static double testMap(Map<String, Integer> map, String filename) {
    long start = System.nanoTime();

    System.out.println(filename.replaceAll(".*\\\\", "").replaceAll("\\..*", ""));
    List<String> words = FileUtils.readFile(filename);
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
    return (System.nanoTime() - start) / 1E9;
  }

  @Test
  public void test() {
    testBSTMap();
    testAVLTree();
    System.out.println("rate :   " + TestUtil.rate(t1, t2));
  }

  @Test
  public void testAVLTree() {
    List<String> words = FileUtils.readFile("src//pride-and-prejudice.txt");
    System.out.println("Total words : " + words.size());
    Collections.sort(words);

    long start = System.nanoTime();
    AVLTreeTest<String, Integer> map = new AVLTreeTest<>();
    for (String word : words) {
      if (map.contains(word))
        map.set(word, map.get(word) + 1);
      else
        map.add(word, 1);
    }
    for (String word : words)
      map.contains(word);

    System.out.println("AVLTree run : " + (t2 = (System.nanoTime() - start) / 1E9));
    System.out.println("Total different words : " + map.size());
    System.out.println("Frequency of PRIDE : " + map.get("pride"));
    System.out.println("Frequency of PREJUDICE : " + map.get("prejudice"));
    System.out.println("is still BST : " + map.isBST());
    System.out.println("is Balanced : " + map.isBalanced());

    for (String word : words) {
      map.remove(word);
      if (!map.isBST())
        System.out.println("not BST");
      if (!map.isBalanced()) {
        System.out.println("not balanced");
      }
    }
    System.out.println("remove can keep balance.");
  }


  @org.junit.Test
  public void testBSTMap() {
//        System.out.println("pride-and-prejudice");

    List<String> words = FileUtils.readFile("src//pride-and-prejudice.txt");
    System.out.println("Total words : " + words.size());
    Collections.sort(words);

    long start = System.nanoTime();
    BSTMap<String, Integer> map = new BSTMap<>();
    for (String word : words) {
      if (map.contains(word))
        map.set(word, map.get(word) + 1);
      else
        map.put(word, 1);
    }
    for (String word : words)
      map.contains(word);

    System.out.println("BSTMap run : " + (t1 = (System.nanoTime() - start) / 1E9));
//        System.out.println("Total different words : " + map.size());
//        System.out.println("Frequency of PRIDE : " + map.get("pride"));
//        System.out.println("Frequency of PREJUDICE : " + map.get("prejudice"));
  }

  @Test
  public void testLinkedListMap() {
    System.out.println("pride-and-prejudice");

    Map<String, Integer> map = new LinkedListMap<>();
    List<String> words = FileUtils.readFile("E:\\Data\\workspace_idea\\Play-with-Data-structures\\src\\main\\java\\com\\janhen\\pride-and-prejudice.txt");
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
}
