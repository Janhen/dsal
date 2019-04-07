package com.janhen.algorithm.find.binarySearch;

import java.util.Arrays;

public class BinarySearch2 {

    // first | last

    private int binarySearchFirst(int[] nums, int lo, int hi, int key) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == key) {
                if (mid == 0 || nums[mid-1] != nums[mid])  return mid;
                else hi = mid - 1;
            } else if (nums[mid] < key) {
                lo = mid + 1;
            } else
                hi = mid - 1;
        }
        return -1;
    }

    public int binarySearchLast(int[] nums, int lo, int hi, int key) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == key) {
                if (mid == nums.length - 1 || nums[mid] != nums[mid + 1]) return mid;
                else lo = mid + 1;
            } else if (nums[mid] < key) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    // floor | ceil

    public int binarySearchFloor(int[] nums, int lo, int hi, int key) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] <= key) {
                if (mid == nums.length-1 || nums[mid+1] > key) return mid;
                else lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public int binarySearchCeil(int[] nums, int lo, int hi, int key) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] >= key) {
                if (mid == 0 || nums[mid-1] < key) return mid;
                else hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    // offset

    public int binarySearchOffset(int[] nums, int lo, int hi, int key, int offset) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int realMid = (mid + offset) % nums.length;
            if (nums[realMid] == key) {
                return mid;
            } else if (nums[mid] < key) {
                lo = mid + 1;
            } else
                hi = mid - 1;
        }
        return -1;
    }

    public int binarySearchOffset2(int[] nums, int key, int offset) {
        int firstIndex = offset;
        if (nums[nums.length-1] >= key) {
            int index = Arrays.binarySearch(nums, firstIndex, nums.length, key);
            return index >= 0 ? index : -1;
        } else {
            int index = Arrays.binarySearch(nums, 0, firstIndex, key);
            return index >= 0 ? index : -1;
        }
    }
}
