package main.java.janhen.leetcode.top100.other.solution136;

class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums)
            res ^= num;
        return res;
    }
}