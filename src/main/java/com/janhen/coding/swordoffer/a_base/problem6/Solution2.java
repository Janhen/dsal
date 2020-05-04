package main.java.janhen.swordoffer.a_base.problem6;

import main.java.janhen.swordoffer.structures.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class Solution2 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        while (listNode != null) {
            s.add(listNode.val);
            listNode = listNode.next;
        }
        while (!s.isEmpty())
            list.add(s.pop());
        return list;
    }
}
