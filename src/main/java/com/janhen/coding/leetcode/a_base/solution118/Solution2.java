package com.janhen.coding.leetcode.a_base.solution118;

import com.janhen.TestUtil;

import java.util.ArrayList;
import java.util.List;

class Solution2 {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> res = new ArrayList<>(numRows);
    if (numRows == 0) return res;

    // allocate row size
    for (int i = 0; i < numRows; i++) {
      res.add(i, new ArrayList<>(i + 1));
    }

    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < res.get(i).size(); j++) {
        // init begin and end index value to 1
        res.get(i).add(0, 1);
        res.get(i).add(i, 1);

        if (i > 1 && j > 0 && j < i) {
          res.get(i).add(j, res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    TestUtil.printDouList(new Solution2().generate(10));
  }
}
