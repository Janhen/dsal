package com.janhen.structures.set_map.set;

import com.janhen.structures.avl.other.AVLSet;
import com.janhen.FileUtils;
import com.janhen.TestUtil;
import org.junit.Test;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String filename = "E:\\Data\\workspace_idea\\Play-with-Data-structures\\src\\main\\java\\com\\janhen\\pride-and-prejudice.txt";
        double t1 = testSet(new BSTSet<>(), filename);
        double t2 = testSet(new LinkedListSet<>(), filename);
        double t3 = testSet(new AVLSet<>(), filename);

        System.out.println("BST Set run : " + t1 + "s");
        System.out.println("linkedList Set run : " + t2 + "s");
        System.out.println("AVL Set run : " + t3 + "s");
        TestUtil.rate(t1, t2, t3);

    }

    private static double testSet(Set<String> set, String filename) {
        long start = System.nanoTime();

        System.out.println(filename);
        List<String> list = FileUtils.readFile(filename);

        System.out.println("Total words : " + list.size());

        for (String str : list) {
            set.add(str);
        }

        System.out.println("Toral different words : " + set.size());

        return (System.nanoTime() - start) / 1E9;
    }

    @Test
    void testAVLSet() {
        System.out.println("pride-and-prejudice");
        List<String> list = FileUtils.readFile("E:\\Data\\workspace_idea\\Play-with-Data-structures\\src\\main\\java\\com\\janhen\\pride-and-prejudice.txt");

        System.out.println("Total word : " + list.size());


        Set<String> set = new AVLSet<>();
        for (String str : list)
            set.add(str);
        System.out.println("Different word : " + set.size());


        System.out.println("a-tale-of-two-cities.txt");
        List<String> list2 = FileUtils.readFile("E:\\Data\\workspace_idea\\Play-with-Data-structures\\src\\main\\java\\com\\janhen\\a-tale-of-two-cities.txt");
        System.out.println("Total word : " + list2.size());

        Set<String> set2 = new BSTSet<>();
        for (String str : list2)
            set2.add(str);
        System.out.println("Different word : " + set2.size());
    }

    @Test
    public void testBSTSet() {
        System.out.println("pride-and-prejudice");
        List<String> list = FileUtils.readFile("E:\\Data\\workspace_idea\\Play-with-Data-structures\\src\\main\\java\\com\\janhen\\pride-and-prejudice.txt");

        System.out.println("Total word : " + list.size());


        Set<String> set = new BSTSet<>();
        for (String str : list)
            set.add(str);
        System.out.println("Different word : " + set.size());


        System.out.println("a-tale-of-two-cities.txt");
        List<String> list2 = FileUtils.readFile("E:\\Data\\workspace_idea\\Play-with-Data-structures\\src\\main\\java\\com\\janhen\\a-tale-of-two-cities.txt");
        System.out.println("Total word : " + list2.size());

        Set<String> set2 = new BSTSet<>();
        for (String str : list2)
            set2.add(str);
        System.out.println("Different word : " + set2.size());
    }

    @Test
    public void testLinkedSet() {
        System.out.println("pride-and-prejudice");
        List<String> list = FileUtils.readFile("E:\\Data\\workspace_idea\\Play-with-Data-structures\\src\\main\\java\\com\\janhen\\pride-and-prejudice.txt");

        System.out.println("Total word : " + list.size());


        Set<String> set = new LinkedListSet<>();
        for (String str : list)
            set.add(str);
        System.out.println("Different word : " + set.size());


        System.out.println("a-tale-of-two-cities.txt");
        List<String> list2 = FileUtils.readFile("E:\\Data\\workspace_idea\\Play-with-Data-structures\\src\\main\\java\\com\\janhen\\a-tale-of-two-cities.txt");
        System.out.println("Total word : " + list2.size());

        Set<String> set2 = new LinkedListSet<>();
        for (String str : list2)
            set2.add(str);
        System.out.println("Different word : " + set2.size());
    }
}
