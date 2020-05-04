package main.java.janhen.swordoffer.a_base.problem58;

public class Solution {
    public String ReverseSentence(String str) {
        char[] chs = str.toCharArray();

        int begin = 0, cur = 0;
        while (cur <= chs.length) {
            if (cur == chs.length || chs[cur] == ' ') {
                reverse(chs, begin, cur - 1);
                begin = cur + 1;
                cur ++;
            } else {
                cur ++;
            }
        }
        reverse(chs, 0, chs.length - 1);
        return new String(chs);
    }

    private void reverse(char[] chs, int i, int j) {
        while (i < j)
            swap(chs, i ++, j --);
    }

    private void swap(char[] chs, int i, int j) {
        char t = chs[i];
        chs[i] = chs[j];
        chs[j] = t;
    }
}
