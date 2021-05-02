package com.janhen.coding.swordoffer.a_base.problem5;

public class Solution2 {
    // StringBuilder 逐个拼接
    // time:O(N) space:O(N)
    public String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return String.valueOf(sb);
    }
}
