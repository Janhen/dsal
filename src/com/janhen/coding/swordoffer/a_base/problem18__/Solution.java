package com.janhen.swordoffer.a_base.problem18__;

import com.janhen.swordoffer.structures.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    // 不删除重复节点本身，保留一个即实现 distinct 。
    // 辅助空间：
    // 一般方法删除节点，借助前一个节点删除当前节点。
    // 时间：O(n)
    // 空间：O(n)
    public ListNode deleteDuplication(ListNode head) {
        if (head == null)
            return null;
        Set<Integer> map = new HashSet<>();
        ListNode first = new ListNode(-1);
        first.next = head;

        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            if (map.contains(cur.val)) {
                pre.next = cur.next;
            } else {
                map.add(cur.val);
                pre = cur;
            }
            cur = cur.next;
        }
        return first.next;
    }
}
