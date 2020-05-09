package com.janhen.coding.swordoffer.a_good.problem57_2;

import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer> >  res = new ArrayList<>();
        int L = 1, R = 2;
        int winSum = 3;   // window sum
        while (R < sum) {
            if (winSum < sum) {
                winSum += R + 1;
                R ++;
            } else if (winSum > sum) {
                winSum -= L;
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
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = L; i <= R; i ++)
            list.add(i);
        return list;
    }
}
