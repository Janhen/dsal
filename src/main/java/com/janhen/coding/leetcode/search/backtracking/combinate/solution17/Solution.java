package com.janhen.coding.leetcode.search.backtracking.combinate.solution17;

import java.util.ArrayList;
import java.util.List;

class Solution {
    final String[] letterMap = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.isEmpty())
            return res;
        backtracking(digits, 0, "", res);
        return res;
    }

    private void backtracking(String digits, int index, String str, List<String> res) {
        if (index == digits.length()) {
            res.add(str);
            return;
        }
        int digit = digits.charAt(index) - '0';
        String letter = letterMap[digit];
        for (int i = 0; i < letter.length(); i ++)
            backtracking(digits, index + 1, str + letter.charAt(i), res);
    }
}