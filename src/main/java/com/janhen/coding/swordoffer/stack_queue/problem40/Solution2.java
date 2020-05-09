package com.janhen.coding.swordoffer.stack_queue.problem40;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution2 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] arr, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (arr == null || arr.length == 0 || arr.length < k || k <= 0)
            return res;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) ->  o2 - o1);
        for (int i = 0; i < arr.length; i ++) {
            maxHeap.add(arr[i]);
            if (maxHeap.size() == k)
                maxHeap.poll();
        }
        return new ArrayList<>(maxHeap);
    }
}
