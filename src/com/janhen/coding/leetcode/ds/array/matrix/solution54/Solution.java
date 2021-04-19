package com.janhen.coding.leetcode.ds.array.matrix.solution54;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return res;

        int m = matrix.length, n = matrix[0].length;
        int up = 0, left = 0, bottom = m - 1, right = n - 1;
        while (left <= right && up <= bottom)
            printEdge(matrix, up++, left++, bottom--, right--, res);
        return res;
    }

    // 逐层遍历
    private void printEdge(int[][] m, int up, int left, int bottom, int right, List<Integer> res) {
        // one column
        if (left == right) {
            for (int i = up; i <= bottom; i++)
                res.add(m[i][left]);
            return;
        }
        // one row
        if (up == bottom) {
            for (int i = left; i <= right; i++)
                res.add(m[up][i]);
            return;
        }

        // →
        for (int i = left; i < right; i++)
            res.add(m[up][i]);
        // ↓
        for (int i = up; i < bottom; i++)
            res.add(m[i][right]);
        // ←
        for (int i = right; i > left; i--)
            res.add(m[bottom][i]);
        // ↑
        for (int i = bottom; i > up; i--)
            res.add(m[i][left]);
    }
}
