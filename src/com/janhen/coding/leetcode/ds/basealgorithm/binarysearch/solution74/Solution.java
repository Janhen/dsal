package com.janhen.coding.leetcode.ds.basealgorithm.binarysearch.solution74;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;

        int m = matrix.length, n = matrix[0].length;
        // search from the top right corner
        int row = 0, cow = n - 1;
        while (row < m && cow >= 0) {
            if (matrix[row][cow] == target)
                return true;
            else if (matrix[row][cow] < target)
                row++;
            else
                cow--;
        }
        return false;
    }
}