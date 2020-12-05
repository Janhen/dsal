package com.janhen.coding.leetcode.ds.linkedlist.operate.solution725;

import com.janhen.coding.leetcode.structures.ListNode;

class Solution {
  public ListNode[] splitListToParts(ListNode root, int k) {
    // 1. make sure part length
    int len = length(root);
    ListNode[] parts = new ListNode[k];
    int size = len / k;
    int remain = len % k;
    ListNode pre = null;
    ListNode cur = root;
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
    int N = 0;
    ListNode cur = head;
    while (cur != null) {
      N++;
      cur = cur.next;
    }
    return N;
  }
}