package com.janhen.coding.swordoffer.other.problem62;

import java.util.LinkedList;
import java.util.List;

public class Solution_my {
    public int LastRemaining_Solution(int n, int m) {
        if (n == 0)
            return -1;
        if (n == 1)
            return 0;

        // mock list
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i ++) {
            list.add(i);
        }

        int idx = 0;
        while (list.size() > 1) {
            idx = (idx + m - 1) % list.size();
            list.remove(idx);
        }
        return list.get(0);
    }
}
