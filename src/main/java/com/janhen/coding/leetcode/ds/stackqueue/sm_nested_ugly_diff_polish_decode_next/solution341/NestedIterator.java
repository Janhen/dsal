package com.janhen.coding.leetcode.ds.stackqueue.sm_nested_ugly_diff_polish_decode_next.solution341;


import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * <p>
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 * <p>
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 * <p>
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
  Stack<NestedInteger> stack = new Stack<>();

  public NestedIterator(List<NestedInteger> nestedList) {
    for (int i = nestedList.size() - 1; i >= 0; i--) {
      stack.push(nestedList.get(i));
    }
  }

  @Override
  public Integer next() {
    return stack.pop().getInteger();
  }

  @Override
  public boolean hasNext() {
    while (!stack.isEmpty()) {
      NestedInteger cur = stack.peek();
      if (cur.isInteger())
        return true;
      stack.pop();
      for (int i = cur.getList().size() - 1; i >= 0; i--) {
        stack.push(cur.getList().get(i));
      }
    }
    return false;
  }
}
