package com.janhen.algorithm.find.binarySearch;

public class BinarySearch2 {

    // first | last

    private int binarySearchFirst(int[] nums, int lo, int hi, int aim) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == aim) {
                if (mid == 0 || nums[mid-1] != nums[mid])  return mid;
                else hi = mid - 1;
            } else if (nums[mid] < aim) {
                lo = mid + 1;
            } else
                hi = mid - 1;
        }
        return -1;
    }

    public int binarySearchLast(int[] nums, int key, int lo, int hi) {
        if (lo > hi)
            return -1;
        int mid = (hi - lo) / 2 + lo;
        if (nums[mid] == key) {
            if ((mid != nums.length - 1 && nums[mid] != nums[mid + 1])
                    || mid == nums.length - 1) {
                return mid;
            } else {
                lo = mid + 1;
            }
        } else if (nums[mid] < key) {
            lo = mid + 1;
        } else {
            hi = mid - 1;
        }
        return binarySearchLast(nums, key, lo, hi);
    }

    // ceil | floor

    public int binarySearchCeil(int[] nums, int key, int lo, int hi) {
        if (lo > hi)
            return -1;

        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            if (nums[mid] >= key) {
                if (mid == 0 || nums[mid-1] < key) return mid;
                else hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    public int binarySearchFloor(int[] nums, int key, int lo, int hi) {
        if (lo > hi)
            return -1;
        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            if (nums[mid] <= key) {
                if (mid == nums.length-1 || nums[mid+1] > key) return mid;
                else lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }
}
