package com.janhen.coding.leetcode.string.solution67;

// 67. Add Binary
//https://leetcode.com/problems/add-binary/
// easy

/*
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 */

class Solution {

    // note: char not int, need to cast to int, then compute
    //  2 ms, faster than 97.05%
    public String addBinary(String A, String B) {
        int i = A.length() - 1, j = B.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int val;
            if (i < 0)
                val = (B.charAt(j --) - '0') + carry;
            else if (j < 0)
                val = (A.charAt(i --) - '0') + carry;
            else {
                val = (A.charAt(i --) - '0') + (B.charAt(j --) - '0') + carry;       // this is `char` !!!!!! not int
            }
            if (val > 1) {
                carry = 1;
                sb.append(val % 2);
            }
            else {
                carry = 0;   // reset carry
                sb.append(val);
            }
        }
        if (carry == 1)
            sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = (new Solution()).addBinary("1010", "1011");
    }
}