package main.java.janhen.leetcode.dp.practice.solution303;

public class NumArray {

    // sums[i] = [0]+[1]+...+[i-1]
    // ⇒ sum(i,j) = sum[j+1] - sum[i]
    private int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 1; i < sums.length; i ++)
            sums[i] = sums[i - 1] + nums[i - 1];
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}