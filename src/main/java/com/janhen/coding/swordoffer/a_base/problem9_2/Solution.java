package main.java.janhen.swordoffer.a_base.problem9_2;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Solution {

    private Queue<Integer> data = new LinkedList<>();
    private Queue<Integer> help = new LinkedList<>();

    public void push(int x) {
        data.offer(x);
    }

    public int pop() {
        if (empty())
            throw new NoSuchElementException();
        while (data.size() > 1)
            help.offer(data.poll());
        Integer oldFront = data.poll();
        swap();
        return oldFront;
    }

    public int top() {
        if (empty())
            throw new NoSuchElementException();
        while (data.size() > 1)
            help.offer(data.poll());
        Integer front = data.poll();
        help.offer(front);
        swap();
        return front;

    }

    public boolean empty() {
        return data.isEmpty();
    }

    private void swap() {
        Queue t = data;
        data = help;
        help = t;
    }
}
