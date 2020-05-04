package main.java.janhen.leetcode.array.sm_binary_search.solution167;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {                    // must have two element
            int sum = nums[i] + nums[j];
            if (sum == target) return new int[]{i + 1, j + 1};  // not zero-based
            else if (sum < target)
                i ++;
            else
                j --;
        }
        throw new IllegalArgumentException();
    }
}