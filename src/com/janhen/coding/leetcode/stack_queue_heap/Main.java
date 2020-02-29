package com.janhen.leetcode.stack_queue_heap;

import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {

        int M = 100, N = 50;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return a % 10 - b % 10;
        });

        for (int i = 0; i < 20; i ++) {
            int num = (int)  (Math.random() * (M - N + 1) + N);
            pq.offer(num);
            System.out.println("insert " + num + " in priority queue.");
        }

        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
        System.out.println();

    }
}
