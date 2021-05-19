package com.janhen.coding.swordoffer.a_base.problem58;

public class Solution {
    // 迭代过程中，找到
    // time: O(N), space: O(1)
    public String ReverseSentence(String str) {
        if (str.trim().equals("")) {
            return str;
        }
        char[] chs = str.toCharArray();
        int begin = 0;
        int cur = 0;
        while (cur <= chs.length) {
            // end
            if (cur == chs.length || chs[cur] == ' ') {
                reverse(chs, begin, cur - 1);
                begin = cur + 1;
                cur++;
            } else {
                cur++;
            }
        }
        reverse(chs, 0, chs.length - 1);
        return String.valueOf(chs);
    }

    private void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
    }
}
