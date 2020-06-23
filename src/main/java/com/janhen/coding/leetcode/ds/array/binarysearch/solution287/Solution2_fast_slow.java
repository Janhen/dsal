package com.janhen.coding.leetcode.ds.array.binarysearch.solution287;

// 287. Find the Duplicate Number
//https://leetcode.com/problems/find-the-duplicate-number/

/*
 * 快慢指针，先快慢轮询一遍，再慢慢轮询一遍
 * time:O(N) space:O(1)
 * 0 ms, faster than 100.00%
 */
class Solution2_fast_slow {
    // todo Q
    int findDuplicate(int[] nums) {
        if (nums.length > 1) {
            int slow = nums[0];
            int fast = nums[nums[0]];
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            fast = 0;
            while (fast != slow) {
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
        return -1;
    }
}