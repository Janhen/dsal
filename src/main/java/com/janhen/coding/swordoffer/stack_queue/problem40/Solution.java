package main.java.janhen.swordoffer.stack_queue.problem40;

import java.util.ArrayList;

public class Solution {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] arr, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (arr == null || (arr.length) == 0 || arr.length < k)
            return res;
        findKthSmallest(arr, k - 1);
        for (int i = 0; i < k; i++)
            res.add(arr[i]);
        return res;
    }

    private void findKthSmallest(int[] arr, int k) {   // 找到 [k] 的正确元素
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            int j = partition(arr, lo, hi);
            if (j == k)
                return ;
            else if (j > k)
                hi = j - 1;
            else
                lo = j + 1;
        }
    }

    private int partition(int[] arr, int lo, int hi) {
        int pivot = arr[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (arr[++i] < pivot) if (i == hi) break;
            while (arr[--j] > pivot) if (j == lo) break;
            if (i >= j)
                break;
            swap(arr, i, j);
        }
        swap(arr, j, lo);
        return j;
    }

    private static final void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
