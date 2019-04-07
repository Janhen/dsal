package com.janhen.algorithm.find.binarySearch;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return -1;
    }

    public static int binarySearch2(int[] arr, int k) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (k < arr[m]) {
                r = m;
            } else if (k > arr[m]) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }
}
