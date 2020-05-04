package com.janhen.design.stackwithmin;

import java.util.NoSuchElementException;
import java.util.Stack;

class MinStack {
  private Stack<Integer> data = new Stack<>();
  private Stack<Integer> min = new Stack<>();

  public void push(int x) {
    if (data.isEmpty())
      min.push(x);
    else if (x <= min.peek())
      min.push(x);
    data.push(x);
  }

  public void pop() {
    if (data.isEmpty())
      throw new NoSuchElementException();
    if (data.peek().equals(min.peek())) // NOTE: !!! two Integer compare must equal
      min.pop();
    data.pop();
  }

  public int top() {
    if (data.isEmpty())
      throw new NoSuchElementException();
    return data.peek();
  }

  public int getMin() {
    if (data.isEmpty())
      throw new NoSuchElementException();
    return min.peek();
  }
}
