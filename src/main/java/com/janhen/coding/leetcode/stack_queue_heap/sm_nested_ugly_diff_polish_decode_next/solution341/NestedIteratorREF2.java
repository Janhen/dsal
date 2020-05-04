package main.java.janhen.leetcode.stack_queue_heap.sm_nested_ugly_diff_polish_decode_next.solution341;

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

import main.java.janhen.leetcode.structures.NestedInteger;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class NestedIteratorREF2 implements Iterator<Integer> {

    private Stack<ListIterator<NestedInteger>> stack;

    // todo Q
    public NestedIteratorREF2(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        stack.push(nestedList.listIterator());
    }

    public Integer next() {
        hasNext();
        return stack.peek().next().getInteger();
    }

    public boolean hasNext() {
        while (!stack.empty()) {
            if (!stack.peek().hasNext()) {     // 废弃一个迭代器
                stack.pop();
            } else {
                NestedInteger x = stack.peek().next();
                if (x.isInteger())
                    return stack.peek().previous() == x;
                stack.push(x.getList().listIterator());
            }
        }
        return false;
    }


}