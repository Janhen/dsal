package com.janhen.structures.set_map.map;

import com.janhen.structures.avl.other.AVLMap;
import com.janhen.FileUtils;
import com.janhen.TestUtil;
import org.junit.Test;

import java.util.List;

public class Main {

  public static void main(String[] args) {
    String filename = "E:\\Data\\workspace_idea\\Play-with-Data-structures\\src\\main\\java\\com\\janhen\\pride-and-prejudice.txt";
    double t1 = testMap(new BSTMap<>(), filename);
    double t2 = testMap(new LinkedListMap<>(), filename);
    double t3 = testMap(new AVLMap<>(), filename);
    System.out.printf("BSTMap run : %f s\nLinkedListMap run : %f s\nAVLMap run : %f s\n", t1, t2,
        t3);
    TestUtil.rate(t1, t2, t3);
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
    System.out.println();
    return (System.nanoTime() - start) / 1E9;
  }

  @Test
  public void testAVLMap() {
    System.out.println("pride-and-prejudice");

    Map<String, Integer> map = new AVLMap<>();
    List<String> words = FileUtils.readFile(
        "E:\\Data\\workspace_idea\\Play-with-Data-structures\\src\\main\\java\\com\\janhen\\pride-and-prejudice.txt");
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
  public void testLinkedListMap() {
    System.out.println("pride-and-prejudice");

    Map<String, Integer> map = new LinkedListMap<>();
    List<String> words = FileUtils.readFile(
        "E:\\Data\\workspace_idea\\Play-with-Data-structures\\src\\main\\java\\com\\janhen\\pride-and-prejudice.txt");
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
  public void testBSTMap() {
    System.out.println("pride-and-prejudice");

    Map<String, Integer> map = new BSTMap<>();
    List<String> words = FileUtils.readFile(
        "E:\\Data\\workspace_idea\\Play-with-Data-structures\\src\\main\\java\\com\\janhen\\pride-and-prejudice.txt");
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
