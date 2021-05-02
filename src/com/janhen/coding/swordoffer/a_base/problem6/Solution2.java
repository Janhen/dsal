package com.janhen.coding.swordoffer.a_base.problem6;

import com.janhen.coding.swordoffer.structures.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class Solution2 {
    // time:O(N),space:O(N)
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        while (listNode != null) {
            s.add(listNode.val);
            listNode = listNode.next;
        }
        while (!s.isEmpty()) {
            list.add(s.pop());
        }
        return list;
    }
}
