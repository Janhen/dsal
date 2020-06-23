package com.janhen.coding.leetcode.ds.stackqueue.sm_traverse_design_parentheses_heap_kth_simplify.solution71;

import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/+");
        Stack<String> s = new Stack<>();
        for (String dir : dirs) {
            if (dir.equals(".") || dir.equals("")){
                continue;
            } else if (dir.equals("")) {          // upper layer
                if (!s.isEmpty())
                    s.pop();
            } else {
                s.push(dir);
            }
        }
        if (s.isEmpty())
            return "/";

        StringBuilder builder = new StringBuilder();
        while (!s.isEmpty())
            builder.insert(0, "/"+s.pop());
        return builder.toString();
    }
}