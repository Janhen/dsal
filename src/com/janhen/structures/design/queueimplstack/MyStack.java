package com.janhen.structures.design.queueimplstack;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

class MyStack {
    private Queue<Integer> data = new LinkedList<>();
    private Queue<Integer> help = new LinkedList<>();

    public void push(int x) {
        data.offer(x);
    }

    public int pop() {
        if (empty())
            throw new NoSuchElementException();
        // 逆序, 流一个将要被剔除的元素
        while (data.size() > 1)
            help.offer(data.poll());
        int oldTop = data.poll();
        // 从 data
        swap();
        return oldTop;
    }

    public int top() {
        if (empty())
            throw new NoSuchElementException();
        // 逆序
        while (data.size() > 1)
            help.offer(data.poll());
        int top = data.poll();
        // 放回去 。。。
        help.offer(top);
        // 再交换
        swap();
        return top;
    }

    public boolean empty() {
        return data.isEmpty();
    }

    private void swap() {
        Queue<Integer> tmp = data;
        data = help;
        help = tmp;
    }
}
