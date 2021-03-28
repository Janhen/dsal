package com.janhen.coding.swordoffer.a_base.problem6;

import com.janhen.coding.swordoffer.structures.ListNode;

import java.util.ArrayList;
import java.util.Collections;

public class Solution3 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(list);
        return list;
    }
}
