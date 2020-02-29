package com.janhen.swordoffer.a_good.problem57_2;

import java.util.ArrayList;

public class Solution_bak {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer> >  res = new ArrayList<>();
        int L = 1, R = 2;
        int curSum = 3;   // window sum
        while (R < sum) {
            if (curSum < sum)
                curSum += ++R;
            else if (curSum > sum)
                curSum -= L ++;
            else {
                res.add(geneList(L, R));
                curSum -= L ++;
                curSum += ++ R;
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
