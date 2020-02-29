package com.janhen.swordoffer.a_good.problem17;

public class Solution {

    //对于大数，int|long 类型存在溢出问题，需要使用String类型来存放n位数，或者使用int[]数组
    // int[] 仿全排列
    public void print1ToMaxOfNDigits(int n) {
        if (n < 1) throw new RuntimeException();
        int[] nums = new int[n];
        int digit = 0;
        print1ToMaxOfNDigits(nums, digit);
    }

    private void print1ToMaxOfNDigits(int[] nums, int start) {
        if (start == nums.length) {
            printNumber(nums);
            return;
        }
        for (int i = 0; i < 10; i++) {
            nums[start] = i;
            print1ToMaxOfNDigits(nums, start + 1);
        }
    }

    private void printNumber(int[] nums) {
        int k = 0;
        while (k < nums.length && nums[k] == 0)
            k++;
        while (k < nums.length)
            System.out.print(nums[k++]);
        System.out.println();
    }

    public static void main(String[] args) {
       new Solution().print1ToMaxOfNDigits(3);
    }
}
