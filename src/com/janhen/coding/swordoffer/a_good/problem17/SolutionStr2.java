package com.janhen.coding.swordoffer.a_good.problem17;

import java.util.Arrays;

public class SolutionStr2 {

    // 使用 String 来存储数
    public void printOneToNthDigits2(int n) {
        if (n < 1)  throw new IllegalArgumentException();

        char[] arr = new char[n];
        Arrays.fill(arr, '0');          // char as int
        while (!addOne(arr)) {
            printArray(arr);
        }
    }

    private boolean addOne(char[] nums) {
        int carry = 0;
        for (int i = nums.length - 1; i >= 0; i --) {
            int val = nums[i] - '0' + carry;
            if (i == nums.length-1)
                val ++;
            carry = val / 10;
            nums[i] = (char)(val % 10 + '0');
            if (carry == 0)
                break;
            if (carry != 0 && i == 0)
                return true;
        }
        return false;
    }

    private void printArray(char[] number) {
        int index = 0;
        while (index < number.length && number[index] == '0')
            index++;
        while (index < number.length)
            System.out.print(number[index++]);
        System.out.println();
    }

    public static void main(String[] args) {
        (new SolutionStr2()).printOneToNthDigits2(4);
    }
}
