package main.java.janhen.swordoffer.other.problem20;

// 20 表示数值的字符串

public class Solution {

    // [+-]?\d*        (\.\d+)?        ([eE][+-]?\d+)?
    // 整数部分          小数部分           幂部分
    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0)
            return false;
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }
}
