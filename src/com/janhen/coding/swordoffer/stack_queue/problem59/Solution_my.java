package com.janhen.swordoffer.stack_queue.problem59;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution_my {
    public ArrayList<Integer> maxInWindows(int [] nums, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (nums == null)
            return res;
        if (nums.length < size || size < 1)
            return res;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);  // record array element value
        int L = 0, R = 0;    // mock sliding window
        while (R < nums.length) {           // the sliding window is fixed, not need L < nums.length, R-L is a const value
            maxHeap.offer(nums[R]);
            R ++;                         // extend sliding window
            if (maxHeap.size() == size) {
                res.add(maxHeap.peek());
                maxHeap.remove(nums[L]);   // narrow sliding window
                L ++;
            }
        }
        return res;
    }
}
