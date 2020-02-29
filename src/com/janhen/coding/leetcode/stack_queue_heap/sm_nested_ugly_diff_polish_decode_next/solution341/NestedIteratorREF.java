package com.janhen.leetcode.stack_queue_heap.sm_nested_ugly_diff_polish_decode_next.solution341;

// 341. Flatten Nested List Iterator
//https://leetcode.com/problems/flatten-nested-list-iterator/

/*

Medium

764

290

Favorite

Share
Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:

Input: [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false,
             the order of elements returned by next should be: [1,1,2,1,1].
Example 2:

Input: [1,[4,[6]]]
Output: [1,4,6]
Explanation: By calling next repeatedly until hasNext returns false,
             the order of elements returned by next should be: [1,4,6].
 */

import com.janhen.leetcode.structures.NestedInteger;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIteratorREF implements Iterator<Integer> {
    NestedInteger nextInt;
    Stack<Iterator<NestedInteger>> stack;

    public NestedIteratorREF(List<NestedInteger> nestedList) {
        stack = new Stack<Iterator<NestedInteger>>();
        stack.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        return nextInt != null ? nextInt.getInteger() : null; //Just in case
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            if (!stack.peek().hasNext()) stack.pop();
            else if ((nextInt = stack.peek().next()).isInteger()) return true;
            else stack.push(nextInt.getList().iterator());
        }
        return false;
    }
}