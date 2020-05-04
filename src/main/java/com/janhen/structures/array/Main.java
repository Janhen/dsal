package com.janhen.structures.array;

public class Main {

  public static void main(String[] args) {
    Array<Integer> arr = new Array<>(5);
    System.out.println(arr);
    for (int i = 0; i < 10; i++) {
      arr.addLast(i);
      System.out.println(arr);
    }

    System.out.println(arr);

    arr.add(1, 100);
    System.out.println(arr);

    arr.addFirst(-1);
    System.out.println(arr);
    // [-1, 0, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9]

    arr.removeFirst();
    arr.removeFirst();
    arr.removeFirst();
    arr.removeFirst();
    arr.removeLast();
    arr.removeLast();
    arr.removeLast();
    arr.removeLast();
    System.out.println(arr);

    for (int i = 20; i < 50; i++) {
      arr.add(i);
      System.out.println(arr);
    }
  }
}
