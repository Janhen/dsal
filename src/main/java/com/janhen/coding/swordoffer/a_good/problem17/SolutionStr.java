package com.janhen.coding.swordoffer.a_good.problem17;

public class SolutionStr {

    // char[] 仿全排列实现, 使用 String 保存大数
    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0)  return ;
        char[] nums = new char[n];
        print1ToMaxOfNDigits(nums, 0);
    }

    private void print1ToMaxOfNDigits(char[] number, int index) {
        if (index == number.length) {
            printNum(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[index] = (char) (i + '0');
            print1ToMaxOfNDigits(number, index + 1);
        }
    }

    private void printNum(char[] number) {
        int index = 0;
        while (index < number.length && number[index] == '0')
            index++;
        while (index < number.length)
            System.out.print(number[index++]);
        System.out.println();
    }
}
