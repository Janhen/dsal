package com.janhen.leetcode.dp.practice.solution376;

class Solution {

    //For every position in the array, there are only three possible statuses for it.
    //
    //up position, it means nums[i] > nums[i-1]
    //down position, it means nums[i] < nums[i-1]
    //equals to position, nums[i] == nums[i-1]
    //So we can use two arrays up[] and down[] to record the max wiggle sequence length so far at index i.
    //If nums[i] > nums[i-1], that means it wiggles up. the element before it must be a down position. so up[i] = down[i-1] + 1; down[i] keeps the same with before.
    //If nums[i] < nums[i-1], that means it wiggles down. the element before it must be a up position. so down[i] = up[i-1] + 1; up[i] keeps the same with before.
    //If nums[i] == nums[i-1], that means it will not change anything becasue it didn't wiggle at all. so both down[i] and up[i] keep the same.
    //
    //In fact, we can reduce the space complexity to O(1), but current way is more easy to understanding.
    public int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length <= 1) return nums.length;

        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        up[0] = 1;
        down[0] = 1;
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] > nums[i-1]) {
                up[i] = down[i-1] + 1;
                down[i] = down[i-1];                       // previous
            } else if (nums[i] < nums[i-1]) {
                down[i] = up[i-1] + 1;
                up[i] = up[i-1];
            } else {
                up[i] = up[i-1];
                down[i] = down[i-1];
            }
        }
        return Math.max(up[nums.length-1], down[nums.length-1]);

    }
}