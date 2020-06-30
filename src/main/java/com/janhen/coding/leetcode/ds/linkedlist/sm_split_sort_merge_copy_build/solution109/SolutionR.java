package com.janhen.coding.leetcode.ds.linkedlist.sm_split_sort_merge_copy_build.solution109;

import com.janhen.coding.leetcode.structures.ListNode;
import com.janhen.coding.leetcode.structures.TreeNode;

class SolutionR {
  // 截断两个链表递归拼接
  // 找到中间节点，作为该树的根节点
  // 左右两部分分别为两个子问题
  public TreeNode sortedListToBST(ListNode head) {
    if (head == null)
      return null;
    if (head.next == null)
      return new TreeNode(head.val);
    // 1. find previous middle node and
    // cut ⇒ two list
    ListNode preMid = findPreMidNode(head);           // not need precise odd OR even count
    ListNode mid = preMid.next;
    preMid.next = null;

    // 2. convert to half sub problem
    TreeNode root = new TreeNode(mid.val);   // head... preMid
    root.left = sortedListToBST(head);
    root.right = sortedListToBST(mid.next);   // Note: mid.next ... tail
    return root;
  }

  private ListNode findPreMidNode(ListNode head) {
    // use fast, slow pointer must from head to tail
    ListNode slow = head, fast = head;
    ListNode pre = null;
    while (fast != null && fast.next != null) {
      pre = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    return pre;
  }
}