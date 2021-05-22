package com.janhen.coding.swordoffer.a_base.problem6;

import com.janhen.coding.swordoffer.structures.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class Solution2 {
    // time:O(N),space:O(N)
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }
}
