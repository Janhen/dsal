package com.janhen.design.queuewithmax;

import org.junit.Test;

public class Main {
  public static void main(String[] args) {
    MaxQueue3 maxQueue = new MaxQueue3();   // FIFO + max
    maxQueue.offer(34);
    maxQueue.offer(34);
    maxQueue.offer(45);
    maxQueue.offer(90);
    maxQueue.offer(34);
    maxQueue.offer(21);
    maxQueue.offer(79);
    maxQueue.offer(3);
    maxQueue.offer(12);
    System.out.println(maxQueue.max());
    maxQueue.poll();
    maxQueue.poll();
    maxQueue.poll();
    maxQueue.poll();
    System.out.println(maxQueue.max());
  }

  @Test
  public void maxStack() {
    MaxQueue3.MaxStack maxStack = new MaxQueue3.MaxStack();
    maxStack.push(23);
    maxStack.push(23);
    maxStack.push(23);
    maxStack.push(25);
    maxStack.push(23);
    System.out.println(maxStack.max());
    maxStack.push(32);
    maxStack.push(45);
    System.out.println(maxStack.max());
    maxStack.pop();
    System.out.println(maxStack.max());
  }

  @Test
  public void maxQueue2() {
    MaxQueue2 maxQueue = new MaxQueue2();   // FIFO + max
    maxQueue.offer(34);
    maxQueue.offer(34);
    maxQueue.offer(45);
    maxQueue.offer(90);
    maxQueue.offer(34);
    maxQueue.offer(21);
    maxQueue.offer(79);
    maxQueue.offer(3);
    maxQueue.offer(12);
    System.out.println(maxQueue.max());
    maxQueue.poll();
    maxQueue.poll();
    maxQueue.poll();
    maxQueue.poll();
    System.out.println(maxQueue.max());
  }


  @Test
  public void maxQueue3() {
    MaxQueue2 maxQueue = new MaxQueue2();   // FIFO + max
    maxQueue.offer(34);
    maxQueue.offer(34);
    maxQueue.offer(45);
    maxQueue.offer(90);
    maxQueue.offer(34);
    maxQueue.offer(21);
    maxQueue.offer(79);
    maxQueue.offer(3);
    maxQueue.offer(12);
    System.out.println(maxQueue.max());
    maxQueue.poll();
    maxQueue.poll();
    maxQueue.poll();
    maxQueue.poll();
    System.out.println(maxQueue.max());
  }

  @Test
  public void maxQueue2_() {
    MaxQueue2 maxQueue = new MaxQueue2();   // FIFO + max
    maxQueue.offer(34);
    maxQueue.offer(34);
    maxQueue.offer(45);
    maxQueue.offer(90);
    maxQueue.offer(34);
    maxQueue.offer(21);
    maxQueue.offer(79);
    maxQueue.offer(3);
    maxQueue.offer(12);
    System.out.println(maxQueue.max());
    maxQueue.poll();
    maxQueue.poll();
    maxQueue.poll();
    maxQueue.poll();
    System.out.println(maxQueue.max());
  }
}
