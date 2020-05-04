package main.java.janhen.leetcode.search.practice.solution16;

// 16. 3Sum Closest
// https://leetcode.com/problems/3sum-closest/
// Medium
// array, two pointers

/* Given an array nums of n integers and an integer target,
find three integers in nums such that the sum is closest to target.
Return the sum of the three integers.
You may assume that each input would have exactly one solution15.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).*/

import java.util.Arrays;

public class Solution2 {

    // 对含有重复元素的加速优化
    // 13 ms, faster than 63.06%
    // time: O(n^2)
    public int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[nums.length - 1];    // initialization
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i ++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > target) {
                    while (l < r && nums[r] == nums[r - 1]) r --;     // find last duplicated element
                    r --;               // find first element not duplicated
                }
                else  {
                    while (l < r && nums[l] == nums[l+1]) l ++;
                    l ++;
                }
                if (Math.abs(sum - target) < Math.abs(res - target))
                    res = sum;
            }
        }
        return res;
    }
}
