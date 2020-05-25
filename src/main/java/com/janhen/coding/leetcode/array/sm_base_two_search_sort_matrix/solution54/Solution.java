package com.janhen.coding.leetcode.array.sm_base_two_search_sort_matrix.solution54;

import java.util.ArrayList;

import static java.lang.Math.*;

public class Solution {

    public  ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;

        int m = matrix.length;
        int n = matrix[0].length;
        int up = 0, left = 0, bottom = m - 1, right = n - 1;
        int layers = (min(m, n) - 1) / 2 + 1;          // math ceil
        while (layers -- > 0)           // left <= right && up <= bottom
            printEdge(matrix, up ++, left ++, bottom --, right --, res);
        return res;
    }

    private void printEdge(int[][] m, int up, int left, int bottom, int right,  ArrayList<Integer> res) {
        // one column
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
