package com.janhen.coding.swordoffer.a_base.problem58;

public class Solution1 {
    //
    public String ReverseSentence(String str) {
        if (str.trim().equals("")) {
            return str;
        }
        // 1. split to words
        String[] words = str.split(" ");
        // 2.
        StringBuffer sb = new StringBuffer();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
