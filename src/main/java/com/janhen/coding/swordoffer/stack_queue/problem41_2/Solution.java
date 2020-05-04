package main.java.janhen.swordoffer.stack_queue.problem41_2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {

    Map<Character, Integer> freq = new HashMap<>();   // also can use one LinkedHashMap to implement

    Queue<Character> queue = new LinkedList<>();    // Note: record origin add order AND maintain queue head element always appear one time

    public void Insert(char ch) {
        freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        queue.offer(ch);
        while (!queue.isEmpty() && freq.get(queue.peek()) > 1)   // Note: judge head structural legitimacy
            queue.poll();    // pop tail of queue
    }

    // O(1)
    public char FirstAppearingOnce() {
        if (queue.isEmpty())
            return '#';
        return queue.peek();
    }
}
