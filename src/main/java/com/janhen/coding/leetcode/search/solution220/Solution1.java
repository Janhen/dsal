package main.java.janhen.leetcode.search.solution220;

import java.util.TreeSet;

class Solution1 {
    // can handler integer overflow
    // 41 ms, faster than 28.02%
    // time : O(nlogn)
    // space : O(k)
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> record = new TreeSet<>();
        for (int i = 0; i < nums.length; i ++) {
            if (record.ceiling( (long) nums[i] - (long) t) != null &&      // NOTE: [i]-t=<x<=[i]+t, x∈record
                    record.ceiling((long) nums[i] - (long) t) <= (long) nums[i] + (long) t)
                return true;
            record.add((long) nums[i]);
            if (record.size() == k + 1)
                record.remove((long) nums[i - k]);
        }
        return false;
    }

    // 整形溢出问题  (1,2133333...)    nums[i] + t
    public static void main(String[] args) {
        int[] nums = {1,5,9,1,5,9};
        int k = 2;
        int t = 3;
        boolean res = (new Solution1()).containsNearbyAlmostDuplicate(nums, k, t);
        System.out.println(res);
    }
 }