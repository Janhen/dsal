package main.java.janhen.swordoffer.a_base.problem4;

public class Solution {
    public boolean Find(int target, int [][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int r = 0, c = n - 1;
        while (c >= 0 && r < m) {
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