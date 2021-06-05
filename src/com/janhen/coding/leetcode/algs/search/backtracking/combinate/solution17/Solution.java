package com.janhen.coding.leetcode.algs.search.backtracking.combinate.solution17;

import java.util.ArrayList;
import java.util.List;

class Solution {
    // 1. record num -> character
    final String[] letterMap = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.isEmpty())
            return res;
        backtracking(digits, 0, "", res);
        return res;
    }

    private void backtracking(String digits, int index, String str, List<String> res) {
        // 1. terminal condition
        if (index == digits.length()) {
            res.add(str);
            return;
        }
        // 2. get next step all possible result
        int digit = digits.charAt(index) - '0';
        String letter = letterMap[digit];
        // 3. select one possible result and continue to find
        for (char ch : letter.toCharArray()) {
            backtracking(digits, index + 1, str + ch, res);
        }
    }
}