package com.janhen.coding.swordoffer.structures;

public class ListNode {
    public int      val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new IllegalArgumentException();

        this.val = nums[0];
        ListNode cur = this;
        for (int i = 1; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
    }
}