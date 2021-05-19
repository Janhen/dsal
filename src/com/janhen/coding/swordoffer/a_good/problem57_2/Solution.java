package com.janhen.coding.swordoffer.a_good.problem57_2;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    // 滑动窗口处理
    // 在一个按序存储 1,2,3,4... 的数组中找连续的子数组和为给定数
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer> >  res = new ArrayList<>();
        int L = 1, R = 2;
        int winSum = 3;   // window sum
        while (R < sum) {
            if (winSum < sum) {
                winSum += R + 1;
                // expand window to find element
                R ++;
            } else if (winSum > sum) {
                winSum -= L;
                // narrow window to find element
                L ++;
            } else {
                res.add(geneList(L, R));
                winSum -= L;           // win shift right one bit
                L ++;
                winSum += R + 1;
                R ++;
            }
        }
        return res;
    }

    private ArrayList<Integer> geneList(int L, int R) {
        return IntStream.rangeClosed(L, R).boxed().collect(Collectors.toCollection(ArrayList::new));
    }
}
