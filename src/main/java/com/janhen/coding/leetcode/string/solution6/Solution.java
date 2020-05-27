package com.janhen.coding.leetcode.string.solution6;

import java.util.Arrays;

class Solution {

    /*
    |     |     |
    |    ||    ||    |
    |   | |   | |   |
    |  |  |  |  |  |
    | |   | |   | |
    |     |     |           cycle to handle
     cycle = 2*n-2
     i  ⇒  p=i%cycle

     index = p                p∈[0,n)
             cycle - p        p∈[n,cycle)
     26 ms, faster than 83.72%
     */
    public String convert(String s, int numRows) {
        if (s.length() < 3 || numRows == 1)
            return s;

        String[] rows = new String[numRows];
        Arrays.fill(rows, "");

        int cycle = 2 * numRows - 2;
        for (int i = 0; i < s.length(); i ++) {
            int p = i % cycle;   // `%` need notice not `0`
            if (p < numRows) {
                rows[p] += s.charAt(i);
            }
            else {
                rows[cycle - p] += s.charAt(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String val : rows) {
            sb.append(val);
        }
        return sb.toString();
    }
}