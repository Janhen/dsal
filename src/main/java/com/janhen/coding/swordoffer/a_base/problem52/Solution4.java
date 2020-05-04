package main.java.janhen.swordoffer.a_base.problem52;

import main.java.janhen.swordoffer.structures.ListNode;

import java.util.Stack;

public class Solution4 {

    // 借助栈实现
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Stack<ListNode> s1 = new Stack<ListNode>();
        Stack<ListNode> s2 = new Stack<ListNode>();
        while (pHead1 != null) {
            s1.push(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            s2.push(pHead2);
            pHead2 = pHead2.next;
        }
        ListNode res= null;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            if ((res = s1.pop()) != s2.pop())
                return res.next;
        }
        return res;
    }
}
