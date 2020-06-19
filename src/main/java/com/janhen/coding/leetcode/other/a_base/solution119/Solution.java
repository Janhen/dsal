package com.janhen.coding.leetcode.a_base.solution119;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  private List<List<Integer>> record = new ArrayList<>();

  public Solution() {
    List<Integer> list1 = Arrays.asList(1);
    List<Integer> list2 = Arrays.asList(1, 1);
    record.add(list1);
    record.add(list2);

    // Specify the size to find value
    for (int i = 2; i <= 33; i++) {
      List<Integer> list = new ArrayList<>();    // size == i + 1
      list.add(1);
      List<Integer> preList = record.get(i - 1);
      for (int j = 1; j < i; j++) {
        list.add(preList.get(j - 1) + preList.get(j));
      }
      list.add(1);
      record.add(list);
    }
  }

  // 6 ms, faster than 3.18%
  public List<Integer> getRow(int rowIndex) {
    return record.get(rowIndex);
  }
}