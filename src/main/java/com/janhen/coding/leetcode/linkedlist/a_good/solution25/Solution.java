package main.java.janhen.leetcode.linkedlist.a_good.solution25;

// todo ListNode
/*******- 时间复杂度: O(N)******- 空间复杂度: O(1)******

 可以递归操作, 有两种情况：
 1. 就是压根没有k个node，那么我们直接保持这个k-group不动返回head
 2. 如果有k个node的话，那么我们先找到第k个node之后的递归结果 node = nxt，然后反转前面k个node，让反转结果的结尾 tail.next = nxt

 beats 92.70%*/
class Solution {



}