package com.janhen.coding.swordoffer.stack_queue.problem41_2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {
    private Map<Character, Integer> freq = new HashMap<>();
    // record origin add order and maintain queue head element, always appear one time
    private Queue<Character> queue = new LinkedList<>();

    public void Insert(char ch) {
        freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        queue.offer(ch);
        while (!queue.isEmpty() && freq.get(queue.peek()) > 1) {
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
