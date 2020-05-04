package main.java.janhen.swordoffer.a_base.problem39;

import java.util.stream.IntStream;

public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        int candidate = array[0];
        int count = 1;
        for (int num : array) {
            if (count == 0)
                candidate = num;
            count = num == candidate ? count + 1 : count - 1;
        }
        count = countOfEqual(array, candidate);
        return count > array.length / 2 ? candidate : 0;
    }

    private int countOfEqual(int[] array, int val) {
        return (int) IntStream.of(array).filter(v -> v == val).count();
    }
}
