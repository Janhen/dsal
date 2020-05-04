package main.java.janhen.leetcode.BT.sm_two_sub_sequence_convert_path.solution108;

import main.java.janhen.leetcode.structures.TreeNode;

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return buildBSTFromArray(nums, 0, nums.length - 1);
    }

    private TreeNode buildBSTFromArray(int[] nums, int l, int r) {
        if (l > r) return null;
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBSTFromArray(nums, l, mid-1);
        root.right = buildBSTFromArray(nums, mid + 1, r);
        return root;
    }
}