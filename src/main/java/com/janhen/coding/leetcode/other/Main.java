package com.janhen.coding.leetcode.other;

import com.janhen.coding.leetcode.structures.TreeNode;
import org.junit.Test;

public class Main {

    int[][] consts = {
            {2, 3, 4, 7, 6, 1},   // 0
            {11, 22, 33, 44, 55}, // 1
            {1, 2, 2, 3, 4, 5, 5, 6},  // 2
            {2, 2, 2, 2, 2, 2},   // 3
            {},             // 4
            null,           // 5
            {-23, -3, 1, 44, 55}, // 1
            {2}
    };

    @Test
    public void testSum() {
        System.out.println(sum(consts[2]));
        System.out.println(sum(consts[3]));
    }

    public long sum(int[] nums) {
        if (nums == null)
            return -1;

        return sum(nums, 0);
    }

    // 计算 arr[1...n) 范围里的数字和
    private long sum(int[] nums, int lo) {

        if (lo == nums.length)
            return 0;

        return nums[lo] + sum(nums, lo + 1);
    }



    @Test
    public void testV() {
        System.out.println(1 / 2);
        System.out.println(2 / 2);
    }

    public static void main(String[] args) {

        TreeNode head;
        head = new TreeNode(100);
        head.left = new TreeNode(21);
        head.left.left = new TreeNode(37);
        head.right = new TreeNode(-42);
        head.right.left = new TreeNode(0);
        head.right.right = new TreeNode(666);
        head.printTree();

        Integer[] nums = {5,7,4,9,10,7,6};
        TreeNode root = new TreeNode(nums);
        root.printTree();
        root.printLevel();
    }
}
