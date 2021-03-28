package com.janhen.coding.leetcode.structures;

import java.util.List;

public class ListNode implements Cloneable {
  public int val;
  public ListNode next;

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
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

  public ListNode(List<Integer> list) {
    if (list == null || list.size() == 0)
      throw new IllegalArgumentException();

    this.val = list.get(0);
    ListNode cur = this;
    for (int i = 1; i < list.size(); i++) {
      cur.next = new ListNode(list.get(i));
      cur = cur.next;
    }
  }

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

  @Override
  public Object clone() {
    ListNode first = new ListNode(-1);
    ListNode tail = first;
    ListNode cur = this;
    while (cur != null) {
      tail.next = new ListNode(cur.val);
      tail = tail.next;
      cur = cur.next;
    }
    return first.next;
  }
}
