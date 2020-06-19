package com.janhen.coding.leetcode.other.top100.recursion_dp_backtracking.solution22;

import java.util.ArrayList;
import java.util.List;

class SolutionRef {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, new StringBuilder(), 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, StringBuilder sb, int open, int close, int max){
        if(sb.length() == max*2){
            list.add(sb.toString());
            return;
        }

        if(open < max){
            backtrack(list, sb.append("("), open+1, close, max);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close < open){
            backtrack(list, sb.append(")"), open, close+1, max);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        (new SolutionRef()).generateParenthesis(3);
    }
}