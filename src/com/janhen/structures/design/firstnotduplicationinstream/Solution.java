package com.janhen.structures.design.firstnotduplicationinstream;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {
    private final Map<Character, Integer> freqs = new HashMap<>();
    // record original sequence
    private final Queue<Character> queue = new LinkedList<>();

    public void Insert(char ch) {
        freqs.put(ch, freqs.getOrDefault(ch, 0) + 1);
        queue.offer(ch);
        while (!queue.isEmpty() && freqs.get(queue.peek()) > 1) {
            queue.poll(); // pop head of queue and keep head freq is 1
        }
    }

    public char FirstAppearingOnce() {
        if (queue.isEmpty()) {
            return '#';
        }
        return queue.peek();
    }
}
