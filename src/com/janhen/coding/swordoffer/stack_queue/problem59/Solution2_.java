package com.janhen.swordoffer.stack_queue.problem59;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

// 15ms
public class Solution2_ {

    // 〈单调双向队列>
    public ArrayList<Integer> maxInWindows(int [] nums, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (nums == null)
            return ret;
        if (nums.length < size || size < 1)
            return ret;

        Deque<Integer> qmax = new LinkedList<>();     // Front xx->xx->xx->xx Tail, Front is max, from front to tail is ↓, monotonous AND no equal
        int R = 0;
        while (R < nums.length) {
            while (!qmax.isEmpty() && nums[qmax.peekLast()] <= nums[R])
                qmax.pollLast();                         // eliminate from tail
            qmax.offerLast(R);   // [R] in window

            if (qmax.peekFirst() == R - size)   // [L]=[R-size] is need to delete if last ...; now window is [L, R]
                qmax.pollFirst();
            if (R >= size - 1)
                ret.add(nums[qmax.peekFirst()]);
            R ++;
        }
        return ret;
    }
}
