package com.janhen.coding.leetcode.string.solution6;

// 6. ZigZag Conversion
//https://leetcode.com/problems/zigzag-conversion/
// medium

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
 */

import java.util.Arrays;

class Solution {

    //|     |     |
    //|    ||    ||    |
    //|   | |   | |   |
    //|  |  |  |  |  |
    //| |   | |   | |
    //|     |     |           cycle to handle
    // cycle = 2*n-2
    // i  ⇒  p=i%cycle
    //
    // index = p                p∈[0,n)
    //         cycle - p        p∈[n,cycle)
    // 26 ms, faster than 83.72%
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