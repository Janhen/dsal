package com.janhen.coding.leetcode.dp.practice.solution376;

class Solution2 {

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

        int upMax = 0, downMax = 0;   // 以 up 为结尾的最大长度; 以 down 为结尾的最大长度
        if (nums[1] > nums[0])
            upMax = 2;
        else if (nums[1] < nums[0])
            downMax = 2;
        else {
            upMax = 1;
            downMax = 1;
        }

        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] > nums[i-1]) {
                downMax = Math.max(downMax, upMax + 1);
            } else if (nums[i] < nums[i-1]) {
                upMax = Math.max(upMax, downMax + 1);
            }
        }
        return Math.max(upMax, downMax);
    }
}