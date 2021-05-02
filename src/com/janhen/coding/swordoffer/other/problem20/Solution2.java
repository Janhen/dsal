package com.janhen.coding.swordoffer.other.problem20;

// 20 表示数值的字符串

/**
 * 表示数值的字符串遵循模式A[.[B]][e|EC]或者.B[e|EC]，
 *
 * 其中A为数值的整数部分，B紧跟小数点为数值的小数部分，
 *
 * C紧跟着e或者E为数值的指数部分。
 *
 * 上述A和C都有可能以 + 或者 - 开头的09的数位串，B也是0~9的数位串，但前面不能有正负号。
 */
public class Solution2 {

    private int index = 0;

    public boolean isNumeric(char[] str) {
        if (str == null || str.length < 1) {
            return false;
        }

        // 判断是否存在整数
        boolean flag = scanInteger(str);

        // 小数部分
        if (index < str.length && str[index] == '.') {
            index++;
            // 小数部分可以有整数或者没有整数
            // 所以使用 ||
            flag = scanUnsignedInteger(str) || flag;
        }

        if (index < str.length && (str[index] == 'e' || str[index] == 'E')) {
            index++;
            // e或E前面必须有数字
            // e或者E后面必须有整数
            // 所以使用 &&
            flag = scanInteger(str) && flag;
        }

        return flag && index == str.length;

    }

    private boolean scanInteger(char[] str) {
        // 去除符号
        while (index < str.length && (str[index] == '+' || str[index] == '-')) {
            index++;
        }

        return scanUnsignedInteger(str);
    }

    private boolean scanUnsignedInteger(char[] str) {
        int start = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9') {
            index++;
        }
        // 判断是否存在整数
        return index > start;
    }
}
