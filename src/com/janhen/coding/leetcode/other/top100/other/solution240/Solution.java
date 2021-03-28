package com.janhen.coding.leetcode.other.top100.other.solution240;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        int m = matrix.length, n = matrix[0].length;
        int r = 0, c = n-1;
        while (r < m && c >= 0) {
            if (matrix[r][c] == target)
                return true;
            else if (matrix[r][c] > target)
                c --;     // in left
            else
                r ++;    // in down
        }
        return false;
    }
}