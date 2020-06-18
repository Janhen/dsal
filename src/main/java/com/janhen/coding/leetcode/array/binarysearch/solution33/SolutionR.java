package com.janhen.coding.leetcode.array.binarysearch.solution33;

class SolutionR {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int L, int R, int aim) {
        if (L > R)
            return -1;
        int mid = L + (R - L) /2;
        if (nums[mid] == aim)     // this check current [mid]
            return mid;

        if (nums[L] < nums[mid]) { // L half is sort
            if (aim <= nums[mid] && aim >= nums[L])    // aim in L half  ⇒  search in L half
                return search(nums, L, mid - 1, aim);
            else
                return search(nums, mid + 1, R, aim);
        } else if (nums[mid] < nums[R]) {  // R half is sort
            if (aim <= nums[R] && aim >= nums[mid])
                return search(nums, mid + 1, R, aim);
            else
                return search(nums, L, mid - 1, aim);
        } else if (nums[L] == nums[mid])  { // L half is all same or loops around    [1,2,1,1]
            if (nums[mid] != nums[R]) {   // R half is not all same
                return search(nums, mid + 1, R, aim);
            } else {    // [1,1,0,1], [1,1,3,1], [1,1,1,1]
                // search in L half and R half
                int res = search(nums, L, mid - 1, aim);
                if (res == -1)
                    return search(nums, mid + 1, R, aim);
                else
                    return res;
            }
        }
        return -1;
    }
}