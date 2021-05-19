package com.janhen.coding.swordoffer.a_base.problem39;

import java.util.stream.IntStream;

public class Solution {
    public int MoreThanHalfNum_Solution(int[] array) {
        // 1. define candidate to find can ...
        int candidate = array[0];
        int count = 1;
        for (int num : array) {
            if (count == 0) {
                // change candidate
                candidate = num;
            }
            // increment candidate weight
            count = num == candidate ? count + 1 : count - 1;
        }
        // 2. judge is or not have half frequency
        count = countOfEqual(array, candidate);
        return count > array.length / 2 ? candidate : 0;
    }

    private int countOfEqual(int[] array, int val) {
        return (int) IntStream.of(array).filter(v -> v == val).count();
    }
}
