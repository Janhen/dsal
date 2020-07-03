# 链表问题 
常用思路:  
快慢指针  
递归  
虚拟头结点  
两条链表、单条链表拆分成两条链表  -- 考虑链表到底, 以及一条为 null, 一条不为 null
头插法逆序  





链表的添加 | 删除 | 交换 | 反转 | 查找 | 交换： 
链表元素的删除:  
删除链表中所有给定值的节点；  
删除链表中倒数的 kth 节点；  
删除排序的链表中重复元素节点      
删除排序的链表中重复元素节点并保留第一次出现的节点(去重)；     
删除链表中给定的节点   
在 O(1) 内删除给定的节点  

  

   

链表的判断和查找:   
判断链表是否有环；   
判断链表是否是回文链表；    
找到链表的倒数 kth 节点；   
找到链表的中间节点    
找到两条链表的交点；   
找出链表环的入口节点；  

  



链表的修改和构建:   
反转单链表；    
反转链表第 m,n 之间的节点；  
将链表旋转 k 位；  
交换相邻的两个节点形成新的链表；      
重建链表: 将链表按奇偶位置形成两条链表并拼接   
两条链表中的值相加     
反向存储的链表值相加；    

  

左右分割: 将链表分割成左半部分小于 x, 右半部分小于 大于x    
多条分割: 将一条链表分割成多条链表，有余时前面的个数大于后面的一个   


排序: 对单链表进行排序；   
链表的插入排序；   
按照指定规则排序原始链表；  
合并两个排序的链表    
合并 k 个已经排序的链表；    



根据有序链表构建平衡的二叉查找树；   
复杂链表的复制；  









链表的操作:

分割

排序

合并

复制

构建







**删除倒数第 n 个节点**

[19. Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/)

```
Given linked list: 1->2->3->4->5, and n = 2.
1->2->3->5.
```

思路一： 定位到第 n 个节点，同时记录 pre，用于删除

```java
public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode fast = head;
    while (n -- > 0)      // make fast is nth
        fast = fast.next;
    ListNode first = new ListNode(-1);
    first.next = head;
    ListNode pre = first;
    while (fast != null) {         // find nthFromEnd previous node
        pre = pre.next;
        fast = fast.next;
    }
    pre.next = pre.next.next;
    return first.next;
}
```

思路二： 通过 fast.next != null 进行两个指针的控制



**交换链表中的相邻结点**

[24. Swap Nodes in Pairs](https://leetcode.com/problems/swap-nodes-in-pairs/description/)

```
Given 1->2->3->4, you should return the list as 2->1->4->3.
```

思路一： 确定之前节点，当前节点，当前节点的下一个节点，以及下一次的next 节点

```java
public ListNode swapPairs(ListNode head) {
    ListNode first = new ListNode(-1);
    first.next = head;
    ListNode pre = first;
    while (pre.next != null && pre.next.next != null) {    // note : must first judge pre.next != null
        ListNode n1 = pre.next, n2 = n1.next, next = n2.next;
        n1.next = next;
        n2.next = n1;
        pre.next = n2;
        pre = n1;
    }
    return first.next;
}
```

思路二： 递归控制

```java
public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null)
        return head;
    ListNode n = head.next;
    head.next = swapPairs(n.next);
    n.next = head;
    return n;
}
```















**&& Good**

**按照组进行反转**









**将链表旋转给定 k 位**

```
Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
```

思路一： 类似数组的处理方式，计算出链表总长度，通过一次遍历找到尾节点以及倒数第 n 个节点的前一个节点，之后重新拆分拼接实现；

```java
public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null)
        return head;
    int len = length(head);
    k = k % len;                        // preHandle
    if (k == 0)
        return head;

    ListNode pre = null;
    ListNode cur = head;
    int cnt = 0;
    while (cur.next != null) {    // find pre node nthNodeFromEnd AND tail node
        cnt ++;
        if (cnt == len - k)       // count to calculate pre
            pre = cur;
        cur = cur.next;
    }
    ListNode newHead = pre.next;        // as head
    cur.next = head;
    pre.next = null;                  // as tail
    return newHead;
}

private int length(ListNode head) {
    ListNode cur = head;
    int len = 0;
    while (cur != null) {
        len ++;
        cur = cur.next;
    }
    return len;
}
```





**从已排序链表中删除所有的重复元素, 只留下不同的数组成的链表**

```
Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3
```

思路一： 递归找到第一个不等于当前值的节点，进行不断的递归

```java
public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null)
        return head;
    ListNode next = head.next;
    if (head.val == next.val) {
        while (next != null && head.val == next.val)  // head.val is excepted
            next = next.next;
        return deleteDuplicates(next);    // next is first not equal excepted value
    } else {
        head.next = deleteDuplicates(next);
        return head;
    }
}
```

思路二： 通过迭代指针 pre 进行控制

```java
public ListNode deleteDuplicates(ListNode head) {
    ListNode first = new ListNode(-1);
    first.next = head;
    ListNode pre = first;
    while (pre.next != null && pre.next.next != null) {
        if (pre.next.val == pre.next.next.val) {    // pre.next.val is expected
            ListNode cur = pre.next;
            while (cur.next != null && cur.val == cur.next.val)    // find last duplication
                cur = cur.next;
            pre.next = cur.next;
        } else {
            pre = pre.next;
        }
    }
    return first.next;
}
```



**从有序链表中删除重复节点，可保留1个节点**

[83. Remove Duplicates from Sorted List](https://leetcode.com/problems/remove-duplicates-from-sorted-list/)

```
Input: 1->1->2
Output: 1->2

Input: 1->1->2->3->3
Output: 1->2->3
```

思路一： 递归中找到最后一个等于当前节点的值的节点，递归向下进行删除

```java
public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode next = head.next;
    if (head.val == head.next.val) {
        while (next.next != null && head.val == next.next.val)
            next = next.next;   // next is last excepted
        return deleteDuplicates(next);
    }
    else {
        head.next = deleteDuplicates(next);
        return head;
    }
}
```

思路二： 通过迭代控制

```java
public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null)
        return head;
    ListNode pre = head;
    while (pre.next != null) {
        if (pre.val == pre.next.val) {    // can save pre
            ListNode cur = pre.next;
            while (cur.next != null && pre.val == cur.next.val)   // find last duplication
                cur = cur.next;
            pre.next = cur.next;
        } else  {
            pre = pre.next;
        }
    }
    return head;
}
```



**反转 m,n 位置之间的节点**

[92. Reverse Linked List II](https://leetcode.com/problems/reverse-linked-list-ii/)

```
Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
```

思路： 定位到第 m 个节点的前面，反转 m 到 n 的节点，同时将反转后的尾节点与原来的链表进行连接，之后与原来的链表进行连接

```java
public ListNode reverseBetween(ListNode head, int m, int n) {
    if(head == null) return null;
    ListNode first = new ListNode(-1);
    first.next = head;
    ListNode pre = first;
    for(int i = 0; i<m-1; i++)
        pre = pre.next;   // find mth node previous
    // link reverse list
    pre.next = reverseCount(pre.next, n - m);
    return first.next;
}

private ListNode reverseCount(ListNode head, int n) {
    ListNode reversedTail = head;
    ListNode pre = null;
    ListNode cur = head;
    ListNode next = null;
    for (int i = 0; i <= n; i ++) {   // Note: must <=n, because return is pre
        next = cur.next;
        cur.next = pre;
        pre = cur;
        cur = next;
    }
    reversedTail.next = next;
    return pre;
}
```



**判断链表是否有环**

[141. Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)

```java
public boolean hasCycle(ListNode head) {
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) 
            return true;
    }
    return false;
}
```

**返回环的入口节点**

```
Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1

Input: head = [1,2], pos = 0
Output: tail connects to node index 0

Input: head = [1], pos = -1
Output: no cycle


Follow up:
Can you solve it without using extra space?
```

[142. Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/)

思路一：FastPointer的移动速度是SlowPointer的两倍。当SlowPointer走了k个结点进
入环路时，FastPointer已进入链表环路k个结点。也就是说FastPointer和SlowPointer相距
LOOP_SIZE - k个结点。
接下来，若SlowPointer每走一个结点，FastPointer就走两个结点，每走一次，两者的距离就会更近一个结点。
因此，在走了LOOP_SIZE - k次后，它们就会碰在一起。
这时两者距离环路起始处有k个结点。   即 LOOP_SIZE-k
从 entrance to merge 共 LOOP_SIZE-k
从 merge to entrance 共 LOOP_SIZE-(LOOP_SIZE-k)=k 步

```java
public ListNode detectCycle(ListNode head) {
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (fast == slow)
            break;
    }
    if (fast == null || fast.next == null)
        return null;   // have no loop
    slow = head;
    while (slow != fast) {
        slow = slow.next;
        fast = fast.next;
    }
    return slow;
}
```

思路二： 遍历链表，确定是否有环
计算环中的节点个数
快指针走环的步数，之后快慢指针同时走碰撞处即为环的入口节点

```java
public ListNode detectCycle(ListNode head) {
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (fast == slow)
            break;
    }
    if (fast == null || fast.next == null)
        return null;   // no loop

    int loopCnt = lengthOfLoop(fast);
    fast = head;
    while (loopCnt -- > 0)
        fast = fast.next;
    slow = head;
    while (fast != slow) {
        slow = slow.next;
        fast = fast.next;
    }
    return fast;
}

private int lengthOfLoop(ListNode head) {
    int loopSize = 1;
    ListNode cur = head;
    cur = cur.next;
    while (cur != head) {
        loopSize ++;
        cur = cur.next;
    }
    return loopSize;
}
```





**两个链表的相交节点**

[160. Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists/)

思路一： 两个模拟成环

```java
public ListNode getIntersectionNode(ListNode list1, ListNode list2) {
    ListNode cur1 = list1, cur2 = list2;
    while (cur1 != cur2) {
        cur1 = cur1 != null ? cur1.next : list2;
        cur2 = cur2 != null ? cur2.next : list1;
    }
    return cur1;
}
```



思路二： 两个指针指向的链表长度相同, 正向比较





思路三： 栈进行逆向比较





**删除链表中等于给定值的节点**

[203. Remove Linked List Elements](https://leetcode.com/problems/remove-linked-list-elements/description/)

```
Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
```

思路一： 迭代控制

```java
public static ListNode removeElements(ListNode head, int val) {
    ListNode first = new ListNode(-1);
    first.next = head;
    ListNode pre = first;
    while (pre.next != null) {
        if (pre.next.val == val)
            pre.next = pre.next.next;     // val is excepted
        else
            pre = pre.next;
    }
    return first.next;
}
```

思路二： 递归控制

```java
public ListNode removeElements(ListNode head, int val) {
    if (head == null) return null;
    if (head.val == val)
        return removeElements(head.next, val);    // like traverse
    else {
        head.next = removeElements(head.next, val);
        return head;
    }
}
```





**反转链表**

[206. Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/description/)

思路一： 迭代控制

```java
public ListNode reverseList(ListNode head) {
    ListNode cur = head;
    ListNode pre = null;
    while (cur != null) {                   // can use for count reverse
        ListNode next = cur.next;
        cur.next = pre;
        pre = cur;
        cur = next;
    }
    return pre;
}
```

思路二： 递归控制

```java
public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null)
        return head;
    ListNode reverseHead = reverseList(head.next);
    head.next.next = head;
    head.next = null;               // as tail
    return reverseHead;
}
```



**判断回文链表**

[234. Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/)



思路一： 无需额外空间实现

```java
public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) return true;
    ListNode fast = head, slow = head, pre = null;    // record slow previous node
    while (fast != null && fast.next != null) {
        pre = slow;
        slow = slow.next;
        fast = fast.next.next;
    }
    pre.next = null;                // cut
    if (fast != null) slow = slow.next;

    ListNode l1 = head;
    ListNode l2 = reverse(slow);
    return isEqual(l1, l2);
}

private boolean isEqual(ListNode l1, ListNode l2) {
    while (l1 != null && l2 != null) {
        if (l1.val != l2.val) return false;
        l1 = l1.next;
        l2 = l2.next;
    }
    return l1 == null && l2 == null;
}

private ListNode reverse(ListNode list) {
    ListNode pre = null;
    ListNode next = null;
    while (list != null) {
        next = list.next;
        list.next = pre;
        pre = list;
        list = next;
    }
    return pre;
}
```

思路二： 一半空间的栈实现

```java
public boolean isPalindrome(ListNode head) {
    Stack<Integer> s = new Stack<>();           // store half node
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
        s.push(slow.val);
        slow = slow.next;
        fast = fast.next.next;
    }
    if (fast != null)
        slow = slow.next;     // odd count, [slow, tail] N/2+1, now slow point to middle node
    while (slow != null) {    // also can !s.isEmpty();   slow from left to right, stack from right to left;
        if (s.pop() != slow.val)
            return false;
        slow = slow.next;
    }
    return true;
}
```

**在 O(1) 删除节点**

[237. Delete Node in a Linked List](https://leetcode.com/problems/delete-node-in-a-linked-list/description/)

思路一： 将可能的情况考虑全面即可

P1: head
P2: middle node
P3: tail node

```java
public ListNode deleteNode(ListNode head, ListNode tobeDelete) {
    if (head == null || tobeDelete == null)
        return null;
    if (tobeDelete.next != null) {   // not tail
        ListNode next = tobeDelete.next;
        tobeDelete.val = next.val;
        tobeDelete.next = next.next;
        next.next = null;
    } else {
        if (head == tobeDelete) {  // only one element
            head = null;
        } else {
            ListNode cur = head;
            while (cur.next != tobeDelete)      // find 2th from end
                cur = cur.next;
            cur.next = null;   // as tail
        }
    }
    return head;
}
```











## 复杂操作

&& 链表的

**链表存放数字求相加后的链表**

[2. Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)

```java
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    return addTwoNumbers(l1, l2, 0);
}

private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
    if (l1 == null && l2 == null && carry == 0)
        return null;
    int val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
    ListNode head = new ListNode(val % 10);        // insure one element
    head.next = addTwoNumbers(l1 == null ? null : l1.next, l2 == null ? null : l2.next, val / 10);
    return head;
}
```

**合并 2 个已经排序的链表**

[21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)

思路一： 递归实现

```java
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    if (l1.val < l2.val) {
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
    } else {
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }
}
```

思路二： 迭代控制



**合并 k 个已经排序的链表**

[23. Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/)

```
Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
```

思路一： 类似归并排序试下

```java
public ListNode mergeKLists(ListNode[] lists) {
    return mergeSortList(lists, 0, lists.length - 1);
}

private ListNode mergeSortList(ListNode[] lists, int lo, int hi) {
    if (lo > hi) return null;
    if (lo == hi) return lists[lo];    // only one list original condition or terminal sorted list

    int mid = lo + (hi - lo) / 2;
    ListNode left = mergeSortList(lists, lo, mid);
    ListNode right = mergeSortList(lists, mid + 1, hi);
    return merge(left, right);
}

private ListNode merge(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    if (l1.val < l2.val) {
        l1.next = merge(l1.next, l2);
        return l1;
    } else {
        l2.next = merge(l1, l2.next);
        return l2;
    }
}
```

思路二： 类似堆排序实现

```java
public ListNode mergeKLists(ListNode[] lists) {
    return mergeSortList(lists, 0, lists.length - 1);
}

private ListNode mergeSortList(ListNode[] lists, int lo, int hi) {
    if (lo > hi) return null;
    if (lo == hi) return lists[lo];    // only one list original condition or terminal sorted list

    int mid = lo + (hi - lo) / 2;
    ListNode left = mergeSortList(lists, lo, mid);
    ListNode right = mergeSortList(lists, mid + 1, hi);
    return merge(left, right);
}

private ListNode merge(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    if (l1.val < l2.val) {
        l1.next = merge(l1.next, l2);
        return l1;
    } else {
        l2.next = merge(l1, l2.next);
        return l2;
    }
}
```



 **分隔链表,左部分小于 x, 有部分大于等于 x**

[86. Partition List](https://leetcode.com/problems/partition-list/)

```
Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5
```

题目描述： 需要调整后的链表保持原来的顺序

```java
public ListNode partition(ListNode head, int x) {
    ListNode first1 = new ListNode(-1), first2 = new ListNode(-1);
    ListNode tail1 = first1, tail2 = first2;
    while (head != null) {
        if (head.val < x) {
            tail1.next = head;
            tail1 = head;
        } else {
            tail2.next = head;
            tail2 = head;
        }
        head = head.next;
    }
    tail2.next = null;                  // as all list tail ??
    tail1.next = first2.next;
    return first1.next;
}
```



**根据有序链表构造平衡的二叉查找树**

[109. Convert Sorted List to Binary Search Tree](https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/)

```
Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
```

```java
public TreeNode sortedListToBST(ListNode head) {
    if (head == null) return null;
    if (head.next == null)
        return new TreeNode(head.val);

    ListNode preMid = preMid(head);           // not need precise odd OR even count
    ListNode mid = preMid.next;
    preMid.next = null;                       // cut ⇒ two list

    TreeNode root = new TreeNode(mid.val);   // head... preMid
    root.left = sortedListToBST(head);
    root.right = sortedListToBST(mid.next);   // Note: mid.next ... tail
    return root;
}

private ListNode preMid(ListNode head) {
    ListNode slow = head, fast = head;
    ListNode pre = null;
    while (fast != null && fast.next != null) {
        pre = slow;
        slow = slow.next;
        fast = fast.next.next;
    }
    return pre;
}
```





**复杂链表的深度拷贝**

[138. Copy List with Random Pointer](https://leetcode.com/problems/copy-list-with-random-pointer/)



思路一： 分为三个步骤进行执行

step1. insert to cur and cur.next
step2. random connect
step3. split by one point

```
public RandomListNode copyRandomList(RandomListNode head) {
    if (head ==  null) return null;
    RandomListNode cur = head;
    while (cur != null) {
        RandomListNode copy = new RandomListNode(cur.label);
        copy.next = cur.next;
        cur.next = copy;
        cur = copy.next;
    }
    cur = head;    // traverse original list
    while (cur != null) {
        RandomListNode clone = cur.next;
        if (cur.random != null) clone.random = cur.random.next;     // random not every node have
        cur = clone.next;
    }
    cur = head;     // traverse combined list and split it
    RandomListNode copyHead = cur.next;
    while (cur.next != null) {
        RandomListNode next = cur.next;
        cur.next = next.next;
        cur = next;
    }
    return copyHead;
}
```

思路二： 通过 Map 记录拷贝

```java
public RandomListNode copyRandomList(RandomListNode head) {
    Map<RandomListNode, RandomListNode> map = new HashMap<>();   // record origin node -> copy node
    RandomListNode cur1 = head;               // use for iteration
    RandomListNode tail = new RandomListNode(-1);  // use for link copy node
    while (cur1 != null) {
        RandomListNode copy = new RandomListNode(cur1.label);
        map.put(cur1, copy);
        tail.next = copy;             // NOTE: need to link list
        tail = copy;
        cur1 = cur1.next;
    }
    for (Map.Entry<RandomListNode, RandomListNode> entry : map.entrySet())
        entry.getValue().random = map.get(entry.getKey().random);
    return map.get(head);
}
```



**按照指定规则排序原始链表**

[143. Reorder List](https://leetcode.com/problems/reorder-list/)

```
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

Given 1->2->3->4, reorder it to 1->4->2->3.

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
```

思路： 截取两条链表，将后面的链表进行反转，链条链表进行交叉连接

```java
public void reorderList(ListNode head) {
    if (head == null || head.next == null) return;
    ListNode preMid = preMid(head);
    ListNode l1 = head;
    ListNode l2 = reverse(preMid.next);  // NOTE: may more than l1 one element
    preMid.next = null;           // cut into two list
    mergeCross(l1, l2);
}

public ListNode mergeCross(ListNode l1, ListNode l2) {
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

private ListNode preMid(ListNode head) {
    ListNode fast = head, slow = head, pre = null;
    while (fast != null && fast.next != null) {
        pre = slow;
        slow = slow.next;
        fast = fast.next.next;
    }
    return pre;
}

private ListNode reverse(ListNode head) {
    ListNode pre = null;
    ListNode next = null;
    while (head != null) {
        next = head.next;
        head.next = pre;
        pre = head;
        head = next;
    }
    return pre;
}
```



**链表排序**

[148. Sort List](https://leetcode.com/problems/sort-list/)

```
Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5
```

思路： 分割成两条链表，分别对其进行排序，之后进行两条链表的合并

```java
public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode preMid = preMid(head);
    ListNode mid = preMid.next;
    preMid.next = null;

    ListNode l1 = sortList(head);
    ListNode l2 = sortList(mid);
    return merge(l1, l2);
}

private ListNode preMid(ListNode head) {
    ListNode pre = null, fast = head, slow = head;
    while (fast != null && fast.next != null) {
        pre = slow;
        slow = slow.next;
        fast = fast.next.next;
    }
    return pre;
}

private ListNode merge(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    if (l1.val < l2.val) {
        l1.next = merge(l1.next, l2);
        return l1;
    } else {
        l2.next = merge(l1, l2.next);
        return l2;
    }
}
```



**链表元素按奇偶分割并拼接**

[328. Odd Even Linked List](https://leetcode.com/problems/odd-even-linked-list/)

```
Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
```

思路： 

```java
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
```





**反向表示数字的链表求和**

```
Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
```

思路一： 借助栈实现

```java
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    Stack<ListNode> s1 = buildStack(l1);
    Stack<ListNode> s2 = buildStack(l2);
    int carry = 0;
    ListNode first = new ListNode(-1);             // NOTE: make result to reverse
    while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {        // can enter the loop
        int val = (s1.isEmpty() ? 0 : s1.pop().val) + (s2.isEmpty() ? 0 : s2.pop().val) + carry;
        carry = val / 10;
        ListNode node = new ListNode(val % 10);
        node.next = first.next;                           // 头插法逆序 7087 ⇒ 7807
        first.next = node;
    }
    return first.next;
}

private Stack<ListNode> buildStack(ListNode list) {
    Stack<ListNode> s = new Stack<>();
    while (list != null) {
        s.push(list);
        list = list.next;
    }
    return s;
}
```



思路二： 将两条链表反转，对反转链表进行求和，之后将求和的链表进行反转返回

```java
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    l1 = reverse(l1);
    l2 = reverse(l2);
    ListNode resReverse = addTwoNumbers(l1, l2, 0);
    return reverse(resReverse);
}

private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
    if (l1 == null && l2 == null && carry == 0) return null;

    int val = (l1 == null ? 0 :l1.val) + (l2 == null ? 0 : l2.val) + carry;
    carry = val / 10;
    ListNode res = new ListNode(val % 10);
    res.next = addTwoNumbers(l1 == null ? null : l1.next, l2 == null ? null : l2.next, carry);  // prevent NullPointerException
    return res;
}

private ListNode reverse(ListNode head) {
    ListNode pre = null;
    ListNode cur = head;
    ListNode next = null;
    while (cur != null) {
        next = cur.next;
        cur.next = pre;
        pre = cur;
        cur = next;
    }
    return pre;
}
```





**将一条链表分割成多条链表，有余时前面的个数大于后面的一个**

[725. Split Linked List in Parts](https://leetcode.com/problems/split-linked-list-in-parts/)

```
Input:
root = [1, 2, 3], k = 5
Output: [[1],[2],[3],[],[]]

Input:
root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
```

思路： 获取平均链表长度，计算需要多少额外的链表长度可以多一个节点

```java
public ListNode[] splitListToParts(ListNode root, int k) {
    int len = length(root);
    ListNode[] parts = new ListNode[k];
    int size = len / k, remain = len % k;
    ListNode pre = null, cur = root;
    for (int i = 0; i < k && cur != null; i ++) {         // two iteration pointer
        parts[i] = cur;
        int curSize = size + (remain -- > 0 ? 1 : 0);
        for (int j = 0; j < curSize; j ++) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = null;            // split
    }
    return parts;
}

private int length(ListNode head) {
    int len = 0;
    ListNode cur = head;
    while (cur != null) {
        len ++;
        cur = cur.next;
    }
    return len;
}
```