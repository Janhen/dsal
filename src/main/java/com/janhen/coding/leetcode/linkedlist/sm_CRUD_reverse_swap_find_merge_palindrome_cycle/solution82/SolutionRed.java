package main.java.janhen.leetcode.linkedlist.sm_CRUD_reverse_swap_find_merge_palindrome_cycle.solution82;

// 82. Remove Duplicates from Sorted List II
//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
//Medium  661:65

/*
从已排序链表中删除所有的重复元素, 只留下不同的数组成的链表

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3
 */

import main.java.janhen.leetcode.structures.ListNode;

class SolutionRed {
    // 0 ms, faster than 100.00%
    public ListNode deleteDuplicates(ListNode head) {
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode pre = first;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                int duplicatedVal = cur.val;
                while (cur.next != null && cur.next.val == duplicatedVal) {
                    cur = cur.next;
                }
                // now cur is last duplicated node, cur.next may null
                pre.next = cur.next;
                cur = cur.next;
            }
            else {
                pre = cur;
                cur = cur.next;
            }
        }
        return first.next;
    }
}