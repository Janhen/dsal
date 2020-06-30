package com.janhen.coding.leetcode.ds.linkedlist.sm_split_sort_merge_copy_build.solution725;

import com.janhen.coding.leetcode.structures.ListNode;

class Solution {
  // every list node count like order fill k bucket
  // need to keep original order
  public ListNode[] splitListToParts(ListNode root, int k) {
    // 1. make sure part length
    int len = length(root);
    ListNode[] parts = new ListNode[k];
    int size = len / k;
    int remain = len % k;
    ListNode pre = null, cur = root;
    // 2. two condition to iteration and link list node
    for (int i = 0; i < k && cur != null; i++) {         // two iteration pointer
      parts[i] = cur;
      int curSize = size + (remain-- > 0 ? 1 : 0);
      for (int j = 0; j < curSize; j++) {
        pre = cur;
        cur = cur.next;
      }
      // 3. split one list node to assigned list node
      pre.next = null;
    }
    return parts;
  }

  private int length(ListNode head) {
    int len = 0;
    ListNode cur = head;
    while (cur != null) {
      len++;
      cur = cur.next;
    }
    return len;
  }
}