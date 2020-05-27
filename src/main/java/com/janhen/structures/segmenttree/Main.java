package com.janhen.structures.segmenttree;

/// 303. Range Sum Query - Immutable
/// https://leetcode.com/problems/range-sum-query-immutable/description/

/// Leetcode 307. Range Sum Query - Mutable
/// https://leetcode.com/problems/range-sum-query-mutable/description/

public class Main {

  public static void main(String[] args) {
    Integer[] nums = {
        -2, 0, 3, -5, 2, -1 };

    // SegmentTree<Integer> segTree = new SegmentTree<>(nums, (a, b) -> {
    // return a + b;
    // });
    SegmentTree<Integer> segTree = new SegmentTree<>(nums, new SumMerger());

    System.out.println(segTree);
    System.out.println(segTree.query(0, 2));
    System.out.println(segTree.query(2, 4));
    System.out.println(segTree.query(2, 5));
    System.out.println(segTree.query(0, 5));
  }

  public static class SumMerger implements Merger<Integer> {

    @Override
    public Integer merge(Integer o1, Integer o2) {
      return o1 + o2;
    }
  }
}
