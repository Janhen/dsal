package com.janhen.coding.swordoffer.a_base.problem67;

public class Solution {

    public int StrToInt(String str) {
        if (str.length() == 0) {
            return 0;
        }

        char[] chs = str.toCharArray();
        boolean isNegative = chs[0] == '-';
        int num = 0;
        for (int i = 0; i < chs.length; i++) {
            // skip first element sign
            if (i == 0 && (chs[i] == '-' || chs[i] == '+')) {
                continue;
            }
            if (chs[i] < '0' || chs[i] > '9') {
                return 0;
            }
            num = num * 10 + chs[i] - '0';
        }
        return isNegative ? -num : num;
    }
}
