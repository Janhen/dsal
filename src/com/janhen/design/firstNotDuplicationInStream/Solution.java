package com.janhen.design.firstNotDuplicationInStream;

// 字符流中第一个不重复的字符
// https://www.nowcoder.com/practice/00de97733b8e4f97a3fb5c680ee10720?tpId=13&tqId=11207&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {

    Map<Character, Integer> freq = new HashMap<>();   // also can use one LinkedHashMap to implement

    Queue<Character> queue = new LinkedList<>();    // record origin add order AND queue head always occur one time

    public void Insert(char ch) {
        freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        queue.offer(ch);
        while (!queue.isEmpty() && freq.get(queue.peek()) > 1)   // judge head structural legitimacy
            queue.poll();    // pop tail of queue
    }

    // O(1)
    public char FirstAppearingOnce() {
        if (queue.isEmpty())
            return '#';
        return queue.peek();
    }
}
