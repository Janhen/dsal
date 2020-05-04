package main.java.janhen.leetcode.array.sm_base_two_search_sort_matrix.solution15;

// 15. 3Sum
//https://leetcode.com/problems/3sum/
// Medium
// Array, Two Pointers

/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution62 set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution62 set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 控制结果中可含有重复元素, 整体结果在结果集中唯一
 * 多结果收集时, 命中之后 pointer 调整
 * [-2,0,0,2,2]
 * [-1,0,1,2,-1,-4]           [[-1,-1,2],[-1,0,1]]
 * 46 ms, faster than 87.32%
 */
class SolutionRef {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3)
            return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i ++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {           // find AND adjust l, r to prevent duplication
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l+1]) l ++;  // different way to find last duplication
                    while (l < r && nums[r] == nums[r-1]) r --;
                    l ++;             // l,r to first not duplication
                    r --;
                }
                else if (sum > 0) r --;
                else l ++;
            }
        }
        return res;
    }
}