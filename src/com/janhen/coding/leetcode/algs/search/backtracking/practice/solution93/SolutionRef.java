package com.janhen.coding.leetcode.algs.search.backtracking.practice.solution93;

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

class SolutionRef {

    // 有限的分割

    // "010010"
    // ["0.10.0.10","0.100.1.0"]                    ["0.1.0.10","0.1.0.10","0.1.1.0","0.10.0.10","0.10.1.0","0.100.1.0","1.0.0.10","1.0.1.0","1.0.1.0","10.0.1.0"]
    // 12 ms, faster than 6.65%
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() > 12)
            return res;
        String ans = "";
        for (int i = 1; i <=3; i++)
            for (int j = 1; j <=3; j ++)
                for (int k = 1; k <=3; k ++)
                    for (int l = 1; l <=3; l++) {
                        if (i + j + k + l == s.length()) {
                            int a = Integer.parseInt(s.substring(0, i));            // s is all digit∈{\d}
                            int b = Integer.parseInt(s.substring(i, i+j));
                            int c = Integer.parseInt(s.substring(i+j, i+j+k));
                            int d = Integer.parseInt(s.substring(i+j+k, i+j+k+l));
                            if (a<=255 && b<=255 && c<=255 && d<=255) {              // ▲note: `0` as prefix then ignore
                                if ((ans = String.format("%s.%s.%s.%s", a,b,c,d)).length() == s.length() + 3)
                                    res.add(ans);
                            }
                        }
                    }
        return res;
    }

}