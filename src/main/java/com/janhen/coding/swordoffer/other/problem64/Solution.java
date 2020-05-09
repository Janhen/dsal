package com.janhen.coding.swordoffer.other.problem64;

// 64 求1+2+...+n

/*
求1+2+3+...+n，要求
不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */

public class Solution {

    public int Sum_Solution(int n) {
        int sum = n;
        boolean b = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }
}
