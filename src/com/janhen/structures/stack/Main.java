package com.janhen.structures.stack;


import com.janhen.TestUtil;
import com.janhen.structures.stack.baseArray.Stack;
import org.junit.Test;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        IStack<Integer> arrayStack = new com.janhen.structures.stack.baseArray.Stack<>();
        IStack<Integer> linkedListStack = new com.janhen.structures.stack.baseNode.Stack<>();
        int count = 10000000;
        double t1 = testStack(arrayStack, count);
        double t2 = testStack(linkedListStack, count);
        System.out.printf("ArrayStack run : %f s\nLinkedListStack run : %f s\n", t1, t2);
        TestUtil.rate(t1, t2);
    }


    private static double testStack(IStack<Integer> queue, int count) {
        long start = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < count; i ++) {
            queue.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < count; i ++) {
            queue.pop();
        }
        return (System.nanoTime() - start) / 1000000000.0;
    }


    @Test
    public void testArrayImpl() {
        Stack<String> stack = new Stack();
        stack.push("ddd");
        System.out.println(stack);
        stack.push("eee");
        System.out.println(stack);
        stack.push("fff");
        System.out.println(stack);
        stack.push("hhh");
        System.out.println(stack);
        stack.push("AAA");
        System.out.println(stack);
        stack.push("BBB");
        System.out.println(stack);
        stack.push("CCC");
        System.out.println(stack);

        for(String s: stack) {
            System.out.println(s + " ");
        }

        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }

    @Test
    public void testNodeImpl() {
        com.janhen.structures.stack.baseNode.Stack<String> stack = new com.janhen.structures.stack.baseNode.Stack();
        stack.push("ddd");
        stack.push("eee");
        stack.push("fff");
        stack.push("hhh");
        System.out.println(stack);

        stack.pop();
        stack.pop();
        System.out.println(stack);
    }
}
