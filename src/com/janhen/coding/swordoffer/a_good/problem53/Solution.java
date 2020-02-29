package com.janhen.swordoffer.a_good.problem53;

// 53 在排序数组中查找数字

public class Solution {

    public int GetNumberOfK(int [] arr , int k) {
        int first = binarySearchFirst(arr,k);
        int last = binarySearchLast(arr, k);
        if (first == -1) return 0;
        return last - first + 1;
    }

    private int binarySearchFirst(int[] arr, int key) {
        int lo = 0, hi = arr.length-1;
        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            if (arr[mid] == key) {
                if (mid == 0 || arr[mid-1] != key)
                    return mid;
                else
                    hi = mid -1;
            } else if (arr[mid] > key)
                hi = mid-1;
            else
                lo = mid + 1;
        }
        return -1;
    }

    private int binarySearchLast(int[] arr, int key) {
        int lo = 0, hi = arr.length-1;
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if (arr[mid] == key) {
                if (mid == arr.length-1 || arr[mid+1] != key)
                    return mid;
                else
                    lo = mid + 1;
            } else if (arr[mid] > key) {
                hi = mid -1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        (new Solution()).GetNumberOfK(new int[]{2,3,4,5,1,2,3,1}, 3);
    }
}
