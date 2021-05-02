package com.janhen.coding.swordoffer.a_base.problem5;

public class SolutionBF {
    public String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        int len = str.length();
        int k = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(k) == ' ') {
                str.deleteCharAt(k);
                str.insert(k, "%20");
                k += 3;
            } else {
                k++;
            }
        }
        return String.valueOf(str);
    }
}
