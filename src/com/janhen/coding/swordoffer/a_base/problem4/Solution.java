package com.janhen.coding.swordoffer.a_base.problem4;

public class Solution {
    // time: O(N+M), space: O(1)
    public boolean Find(int target, int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = n - 1;
        while (row < m && col >= 0) {
            int val = matrix[row][col];
            if (val == target) {
                return true;
            } else if (val < target) {
                // in next col
                row++;
            } else {
                // in next row
                col--;
            }
        }
        return false;
    }
}