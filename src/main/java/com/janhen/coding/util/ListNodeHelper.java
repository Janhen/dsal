package com.janhen.coding.util;

import com.janhen.coding.leetcode.structures.ListNode;

import java.util.Stack;

public class ListNodeHelper {

  /**
   * 两个链表是否相等
   */
  public static boolean isEqual(ListNode l1, ListNode l2) {
    while (l1 != null && l2 != null) {
      if (l1.val != l2.val) {
        return false;
      }
      l1 = l1.next;
      l2 = l2.next;
    }
    return l1 == null && l2 == null;
  }

  public static boolean hasCycle(ListNode head) {
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }

  /**
   * 是否是回文链表
   */
  public boolean isPalindrome(ListNode head) {
    // store left half nodes
    Stack<Integer> stack = new Stack<>();
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
      stack.push(slow.val);
      slow = slow.next;
      fast = fast.next.next;
    }

    // handle odd count condition, now Count([slow, tail]) = N/2+1
    if (fast != null)
      slow = slow.next;

    // use slow to iterate right half nodes
    while (slow != null) {    // also can !s.isEmpty();   slow from left to right, stack from right to left;
      if (stack.pop() != slow.val) {
        return false;
      }
      slow = slow.next;
    }
    return true;
  }

  /**
   * 链表长度
   */
  public static int length(ListNode head) {
    ListNode cur = head;
    int cnt = 0;
    while (cur != null) {
      cnt++;
      cur = cur.next;
    }
    return cnt;
  }

  /**
   * 环形链表长度
   */
  public static int lengthOfLoop(ListNode head) {
    if (head == null) {
      return 0;
    }
    int loopSize = 1;
    ListNode cur = head;
    cur = cur.next;
    while (cur != head) {
      loopSize++;
      cur = cur.next;
    }
    return loopSize;
  }

  /**
   * 链表 kth 元素([k-1])
   */
  public static ListNode findNth(ListNode head, int k) {
    assert k > 0;
    ListNode first = new ListNode(-1);
    first.next = head;
    ListNode cur = first;
    while (k-- > 0) {
      cur = cur.next;
    }
    return cur;
  }

  /**
   * 链表倒数 kth 元素
   */
  public static ListNode findKthToTail(ListNode head, int k) {
    if (head == null || k <= 0)
      return null;
    ListNode fast = head;
    while (fast != null && k-- > 0)
      fast = fast.next;
    if (k > 0) { // fast == null OR k ==0,    k invalid
      return null;
    }

    // step len - k step
    ListNode slow = head;
    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }
    return slow;
  }

  /**
   * 链表中间元素的前一个节点
   */
  public ListNode preMid(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    ListNode pre = null;
    while (fast != null && fast.next != null) {
      pre = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    return pre;
  }

  /**
   * 链表中间节点
   * 奇数: 中间节点； 偶数: 第二个中间节点
   */
  public ListNode midNode(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    if (fast == null) {
      // even count
      return slow;
    } else {
      // odd
      return slow;
    }
  }

  /**
   * 删除倒数 nth 节点
   */
  public static ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode first = new ListNode(-1);
    first.next = head;
    ListNode fast = head;
    while (n-- > 0) {
      fast = fast.next;
    }
    ListNode pre = first;
    while (fast != null) {
      pre = pre.next;
      fast = fast.next;
    }
    pre.next = pre.next.next;
    return first.next;
  }

  /**
   * 删除链表中的指定节点
   */
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

  /**
   * 反转链表
   */
  public static ListNode reverseList(ListNode head) {
    ListNode cur = head;
    ListNode pre = null;
    ListNode next = null;
    while (cur != null) {
      next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    return pre;
  }

  /**
   * 反转从 head 开始的 n 个节点
   * <pre>
   *   1->2->3->4->5->6->7->8
   *   head 4, n = 3
   *   1->2->3->6->5->4->7->8
   * </pre>
   */
  public static ListNode reverseCount(ListNode head, int n) {
    ListNode reversedTail = head;
    ListNode pre = null;
    ListNode cur = head;
    ListNode next = null;
    for (int i = 0; i <= n; i++) {           // must <=n, because return is pre
      next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    reversedTail.next = next;
    return pre;
  }

  /**
   * 获取两个链表的交点(模拟环)
   */
  public static ListNode getIntersectionNode(ListNode list1, ListNode list2) {
    ListNode cur1 = list1;
    ListNode cur2 = list2;
    while (cur1 != cur2) {
      cur1 = cur1 != null ? cur1.next : list2;
      cur2 = cur2 != null ? cur2.next : list1;
    }
    return cur1;
  }

  /**
   * 归并两个有序的链表
   */
  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
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

  /**
   * 奇偶链表
   */
  public ListNode oddEvenList(ListNode head) {
    if (head == null) return null;
    ListNode odd = head;
    ListNode even = head.next;
    ListNode evenHead = even;    // 保存用于最后直接链接
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
