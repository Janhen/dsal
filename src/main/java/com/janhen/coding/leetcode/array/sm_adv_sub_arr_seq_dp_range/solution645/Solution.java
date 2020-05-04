package main.java.janhen.leetcode.array.sm_adv_sub_arr_seq_dp_range.solution645;

/**
 * 找出错误的数字
 * 15 ms, faster than 48.45%
 * O(nlogn), O(1)
 */
class Solution {
    // todo QQQ
    public int[] findErrorNums(int[] nums) {
        for (int i = 0; i < nums.length; i ++)
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i])
                swap(nums, i, nums[i] - 1);
        for (int i = 0; i < nums.length; i ++)
            if (nums[i] != i + 1)
                return new int[]{nums[i], i + 1};
        return null;
    }

    private void swap(int[] a, int i,int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}