package com.janhen.leetcode.a_base.solution119;

import java.util.ArrayList;
import java.util.List;

public class Solution_my {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i ++) {
            res.add(1);   // every time add one element
            for (int j = i - 1; j > 0; j --) {    // no need to handle 0,i position
                res.set(j, res.get(j - 1) + res.get(j));
            }
        }
        return res;
    }
}
