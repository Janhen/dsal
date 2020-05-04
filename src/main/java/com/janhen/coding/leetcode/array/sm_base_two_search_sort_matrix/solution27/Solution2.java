package main.java.janhen.leetcode.array.sm_base_two_search_sort_matrix.solution27;

class Solution2 {
    // 对极端情况处理: 都是相同元素
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i ++)
            if (nums[i] != val)
                if (i != k) swap(nums, k ++, i);
                else k ++;
        return k;
    }

    private static void swap(int[] a, int i, int j) {        // if (i==j) return ⇔
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
