package main.java.janhen.swordoffer.a_base.problem6;

import main.java.janhen.swordoffer.structures.ListNode;

import java.util.ArrayList;

public class SolutionR {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null)
            return list;
        list.addAll(printListFromTailToHead(listNode.next));
        list.add(listNode.val);
        return list;
    }
}
