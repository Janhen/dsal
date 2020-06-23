package com.janhen.coding.leetcode.ds.string.solution12;

class Solution {
    /*
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000
     */
    String[][] map = {
      {"I", "V", "X"},
      {"X", "L", "C"},
      {"C", "D", "M"},
      {"M"}
    };

    //  45 ms, faster than 75.31%
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        char[] chs = String.valueOf(num).toCharArray();
        for (int i = 0; i < chs.length; i ++) {
            int n = chs[i] - '0';
            int bit = chs.length - i - 1;
            String val = genRomanNum(n, bit);
            sb.append(val);
        }
        return sb.toString();
    }

    private String genRomanNum(int num, int bit) {
        if (bit == 3) {
            String res = "";
            while (num -- > 0) {   // count limit
                res += "M";
            }
            return res;
        }
        String one = map[bit][0];
        String five = map[bit][1];
        String ten = map[bit][2];
        if (num < 4) {          // [1,3]
            String res = "";
            while (num -- > 0)
                res += one;
            return res;
        }
        if (num == 4)
            return one + five;
        if (num == 5)
            return five;
        if (num < 9) {
            String res = five;
            while (num -- - 5 > 0)
                res += one;
            return res;
        }
        if (num == 9)
            return one + ten;
        throw new IllegalArgumentException();
    }
}