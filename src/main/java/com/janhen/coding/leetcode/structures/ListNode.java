package com.janhen.coding.leetcode.structures;

import java.util.List;

public class ListNode implements Cloneable {

    public int      val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new IllegalArgumentException();

        this.val = nums[0];
        ListNode cur = this;
        for (int i = 1; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
    }

    public ListNode(List<Integer> list) {
        if (list == null || list.size() == 0)
            throw new IllegalArgumentException();

        this.val = list.get(0);
        ListNode cur = this;
        for (int i = 1; i < list.size(); i++) {
            cur.next = new ListNode(list.get(i));
            cur = cur.next;
        }
    }

    public String toString() {
        ListNode cur = this;
        StringBuilder sb = new StringBuilder();

        while (cur != null) {
            sb.append(cur.next == null ? cur.val : cur.val + "->");
            cur = cur.next;
        }
        sb.append("->NULL");
        return sb.toString();
    }

    @Override
    public Object clone() {
        ListNode first = new ListNode(-1);
        ListNode tail = first;
        ListNode cur = this;
        while (cur != null) {
            tail.next = new ListNode(cur.val);
            tail = tail.next;
            cur = cur.next;
        }
        return first.next;
    }

    /* -------------------------- QUERY --------------------------- */

    public static ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0)
            return null;
        ListNode fast = head;
        while (fast != null && k-- > 0)
            fast = fast.next;
        if (k > 0)               // fast == null OR k ==0,    k invalid
            return null;

        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;             // 新赋值, 后比较
        }
        return false;
    }

    public static int length(ListNode head) {
        ListNode cur = head;
        int cnt = 0;
        while (cur != null) {
            cnt ++;
            cur = cur.next;
        }
        return cnt;
    }

    public static int lengthOfLoop(ListNode head) {
        if (head == null)
            return 0;
        int loopSize = 1;
        ListNode cur = head;
        cur = cur.next;
        while (cur != head) {
            loopSize ++;
            cur = cur.next;
        }
        return loopSize;
    }

    public static ListNode findNth(ListNode head, int k) {
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode cur = first;
        while (k -- > 0) {
            cur = cur.next;
        }
        return first.next;
    }

    public static boolean isEqual(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == null && l2 == null;
    }

    private ListNode preMid(ListNode head) {
        ListNode fast = head, slow = head, pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return pre;
    }
    // todo 中间节点

    /* ------------------------------- MODIFY ---------------------- */

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode fast = head;
        while (n -- > 0)
            fast = fast.next;
        ListNode pre = first;
        while (fast != null) {
            pre = pre.next;
            fast = fast.next;
        }
        pre.next = pre.next.next;
        return first.next;
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode pre = first;
        while (pre.next != null) {
            if (pre.next.val == val) {
                ListNode cur = pre.next;
                pre.next = cur.next;
                cur.next = null;   // help to gc
            } else {
                pre = pre.next;
            }
        }
        return first.next;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 反转从 head 开始的 n 个节点
     * 1->2->3->4->5->6->7->8
     * head 4, n = 3
     * 6->5->4->7->8
     *        ^
     *        point to original
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode reverseCount(ListNode head, int n) {
        ListNode reversedTail = head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        for (int i = 0; i <= n; i ++) {           // must <=n, because return is pre
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        reversedTail.next = next;
        return pre;
    }

    // 修改相关


    // todo 反转链表

    // todo 删除指定元素

    /* ------------------------------ TWO LISTNODE -------------------- */

//    public static boolean hasIntersectionNode(ListNode list1, ListNode list2) {
//        // 把第一个链表的结尾连接到第二个链表的开头，看第二个链表是否存在环；
//        // OR 查看最后一个节点是否相同
//        while (list1.next != null || list2.next != null) {
//            list1 = list1.next != null ? list1.next : list1;
//            list2 = list2.next != null ? list2.next : list2;
//        }
//        return list1 == list2;
//    }

    /**
     * 获取两个链表的交点
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode getIntersectionNode(ListNode list1, ListNode list2) {
        ListNode cur1 = list1, cur2 = list2;
        while (cur1 != cur2) {
            cur1 = cur1 != null ? cur1.next : list2;
            cur2 = cur2 != null ? cur2.next : list1;
        }
        return cur1;
    }

    /**
     * 归并两个有序的链表
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 交叉合并两条链表, 不等长保留多余的节点
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeCross(ListNode l1, ListNode l2) {
        ListNode newHead = l1;
        while (l1 != null && l2 != null) {
            ListNode n1 = l1.next, n2 = l2.next;
            l1.next = l2;
            if (n1 == null) break;
            l2.next = n1;
            if (n2 == null) break;
            l1 = n1;
            l2 = n2;
        }
        return newHead;
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;    // 保存用于最后直接链接
        while (odd.next != null && even.next != null) {          // even is fast than odd one step ⇔ odd.next != null && even.next != null
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
