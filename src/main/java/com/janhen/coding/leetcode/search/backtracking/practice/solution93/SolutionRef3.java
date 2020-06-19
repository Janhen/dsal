package com.janhen.coding.leetcode.search.backtracking.practice.solution93;

// 93. Restore IP Addresses
// https://leetcode.com/problems/restore-ip-addresses/
// medium

/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

Example:

Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]
 */

import java.util.ArrayList;
import java.util.List;

class SolutionRef3 {

    // 有限的分割

    // only need three division
    // use variable parameter and format function
    //  12 ms, faster than 6.65%
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() > 12)
            return res;
        int len = s.length();
        for (int i = 1; i < len - 2 && i < 4; i++)                  // [I] = [0,i),  i is end index
            for (int j = i+1; j < len - 1 && j < i+4; j ++)         // [II]=[i,j),   j is end index
                for (int k = j+1; k < len && k<j+4; k ++) {
                    String s1 = s.substring(0, i), s2 = s.substring(i, j), s3 = s.substring(j, k), s4 = s.substring(k, len);
                    if (isValid(s1, s2, s3, s4)) {
                        res.add(String.format("%s.%s.%s.%s", s1,s2,s3,s4));
                    }
                }
        return res;
    }

    private boolean isValid(String ... strs) {
        for (String str: strs) {
            if (str.length() > 3 || str.length() == 0 ||
                    (str.length() >=2 && str.charAt(0)=='0') || Integer.parseInt(str) > 255)
                return false;
        }
        return true;
    }
}