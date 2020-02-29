package com.janhen.swordoffer.stack_queue.problem41;

// 41 数据流中的中位数

import java.util.PriorityQueue;

public class Solution2 {

    PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
    PriorityQueue<Integer> right = new PriorityQueue<>();   // left AND right size diff not sure

    private void modifyTwoHeapsSize() {
        if (left.size() == right.size() + 2)
            right.add(left.poll());
        if (right.size() == left.size() + 2)
            left.add(right.poll());
    }

    public void Insert(Integer num) {
        if (left.isEmpty()) {
            left.add(num);
            return;
        }
        if (left.peek() >= num)     // num <= A
            left.add(num);
        else {
            if (right.isEmpty()) {
                right.add(num);
                return;
            }
            if (right.peek() > num)  // A < num < B
                left.add(num);
            else                     // num >= B
                right.add(num);
        }
        modifyTwoHeapsSize();
    }

    public Double GetMedian() {
        int leftSize = left.size();
        int rightSize = right.size();
        if (leftSize + rightSize == 0)   // empty
            return null;

        Integer leftMax = left.peek();
        Integer rightMin = right.peek();
        if (((leftSize + rightSize) % 2) == 0)
            return (double) (leftMax + rightMin) / 2;
        return leftSize > rightSize ? (double) leftMax : (double) rightMin;
    }
}
