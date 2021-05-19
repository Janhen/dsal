package com.janhen.coding.swordoffer.a_good.problem17;

// 17 打印从1到最大的n位数backup

public class Solution2 {
    // addOne to implement
    // int[] 数组保存数字, 并对数组保存的数字进行 +1，直到溢出
    public void printOneToNthDigits(int n) {
        if (n < 1)  throw new IllegalArgumentException();

        int[] arr = new int[n];
        while (!addOne(arr)) {
            printArray(arr);
        }
    }

    // isOverflow
    private boolean addOne(int[] nums) {
        int carry = 0;
        for (int i = nums.length - 1; i >= 0; i --) {   // from low bit to high bit
            int val = nums[i] + carry;
            if (i == nums.length-1)    // single bit
                val ++;
            carry = val / 10;

            nums[i] = val % 10;
            if (carry == 0)
                break;
            if (carry != 0 && i == 0)     // overflow
                return true;
        }
        return false;
    }

    private void printArray(int[] number) {
        int index = 0;
        while (index < number.length && number[index] == 0)
            index++;
        while (index < number.length)
            System.out.print(number[index++]);
        System.out.println();
    }

    public static void main(String[] args) {
        (new Solution2()).printOneToNthDigits(3);
    }
}