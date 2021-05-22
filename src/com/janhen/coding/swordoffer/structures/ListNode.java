package com.janhen.coding.swordoffer.structures;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

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

    public ListNode(List<Integer> nums) {
        this(nums.stream().mapToInt(Integer::valueOf).toArray());
    }

    public ListNode(int val, int ... other) {
        this(IntStream.concat(IntStream.of(val), IntStream.of(other)).toArray());
    }

    @Override
    public String toString() {
        ListNode cur = this;
        StringBuilder sb = new StringBuilder();

        while (cur != null) {
            sb.append(cur.next == null ? cur.val : cur.val + "->");
            cur = cur.next;
        }
        sb.append("->NULL");
        return sb.toString();
    }
}