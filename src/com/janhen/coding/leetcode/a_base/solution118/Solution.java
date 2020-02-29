package com.janhen.leetcode.a_base.solution118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) return res;

        res.add(Arrays.asList(1));
        if (numRows == 1)
            return res;
        res.add(Arrays.asList(1,1));
        if (numRows == 2)
            return res;
        for (int i = 2; i < numRows; i ++) {
            List<Integer> preList = res.get(i-1);
            List<Integer> curList = new ArrayList<>();
            curList.add(1);
            for (int j = 1; j < i; j ++)
                curList.add(j, preList.get(j-1) + preList.get(j));  // add not set
            curList.add(i, 1);
            res.add(new ArrayList<>(curList));
        }
        return res;
    }
}
