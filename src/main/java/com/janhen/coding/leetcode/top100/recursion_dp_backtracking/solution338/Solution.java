package main.java.janhen.leetcode.top100.recursion_dp_backtracking.solution338;

/*
 * 2 ms, faster than 54.35%
 * O(n*sizeOf(num))
 */
class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i ++)
            res[i] = countOfOneBit(i);
        return res;
    }

    private int countOfOneBit(int n) {
        int cnt = 0;
        while (n != 0) {
            n = n & (n-1);
            cnt ++;
        }
        return cnt;
    }
}