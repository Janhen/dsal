package com.janhen.coding.swordoffer.a_base.problem22;

import com.janhen.coding.swordoffer.structures.ListNode;

public class Solution {
    // 快慢指针定位
    // - 链表为空、一个元素
    // - 倒数第 N 个
    // - 倒数第 N + x 个
    // time: O(N), space: O(1)
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || head.next == null) {
            return null;
        }
        // fast run k step
        ListNode fast = head;
        // fast = null as guard
        while (fast != null && k -- > 0) {
            fast = fast.next;
        }
        // not have enough element
        if (k > 0) return null;
        // fast, slow run together util fast -> NULL
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
//        final String s = IntStream.concat(IntStream.of(2), IntStream.of(1, 2, 3, 4, 5)).mapToObj(String::valueOf)
//          .collect(Collectors.joining(" "));
//        System.out.println(s);
        System.out.println(new Solution().FindKthToTail(new ListNode(1, 2, 3, 4, 5), 5));
        System.out.println(new Solution().FindKthToTail(new ListNode(1, 2, 3, 4, 5), 6));
    }
}
