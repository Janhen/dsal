package com.janhen.design.stackByQueue;

import org.junit.Test;

public class Main {

  @Test
  public void testStack() {
    MyStack stack = new MyStack();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    System.out.println(stack);

    int pop1 = stack.pop();
    int pop2 = stack.pop();
    int peek = stack.top();
    System.out.printf("%d %d %d", pop1, pop2, peek);
  }

  @Test
  public void testStack2() {
    MyStack2 stack = new MyStack2();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    System.out.println(stack);

    int pop1 = stack.pop();
    int pop2 = stack.pop();
    int peek = stack.top();
    System.out.printf("%d %d %d", pop1, pop2, peek);
  }
}
