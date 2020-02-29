package com.janhen.swordoffer.stack_queue.problem59;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {

    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (num == null)
            return ret;
        if (num.length < size || size < 1)
            return ret;

        // step1: init deque
        Deque<Integer> qmax = new LinkedList<>();     // 队首元素为最大值, 有序, 递减序
        for (int i = 0; i < size - 1; i++) {
            while (!qmax.isEmpty() && num[i] > num[qmax.getLast()])    // put current element in correct position in deque
                qmax.removeLast();
            qmax.addLast(i);
        }

        // step2: insert AND maintain deque
        for (int i = size - 1; i < num.length; i++) {
            while (!qmax.isEmpty() && num[i] > num[qmax.getLast()])
                qmax.removeLast();
            qmax.addLast(i);
            if (i - qmax.getFirst() + 1 > size)     // 索引控制队列大小, 队首元素过期, 不在 sliding window 中
                qmax.removeFirst();
            ret.add(num[qmax.getFirst()]);
        }
        return ret;
    }
}
