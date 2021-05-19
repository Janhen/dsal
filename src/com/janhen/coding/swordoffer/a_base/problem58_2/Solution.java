package com.janhen.coding.swordoffer.a_base.problem58_2;

public class Solution {
    // 先构造 xyxy, 之后从 xyxy 中截取,  [n, n+str.length)
    public String LeftRotateString(String str, int n) {
        if (str.length() == 0) {
            return str;
        }
        n = n % str.length();
        String dou = str + str;
        return dou.substring(n, n + str.length());
    }
}
