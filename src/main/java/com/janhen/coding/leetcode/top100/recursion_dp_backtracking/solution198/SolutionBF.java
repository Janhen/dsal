package main.java.janhen.leetcode.top100.recursion_dp_backtracking.solution198;

class SolutionBF {
    public int rob(int[] nums) {
        return tryRob(nums, nums.length - 1);
    }

    // violence recursion: not record
    // macro semantic: 考虑 抢劫 nums[index...nums.length)
    //    gap: 2
    // 递推公式: res = max{[0]+f(2,len-1), [1]+f(3,len-1), [2]+f(4,len-1), [3]+f(5,len-1).... [len-3]+f(len-1,len-1)}
    private int tryRob(int[] nums, int index) {
        if (index < 0) return 0;
        return Math.max(tryRob(nums, index - 1), tryRob(nums, index - 2) + nums[index]);
    }
}
