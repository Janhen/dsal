package com.janhen.coding.swordoffer.a_base.problem5;

public class Solution1 {
    // 扩展原有的 StringBuffer，对其进行更改
    // time:O(N) space:O(1)?
    public String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }

        // 1. 遍历并增加标记
        int oldLen = str.length();
        for (int i = 0; i < oldLen; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }

        // 2. 从后向前遍历，替换新建的数组元素值
        int curLen = str.length();
        for (int i = oldLen - 1, j = curLen - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                str.setCharAt(j--, '0');
                str.setCharAt(j--, '2');
                str.setCharAt(j--, '%');
            } else {
                str.setCharAt(j--, ch);
            }
        }
        return str.toString();
    }
}
