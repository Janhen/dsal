package main.java.janhen.leetcode.structures.test;

import main.java.janhen.leetcode.structures.ListNode;
import org.junit.Test;

public class Main {

    @Test
    public void testMergeCross() {
        ListNode l1 = new ListNode(new int[]{11, 12, 13, 14, 15, 16});
        ListNode l2 = new ListNode(new int[]{1, 2, 3, 4});
        ListNode _l1 = (ListNode) l1.clone();
        ListNode _l2 = (ListNode) l2.clone();
        System.out.println(ListNode.mergeCross(l1, l2));
        System.out.println(ListNode.mergeCross(_l2, _l1));
    }
}
