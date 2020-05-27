package com.janhen.structures.unionfind;

/// Leetcode 547. Friend Circles
/// https://leetcode.com/problems/friend-circles/description/

import com.janhen.TestUtil;
import org.junit.Test;

import java.util.Random;

public class Main {

  private static double testUF(UF uf, int m) {

    int size = uf.size();
    Random random = new Random();
    long start = System.nanoTime();

    for (int i = 0; i < m; i++) {
      int a = random.nextInt(size);
      int b = random.nextInt(size);
      uf.unionElements(a, b);
    }

    for (int i = 0; i < m; i++) {
      int a = random.nextInt(size);
      int b = random.nextInt(size);
      uf.isConnected(a, b);
    }

    return (System.nanoTime() - start) / 1E9;
  }

  public static void main(String[] args) {
    /*
     * - quickFind 数组连续空间的优化 - find 操作 耗时 高
     */
    int size = 10000;
    int m = 10000;

    UF quickFind = new com.janhen.structures.unionfind.quickFind.UnionFind(size);
    UF quickUnion = new com.janhen.structures.unionfind.quickUnion.UnionFind(size);
    UF sizeOptimize = new com.janhen.structures.unionfind.sizeOptimize.UnionFind(size);
    UF rankOptimize = new com.janhen.structures.unionfind.rankOptimize.UnionFind(size);
    UF pathCompression = new com.janhen.structures.unionfind.pathCompression.UnionFind(size);
    UF pathCompressionRecursion = new com.janhen.structures.unionfind.pathCompressionRecursion.UnionFind(
        size);
    double t1 = testUF(quickFind, m);
    System.out.println("Quick Find run :  " + t1);
    double t2 = testUF(quickUnion, m);
    System.out.println("Quick Union run : " + t2);
    double t3 = testUF(sizeOptimize, m);
    System.out.println("Optimize Size Quick Union run : " + t3);
    double t4 = testUF(rankOptimize, m);
    System.out.println("Optimize Rank Quick Union run : " + t4);
    double t5 = testUF(pathCompression, m);
    System.out.println("Optimize pathCompression Quick Union run : " + t5);
    double t6 = testUF(pathCompressionRecursion, m);
    System.out.println("Optimize pathCompressionRecursion Quick Union run : " + t6);

    TestUtil.rate(15, t1, t2, t3, t4, t5, t6);
  }

  @Test
  public void testOptimize() {

    int size = (int) 1E7;
    int m = (int) 1E7;

    UF sizeOptimize = new com.janhen.structures.unionfind.sizeOptimize.UnionFind(size);
    UF rankOptimize = new com.janhen.structures.unionfind.rankOptimize.UnionFind(size);
    UF pathCompressionOptimize = new com.janhen.structures.unionfind.pathCompression.UnionFind(
        size);
    UF pathCompressionRecursionOptimize = new com.janhen.structures.unionfind.pathCompressionRecursion.UnionFind(
        size);
    double t1 = testUF(sizeOptimize, m);
    System.out.println("Optimize size Quick Union run : " + t1);
    double t2 = testUF(rankOptimize, m);
    System.out.println("Optimize rank Quick Union run : " + t2);
    double t3 = testUF(pathCompressionOptimize, m);
    System.out.println("Optimize path compression Quick Union run : " + t3);
    double t4 = testUF(pathCompressionRecursionOptimize, m);
    System.out.println("Optimize path compression recursion Quick Union run : " + t4);

    System.out.println("Rate : " + TestUtil.rate(15, t1, t2, t3, t4));
  }
}
