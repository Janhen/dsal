package com.janhen.structures.BST;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Integer[] nums = {8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15};
        BST<Integer> bst = new BST<>(nums);

        bst.printTree();
        System.out.println(bst);
        bst.levelOrder();
        bst.preOrder();   // 8 4 2 1 3 6 5 7 12 10 9 11 14 13 15
        bst.inOrder();
        bst.postOrder();  // 1 3 2 5 7 6 4 9 11 10 13 15 14 12 8


        bst.removeMin();
        bst.printTree();
        bst.removeMax();
        bst.printTree();

        bst.remove(4);
        bst.printTree();

        bst.remove(111111111);
        bst.printTree();

    }

    @Test
    public void testDeldMin() {
        BST<Integer> bst = new BST<>();
        Random random = new Random();

        int n = 1000;
        for (int i = 0; i < n; i ++)
            bst.add(random.nextInt(10000));

        List<Integer> list = new ArrayList<>();
        while (!bst.isEmpty())
            list.add(bst.removeMin());
        System.out.println(list);

        for (int i = 1; i < list.size(); i ++)
            if (list.get(i - 1) > list.get(i))
                throw new IllegalArgumentException();

        System.out.println("removeMin over.");

    }

    @Test
    public void testDelMax() {
        BST<Integer> bst = new BST<>();
        Random random = new Random();

        int n = 1000;
        for (int i = 0; i < n; i ++)
            bst.add(random.nextInt(10000));

        List<Integer> list = new ArrayList<>();
        while (!bst.isEmpty())
            list.add(bst.removeMax());
        System.out.println(list);

        for (int i = 1; i < list.size(); i ++)
            if (list.get(i - 1) < list.get(i))
                throw new IllegalArgumentException();

        System.out.println("removeMax over.");
    }
}
