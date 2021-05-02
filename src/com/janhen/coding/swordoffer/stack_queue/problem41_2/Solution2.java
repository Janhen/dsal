package com.janhen.coding.swordoffer.stack_queue.problem41_2;

// 字符流中第一个不重复的字符
// https://www.nowcoder.com/practice/00de97733b8e4f97a3fb5c680ee10720?tpId=13&tqId=11207&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking

/*
请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g"。
当从该字符流中读出前六个字符“google" 时，第一个只出现一次的字符是 "l"。

输出描述:
如果当前字符流没有存在出现一次的字符，返回#字符。
 */

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution2 {
    private Map<Character, Integer> freqs = new LinkedHashMap<>();

    // O(1)
    public void Insert(char ch) {
        freqs.put(ch, freqs.getOrDefault(ch, 0) + 1);
    }

    // O(n)
    public char FirstAppearingOnce() {
        for (Map.Entry<Character, Integer> entry : freqs.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return '#';
    }
}
