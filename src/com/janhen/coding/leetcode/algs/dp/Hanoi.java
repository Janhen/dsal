package com.janhen.coding.leetcode.algs.dp;

public class Hanoi {
  static void moveHanoi(int n, String a, String b, String c) {
    if (n == 1) {
      printInfo(n, a, c);
      return;
    }
    // 1 将n-1个盘子从A移动到B
    moveHanoi(n - 1, a, c, b);
    // 2 将编号为n的盘子从A移动到C
    printInfo(n, a, c);
    // 3 将n-1个盘子从B移动到C
    moveHanoi(n - 1, b, a, c);
  }

  static void printInfo(int num, String from, String to) {
    System.out.println("将编号为" + num + "号盘子，从" + from + "移动到" + to);
  }
}
