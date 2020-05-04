package main.java.janhen.swordoffer.a_base.problem18__;

import main.java.janhen.swordoffer.structures.ListNode;

public class Solution1 {

    // 删除未排序链表中的结点
    // 不适用缓冲区：遍历
    //删除当前节点的下一个节点，while ()  以及指针都为.next判断及修改
    //- current 迭代访问整个链表；
    //- runner 用于检查后续的节点是否重复；
    //
    //时间：O(n^2)
    //空间：O(1)
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null)
            return null;
        ListNode cur = pHead;
        while (cur != null) {
            ListNode runner = cur;
            while (runner.next != null) {
                if (runner.next.val == cur.val) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            cur = cur.next;
        }
        return pHead;
    }
}
