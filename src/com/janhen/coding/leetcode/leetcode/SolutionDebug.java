package com.janhen.leetcode.leetcode;

import com.janhen.leetcode.structures.ListNode;

public class SolutionDebug {

    public ListNode removeElements(ListNode head, int val, int depth) {
        String depthString = generateDepthString(depth);

        System.out.print(depthString);
        System.out.println("Call : remove " + val + " in " + head);
        if (head == null) {
            System.out.print(depthString);
            System.out.println("Return : " + head);
            return null;
        }


        ListNode res = removeElements(head.next, val, depth + 1);
        System.out.print(depthString);
        System.out.println("After remove : " + val + ": " + res);


        ListNode ret;
        if (head.val == val) {
            ret = res;
        } else {
            head.next = res;
            ret = head;
        }
        System.out.print(depthString);
        System.out.println("Return : " + ret);
        return ret;
    }

    private String generateDepthString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i ++)
            sb.append("--");
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new SolutionDebug()).removeElements(head, 6, 0);
        System.out.println(res);
    }
}
