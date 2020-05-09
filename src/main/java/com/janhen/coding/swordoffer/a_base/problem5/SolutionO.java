package com.janhen.coding.swordoffer.a_base.problem5;

public class SolutionO {

    void ReplaceBland(char[] str, int len) {
        if (str == null || str.length == 0) return ;
        int spaceCount = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        int newLen = len + spaceCount * 2;
        for (int i = len - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[newLen - 1] = '0';
                str[newLen - 2] = '2';
                str[newLen - 3] = '%';
                newLen -= 3;
            } else {
                str[newLen - 1] = str[i];
                newLen --;
            }
        }
    }
}
