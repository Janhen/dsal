package com.janhen.coding.swordoffer.stack_queue.problem41_2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {
    // frequency
    private Map<Character, Integer> freqs = new HashMap<>();
    // record origin add order and maintain queue head element, always appear one time
    private Queue<Character> queue = new LinkedList<>();

    public void Insert(char ch) {
        freqs.put(ch, freqs.getOrDefault(ch, 0) + 1);
        queue.offer(ch);
        // maintain queue keep frequency is one
        while (!queue.isEmpty() && freqs.get(queue.peek()) > 1) {
            queue.poll();    // pop tail of queue
        }
    }

    // O(1)
    public char FirstAppearingOnce() {
        if (queue.isEmpty()) {
            return '#';
        }
        return queue.peek();
    }
}
