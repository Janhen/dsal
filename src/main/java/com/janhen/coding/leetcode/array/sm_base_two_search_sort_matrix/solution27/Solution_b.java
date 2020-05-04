package main.java.janhen.leetcode.array.sm_base_two_search_sort_matrix.solution27;

class Solution_b {
    // 交换
    // can save original value
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i ++)
            if (nums[i] != val)
                swap(nums, k ++, i);
        return k;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
