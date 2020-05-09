package com.janhen.coding.leetcode.stack_queue_heap.sm_nested_ugly_diff_polish_decode_next.solution394;

import java.util.Stack;

public class Solution {
    // todo QQQQ
    public String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<String> result = new Stack<>();
        int i = 0;
        result.push("");
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {     // count
                int start = i;
                while (s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') i++;   // first not digit
                count.push(Integer.parseInt(s.substring(start, i + 1)));
            } else if (ch == '[') {
                result.push("");
            } else if (ch == ']') {
                // generate string
                String str = result.pop();
                StringBuilder sb = new StringBuilder();
                int times = count.pop();
                for (int j = 0; j < times; j ++) {
                    sb.append(str);
                }
                result.push(result.pop() + sb.toString());
            } else {  // character
                result.push(result.pop() + ch);
            }
            i += 1;
        }
        return result.pop();
    }

}
