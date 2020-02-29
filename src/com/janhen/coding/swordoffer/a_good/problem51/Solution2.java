package com.janhen.swordoffer.a_good.problem51;

public class Solution2 {
    private long cnt = 0;
    private int[] aux;

    public int InversePairs(int[] nums) {
        aux = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return (int) (cnt % 1000000007);
    }

    private void mergeSort(int[] nums, int l, int h) {
        if (h - l < 1)
            return;
        int m = l + (h - l) / 2;
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, h);
        merge(nums, l, m, h);
    }

    private void merge(int[] nums, int l, int m, int h) {
        int i = l, j = m + 1, k = l;
        while (i <= m || j <= h) {
            if (i > m)
                aux[k] = nums[j++];
            else if (j > h)
                aux[k] = nums[i++];
            else if (nums[i] < nums[j])
                aux[k] = nums[i++];
            else {
                aux[k] = nums[j++];
                this.cnt += m - i + 1;  // nums[i] >= nums[j]，说明 nums[i...mid] 都大于 nums[j]
            }
            k++;
        }
        for (k = l; k <= h; k++)
            nums[k] = aux[k];
    }
}