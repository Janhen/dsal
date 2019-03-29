package com.janhen.algorithm.find.binarySearch;

/**
 * 其他分割实现
 */
public class BinarySearchZ {
    public int binarySearchFirstR(int[] nums, int key, int lo, int hi) {
        if (lo > hi)
            return -1;
        int mid = (hi - lo) / 2 + lo;
        if (nums[mid] == key) {
            if ((mid != 0 && nums[mid] != nums[mid - 1]) || mid == 0)
                return mid;
            else
                hi = mid - 1;
        }
        else if (nums[mid] < key)
            lo = mid + 1;
        else
            hi = mid - 1;
        return binarySearchFirstR(nums, key, lo, hi);
    }

    public int binarySearchFirstNR2(int[] nums, int key) {
        int L = 0, R = nums.length - 1;
        while (L < R) {  // not `<=` for duplicate
            int mid = L+(R - L) / 2 ;
            if (nums[mid] >= key) {
                R = mid;
            } else {
                L = mid + 1;
            }
        }
        return L;
    }


    //  ---
    // [] (nums,-1,-1,aim) ArrayIndexOutOfBoundsException    [L,R]  ⇒  [L, R)
    private int binarySearchLastNR(int[] nums, int L, int R, int aim) {
        if (L < 0)
            return -1;
        while (L <= R) {
            int mid = L + (R - L) / 2;
            if (nums[mid] == aim) {
                if (mid == nums.length-1 || nums[mid] != nums[mid + 1])
                    return mid;
                else
                    L = mid + 1;
            } else if (nums[mid] < aim)
                L = mid + + 1;
            else
                R = mid - 1;
        }
        return - 1;
    }

    // --

    public int binarySearch2(int[] arr, int k) {
        int a = 0;
        int b = arr.length;
        // Loop invariant: [a, b) is a valid range. (a <= b)
        // k may only be within range [a, b).
        while (a < b) {
            int m = a + (b - a) / 2;
            if (k < arr[m]) {
                b = m;
            } else if (k > arr[m]) {
                a = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    public int binarySearchR(int[] arr, int key) {
        return binarySearchR(arr, key, 0, arr.length - 1);
    }

    public int binarySearchR(int[] arr, int key, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }

        int mid = (hi - lo) / 2 + lo;
        if (arr[mid] > key)
            return binarySearchR(arr, key, lo, mid - 1);
        else if (arr[mid] < key)
            return binarySearchR(arr, key, lo + 1, hi);
        else
            return mid;
    }
}
