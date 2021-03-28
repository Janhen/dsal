package com.janhen.coding.swordoffer.recursiont_dp.problem49;

public class SolutionVB {

    // 从1开始找丑数，记录为丑数的
    public int GetUglyNumber_Solution1(int index) {
        int cnt = 0;
        int num = 0;
        while (cnt < index) {
            num ++;
            if (isUgly(num))
                cnt ++;
        }
        return num;
    }

    boolean isUgly(int num) {
        while (num % 2 == 0)
            num /= 2;        // 削减因子
        while (num %3 == 0)
            num /= 3;
        while (num %5 == 0)
            num /= 5;
        return num == 1 ? true : false;
    }
}
