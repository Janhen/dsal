package com.janhen.swordoffer.a_base.problem3;

public class Solution {
	public boolean duplicate(int[] nums, int length, int[] duplication) {
		if (nums == null || length == 0) {
			return false;
		}
		for (int i = 0; i < length; i++) {
			while (i != nums[i]) {
				if (nums[i] == nums[nums[i]]) {
					duplication[0] = nums[i];
					return true;
				}
				swap(nums, i, nums[i]);
			}
		}
		return false;
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}