package main.java.janhen.swordoffer.a_base.problem58_2;

public class Solution {

    // x+y   ==>> y + x
    //^(^x + ^y) = y + x
    public String LeftRotateString(String str,int n) {
        if (str.length() == 0)  return "";

        char[] chs = str.toCharArray();
        n = n % str.length();
        reverse(chs, 0,  n - 1);
        reverse(chs, n, chs.length - 1);
        reverse(chs, 0, chs.length - 1);
        return new String(chs);
    }

    private void reverse(char[] c, int i, int j) {
        while (i < j) {
            swap(c, i++, j--);
        }
    }
    private void swap(char[] c, int i, int j) {
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }
}
