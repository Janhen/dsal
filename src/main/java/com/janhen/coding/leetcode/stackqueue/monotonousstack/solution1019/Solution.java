package com.janhen.coding.leetcode.stackqueue.monotonousstack.solution1019;

import com.janhen.coding.leetcode.structures.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {

  // O(N)time O(N)space
  public int[] nextLargerNodes(ListNode head) {
    ArrayList<Integer> record = new ArrayList<>();
    while (head != null) {
      record.add(head.val);
      head = head.next;
    }
    int[] res = new int[record.size()];
    LinkedList<Integer> stack = new LinkedList<>();
    for (int i = 0; i < res.length; ++i) {
      while (!stack.isEmpty() && record.get(stack.peek()) < record.get(i)) {
        res[stack.pop()] = record.get(i);
      }
      stack.push(i);
    }
    return res;
  }
}
