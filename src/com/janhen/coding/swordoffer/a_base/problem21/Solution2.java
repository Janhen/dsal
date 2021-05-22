package com.janhen.coding.swordoffer.a_base.problem21;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution2 {

    // 类似于冒泡, 算法复杂度高
    // time: O(N^2), space: O(1)
    public void reOrderArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            // from end to front iterate
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] % 2 == 1 && array[j - 1] % 2 == 0) {
                    swap(array, j, j - 1);
                }
            }
            System.out.println(Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        new Solution2().reOrderArray(new int[]{4,2,1,7,6});
    }
}
