package com.janhen.coding.leetcode.ds.basealgorithm.binarysearch.solution540;


class Solution {
    // todo JZOF
    // todo Q
    // 有序数组的 Single Element
    /*
     * 令 index 为 Single Element 在数组中的位置。
     * 如果 m 为偶数，并且 m + 1 <index，那么 nums[m] == nums[m + 1]；
     *    m + 1 >= index，那么 nums[m] != nums[m + 1]。
     *
     * 从上面的规律可以知道，
     * 如果 nums[m] == nums[m + 1]，那么 index 所在的数组位置为 [m + 2, h]，此时令 l = m + 2；
     * 如果 nums[m] != nums[m + 1]，那么 index 所在的数组位置为 [l, m]，此时令 h = m。
     *
     * 因为 h 的赋值表达式为 h = m，那么循环条件也就只能使用 l < h 这种形式。
     */
    public int singleNonDuplicate(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int m = lo + (hi - lo) / 2;
            if (m % 2 == 1) {
                m--;   // 保证 l/h/m 都在偶数位，使得查找区间大小一直都是奇数
            }
            if (nums[m] == nums[m + 1]) {
                lo = m + 2;
            } else {
                hi = m;
            }
        }
        return nums[lo];
    }
}