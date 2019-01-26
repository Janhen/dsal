package com.janhen.structures.stack;


import java.util.Random;

public class Main {

    public static void main(String[] args) {

        /*
        dequeue different:
        arrayStack : O(N)
        linkedListStack : 均摊 O(1)
         */
        IStack<Integer> arrayStack = new com.janhen.structures.stack.BaseArray.Stack<>();
        IStack<Integer> linkedListStack = new com.janhen.structures.stack.BaseLinkedList.Stack<>();
        int count = 10000000;

        double t1 = testStack(arrayStack, count);
        double t2 = testStack(linkedListStack, count);
        System.out.printf("ArrayStack run : %f s\nLinkedListStack run : %f s\n倍数： %f",
                t1,
                t2, t1 / t2);
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
}
