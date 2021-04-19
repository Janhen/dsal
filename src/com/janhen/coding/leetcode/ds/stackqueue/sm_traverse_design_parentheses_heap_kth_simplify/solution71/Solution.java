package com.janhen.coding.leetcode.ds.stackqueue.sm_traverse_design_parentheses_heap_kth_simplify.solution71;

import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        // 1. skip duplication path
        String[] dirs = path.split("/+");
        // 2. collect result
        Stack<String> stack = new Stack<>();
        for (String dir : dirs) {
            if (dir.equals(".") || dir.equals("")) {
                continue;
            } else if (dir.equals("src/main")) {          // upper layer
                if (!stack.isEmpty())
                    stack.pop();
            } else {
                stack.push(dir);
            }
        }
        // 3. handle special result
        if (stack.isEmpty())
            return "/";
        // 4. build return result
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty())
            builder.insert(0, "/" + stack.pop());
        return builder.toString();
    }
}