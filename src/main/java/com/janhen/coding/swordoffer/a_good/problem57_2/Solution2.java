package main.java.janhen.swordoffer.a_good.problem57_2;

import java.util.ArrayList;

public class Solution2 {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer> > res = new ArrayList<>();
        int lo = 1, hi = 2;
        while (lo < hi) {
            int curSum = (hi - lo + 1) * (lo + hi) / 2;  // n*(a1+an)/2
            if (curSum > sum)
                lo ++;
            else if (curSum < sum)
                hi ++;
            else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = lo; i <= hi; i++)
                    list.add(i);
                res.add(list);
                lo ++;
                hi ++;
            }
        }
        return res;
    }
}
