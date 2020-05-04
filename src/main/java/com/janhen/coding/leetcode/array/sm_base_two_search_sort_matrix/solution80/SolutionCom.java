package main.java.janhen.leetcode.array.sm_base_two_search_sort_matrix.solution80;

//80. Remove Duplicates from Sorted Array II
//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/

// 限制数组中元素出现最多 times 次, 其他删除
class SolutionCom {
    public int removeDuplicates(int[] nums) {
        return removeDuplicates(nums, 2);
        // return removeDuplicates2(nums, 2);
    }

    public int removeDuplicates(int[] nums, int times) {
        if (nums.length <= 2)
            return nums.length;
        int k = 1;
        int cnt = 1;
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] != nums[i - 1]) {  // new element that not duplicate
                cnt = 1;
                nums[k ++] = nums[i];
            } else {
                if (cnt < times)
                    nums[k ++] = nums[i];
                cnt ++;
            }
        }
        return k;
    }

    public int removeDuplicates2(int[] nums, int times) {
        if (nums.length <= 2)
            return nums.length;
        int k = 0;
        for (int num : nums)
            if (k < times || num > nums[k - times])
                nums[k ++] = num;
        return k;
    }
}