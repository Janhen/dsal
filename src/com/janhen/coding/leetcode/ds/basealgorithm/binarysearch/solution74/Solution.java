package com.janhen.coding.leetcode.ds.basealgorithm.binarysearch.solution74;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;

        int m = matrix.length, n = matrix[0].length;
        // search from the top right corner
        int r = 0, c = n - 1;
        while (r < m && c >= 0) {
            if (matrix[r][c] == target)
                return true;
            else if (matrix[r][c] < target)
                r++;
            else
                c--;
        }
        return false;
    }
}