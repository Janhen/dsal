package com.janhen.coding.swordoffer.stack_queue.problem59;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {

    public ArrayList<Integer> maxInWindows(int[] nums, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (size > nums.length || size < 1) {
            return res;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);    // N=size-1, record sliding
        // window max val
        int L = 0, R = 0;
        while (R < nums.length) {               //
            maxHeap.offer(nums[R++]);
            if (maxHeap.size() == size) {
                res.add(maxHeap.peek());
                maxHeap.remove(nums[L++]);    // [L] to remove, O(logN)?
            }
        }
        return res;
    }
}
