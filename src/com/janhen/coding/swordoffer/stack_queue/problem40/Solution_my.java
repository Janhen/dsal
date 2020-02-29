package com.janhen.swordoffer.stack_queue.problem40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution_my {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] arr, int k) {
        if (arr == null || arr.length == 0 || arr.length < k || k <= 0)
            return new ArrayList<>();

        findKthSmallest(arr, k);
        return new ArrayList<>(Arrays.stream(Arrays.copyOfRange(arr, 0, k)).boxed().collect(Collectors.toList()));
    }

    private void findKthSmallest(int[] arr, int k) {
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {           // lo = hi not need parititon
            int j = partition(arr, lo, hi);   // when lo == hi, not need part
            if (j == k)
                return;
            else if (j < k) {  // [0, j] is ordered, make j bigger
                lo = j + 1;
            } else {
                hi = j - 1;
            }
        }
    }

    private int partition(int[] arr, int lo, int hi) {
        int pivot = arr[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (arr[++ i] < pivot) if (i == hi) break;
            while (arr[-- j] > pivot) if (j == lo) break;
            if (i >= j)
                break;
            swap(arr, i, j);
        }
        swap(arr, j, lo);          // put pivot on correct position
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i] ;
        arr[i] = arr[j];
        arr[j] = t;
    }
}
