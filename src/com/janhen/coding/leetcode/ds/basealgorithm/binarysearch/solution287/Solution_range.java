package com.janhen.coding.leetcode.ds.basealgorithm.binarysearch.solution287;

/*
 * 找出数组中重复的数，数组值在 [1, n] 之间
 * Pigeonhole Principle(鸽子洞原理)
 * 二分枚举答案范围，使用鸽笼原理进行检验
 *
 *
 * 根据鸽笼原理，给定 n+1 个范围为 [1, n]的整数，其中一定存在数字出现至少两次。
 *
 * 假设枚举的数字为 n / 2 ： 遍历数组，若数组中不大于 n / 2 的数字个数超过 n / 2 ，则可以确定 [1, n/2] 范围内一定有解，
 *
 * 否则可以确定解落在 (n/2, n]范围内。
 *
 *
 *
 * 也可以这样分析一下：
 *
 * 如果n 是5，那么就会有1 2 3 4 5 一共5个数字的可能，而array size 是6，那么其中一个数字肯定会至少出现两次。
 *
 * 如果没有重复的数字，小于等于1的数字 出现的次数 等于 1；
 *
 * 小于等于2的数字 出现的次数 等于 2；
 *
 * ... 同理3；4；5。
 *
 * 如果有重复的数字，如果重复的是1，那么 小于等于1的数字 出现的次数 肯定大于1；
 *
 * 基于这个理论，我们可以在1 2 3 4 5 选出一个 mid， 遍历array来count 小于等于mid 的数字个数 小于等于 它自己mid 还是 大于 mid？
 *
 * 如果count 小于等于mid， 说明 1 到 mid 这些数字 没有重复项， 重复项在 右半边 mid 到n， 所以缩小到右半边继续搜索；
 *
 * 如果count 大于mid， 说明 1 到 mid 这些数字中 有重复项，缩小到 左半边继续搜索。
 */


// O(nlogn) O(1)
class Solution_range {
    // 3 ms, faster than 48.83%
    public int findDuplicate(int[] nums) {
        int lo = 1, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cnt = countOfRange(nums, lo, mid);
            if (lo == hi)                   // [lo, hi] only have one element
                return cnt > 1 ? lo : -1;

            if (cnt > mid - lo + 1) hi = mid;   // duplication in left half
            else lo = mid + 1;
        }
        return -1;
    }

    private int countOfRange(int[] nums, int start, int end) {
        int cnt = 0;
        for (int num : nums)
            if (num <= end && num >= start)
                cnt++;
        return cnt;
    }
}