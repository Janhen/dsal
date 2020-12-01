package com.janhen.coding.leetcode.ds.array.sm_adv_sub_arr_seq_dp_range.solution581;

class Solution2 {
  /*
  I use the variables beg and end to keep track of minimum subarray A[beg...end]
   which must be sorted for the entire array A to be sorted.
   If end < beg < 0 at the end of the for loop, then the array is already fully sorted.

   为什么end = -2 begin = -1？因为如果array是已经sorted的话，begin和end还是初始值，确保返回的数值是0。
   总体的思路是找出拐点。从左往右遍历，如果是sorted的话，最大的val总是目前的这个，但凡出现不是目前的这个，就记录在案。相同的道理，把左边的异常也记录在案。返回len就行了
   */
  public int findUnsortedSubarray(int[] nums) {
    if (nums == null) return 0;
    if (nums.length == 0 || nums.length == 1) return 0;

    int max = Integer.MIN_VALUE;
    int end = -2;
    //iterate from beginning of array
    //find the last element which is smaller than the last seen max from
    //its left side and mark it as end
    for (int i = 0; i < nums.length; i++) {
      max = Math.max(max, nums[i]);
      if (nums[i] < max) {
        end = i;
      }
    }

    int min = Integer.MAX_VALUE;
    int begin = -1;
    //iterate from end of array
    //find the last element which is bigger than the last seen min from
    //its right side and mark it as begin
    for (int i = nums.length - 1; i >= 0; i--) {
      min = Math.min(min, nums[i]);
      if (nums[i] > min) {
        begin = i;
      }
    }

    return end - begin + 1;
  }
}