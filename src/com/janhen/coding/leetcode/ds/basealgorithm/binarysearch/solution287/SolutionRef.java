package com.janhen.coding.leetcode.ds.basealgorithm.binarysearch.solution287;

/*
 * 双指针解法，类似于有环链表中找出环的入口：
 * https://leetcode.com/problems/find-the-duplicate-number/discuss/72846/My-easy-understood-solution-with-O(n)
 * -time-and-O(1)-space-without-modifying-the-array.-With-clear-explanation.
 * O(n) time and O(1) space
 */
class SolutionRef {
    public int findDuplicate(int[] nums) {
        if (nums.length < 2)
            return -1;
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}