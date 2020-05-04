package main.java.janhen.swordoffer.a_base.problem58_2;


public class Solution1 {
    public String LeftRotateString(String str,int n) {
        if (str.length() == 0)
            return str;
        n = n % str.length();
        String dou = str + str;
        return dou.substring(n, n+str.length());
    }
}
