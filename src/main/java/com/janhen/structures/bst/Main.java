package com.janhen.structures.bst;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

  @Test
  public void testDeldMin() {
    BST<Integer> bst = new BST<>();
    Random random = new Random();

    int n = 1000;
    for (int i = 0; i < n; i++)
      bst.add(random.nextInt(10000));

    List<Integer> list = new ArrayList<>();
    while (!bst.isEmpty())
      list.add(bst.removeMin());
    System.out.println(list);

    for (int i = 1; i < list.size(); i++)
      if (list.get(i - 1) > list.get(i))
        throw new IllegalArgumentException();

    System.out.println("removeMin over.");

  }

  @Test
  public void testDelMax() {
    BST<Integer> bst = new BST<>();
    Random random = new Random();

    int n = 1000;
    for (int i = 0; i < n; i++)
      bst.add(random.nextInt(10000));

    List<Integer> list = new ArrayList<>();
    while (!bst.isEmpty())
      list.add(bst.removeMax());
    System.out.println(list);

    for (int i = 1; i < list.size(); i++)
      if (list.get(i - 1) < list.get(i))
        throw new IllegalArgumentException();

    System.out.println("removeMax over.");
  }
}
