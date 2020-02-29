package com.janhen.swordoffer.a_base.problem5;

public class Solution {
    public String replaceSpace(StringBuffer str) {
        if (str == null)
            return null;
        int orgIndex = str.length() - 1;
        for (int i = 0; i < orgIndex + 1; i++)
            if (str.charAt(i) == ' ')
                str.append("  ");
        int repIndex = str.length() - 1;
        for (int i = orgIndex, j = repIndex; i >= 0; i--) {
            char c = str.charAt(i);
            if (c == ' ') {
                str.setCharAt(j--, '0');
                str.setCharAt(j--, '2');
                str.setCharAt(j--, '%');
            } else {
                str.setCharAt(j--, c);
            }
        }
        return str.toString();
    }
}
