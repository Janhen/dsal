package com.janhen.coding.leetcode.search.backtracking.practice.solution131;

import java.util.ArrayList;
import java.util.List;

class Solution1 {

    /* 不截取子串进行判断，借助数组索引判断 *
     */
    //  5 ms, faster than 63.99%
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0)
            return  res;
        backtracking(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtracking(String s, int start, List<String> list, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < s.length(); i ++) {
            if (isPalindrome(s, start, i)) {
                list.add(s.substring(start, i + 1));
                backtracking(s, i + 1, list, res);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str, int l, int r) {
        if (l == r)
            return true;
        while (l < r) {
            if (str.charAt(l++) != str.charAt(r --))
                return false;
        }
        return true;
    }
}