package com.janhen.coding.leetcode.other.topinterview.solution295;

import java.util.NoSuchElementException;
import java.util.PriorityQueue;

class MedianFinder {

  private PriorityQueue<Integer> leftSmall = new PriorityQueue<>((o1, o2) -> o2 - o1);
  private PriorityQueue<Integer> rightBig = new PriorityQueue<>();
  private int N;

  /** initialize your data structure here. */
  public MedianFinder() {

  }

  public void addNum(int num) {
    if (N % 2 == 0) {   // even, put rightBig AND ordered
      leftSmall.offer(num);
      rightBig.offer(leftSmall.poll());
    } else {            // odd, right N/2+1
      rightBig.offer(num);
      leftSmall.offer(rightBig.poll());
    }
    N++;
  }

  public double findMedian() {
    if (isEmpty())
      throw new NoSuchElementException();
    if (N % 2 == 0)
      return (leftSmall.peek() + rightBig.peek()) / 2.0;
    else
      return (double) rightBig.peek();
  }

  public boolean isEmpty() {
    return leftSmall.isEmpty() && rightBig.isEmpty();
  }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */