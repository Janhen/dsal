package main.java.janhen.swordoffer.other.problem62;

// 49ms
public class Solution2 {

    // 构造循环链表实现
    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0 || m <= 0)
            return -1;
        // step1: generate cycle list
        Node head = new Node(0);
        Node tail = head;           //   use for link
        Node node = null;
        for (int i = 1; i < n; i ++) {
            node = new Node(i);
            tail.next = node;
            tail = node;
        }
        tail.next = head;               // link to cycle

        // step2: find m node AND delete
        Node pre = null;
        while (n != 1) {
            pre = head;
            for (int i = 0; i < m-2;i ++)
                pre = pre.next;
            pre.next = pre.next.next;             // delete mth node
            head = pre.next;                    // reset head position
            n --;
        }
        return head.val;
    }

    class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }
}
