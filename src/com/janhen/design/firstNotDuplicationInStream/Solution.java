package com.janhen.design.firstNotDuplicationInStream;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {

    Map<Character, Integer> freqs = new HashMap<>();

    Queue<Character> queue = new LinkedList<>();

    public void Insert(char ch) {
        freqs.put(ch, freqs.getOrDefault(ch, 0) + 1);
        queue.offer(ch);
        while (!queue.isEmpty() && freqs.get(queue.peek()) > 1)
            queue.poll();    // pop tail of queue
    }

    public char FirstAppearingOnce() {
        if (queue.isEmpty())
            return '#';
        return queue.peek();
    }
}
