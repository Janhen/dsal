package com.janhen.coding.swordoffer.a_base.problem58;

public class Solution2 {
    // 迭代过程中，找到 ` `
    public String ReverseSentence(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        char[] chs = str.toCharArray();
        // 1. reversed all string
        reverse(chs, 0, chs.length - 1);
        // 2. reversed every word
        int startWordIdx = -1;
        int endWordIdx = -1;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == ' ') {
                startWordIdx = endWordIdx;
                endWordIdx = i;
                reverse(chs, startWordIdx + 1, endWordIdx - 1);
            }
            if (i == chs.length - 1) {
                startWordIdx = endWordIdx;
                endWordIdx = i - 1;
                reverse(chs, startWordIdx + 1, endWordIdx - 1);
            }
        }

        return new String(chs);
    }

    private void reverse(char[] chs, int i, int j) {
        while (i < j) {
            swap(chs, i++, j--);
        }
    }

    private void swap(char[] chs, int i, int j) {
        char t = chs[i];
        chs[i] = chs[j];
        chs[j] = t;
    }

}
