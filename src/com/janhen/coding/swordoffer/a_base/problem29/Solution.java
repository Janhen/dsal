package com.janhen.coding.swordoffer.a_base.problem29;

import java.util.ArrayList;

public class Solution {
    public  ArrayList<Integer> printMatrix(int[][] m) {
        ArrayList<Integer> res = new ArrayList<>();
        if (m == null || m.length == 0)
            return res;
        int up = 0, left = 0, bottom = m.length - 1, right = m[0].length - 1;
        int layers = (Math.min(m.length, m[0].length) - 1) / 2 + 1;
        // also can left <= right && up <= bottom
        while (layers -- > 0)
            visitEdge(m, up ++, left ++, bottom --, right --, res);
        return res;
    }

    private void visitEdge(int[][] m, int up, int left, int bottom, int right, ArrayList<Integer> res) {
        // one col
        if (left == right) {
            for (int i = up; i <= bottom; i ++)
                res.add(m[i][left]);
            return;
        }
        // one row
        if (up == bottom) {
            for (int i = left; i <= right; i ++)
                res.add(m[up][i]);
            return;
        }
        // →
        for (int i = left; i < right; i ++)
            res.add(m[up][i]);
        // ↓
        for (int i = up; i < bottom; i ++)
            res.add(m[i][right]);
        // ←
        for (int i = right; i > left; i --)
            res.add(m[bottom][i]);
        // ↑
        for (int i = bottom; i > up; i --)
            res.add(m[i][left]);
    }
}
