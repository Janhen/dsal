package com.janhen.coding.leetcode.top100.recursion_dp_backtracking.solution22;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int left, int right, int n){
        if(left == n && right == n){
            list.add(str);
            return;
        }
        if(left < n)         // have left parentheses
            backtrack(list, str+"(", left+1, right, n);
        if(right < left)     // right parentheses must less than OR equal left parentheses;     also can right != left
            backtrack(list, str+")", left, right+1, n);
    }
}