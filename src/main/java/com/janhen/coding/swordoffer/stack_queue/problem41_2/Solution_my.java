package main.java.janhen.swordoffer.stack_queue.problem41_2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_my {
    int[]            freqs = new int[256];      // record occur frequency AND include all already in stream
    Queue<Character> queue = new LinkedList<>();    // to find first, maintain first element is occur one time

    public void Insert(char ch) {
        freqs[ch] ++;
        queue.offer(ch);
        while (!queue.isEmpty() && freqs[queue.peek()] != 1) {    // judge head of queue
            queue.poll(); // pop head of queue element
        }
    }

    public char FirstAppearingOnce() {
        if (queue.isEmpty()) {
            return '#';
        }
        return queue.peek();
    }
}
