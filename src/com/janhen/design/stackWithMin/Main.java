package com.janhen.design.stackWithMin;


public class Main {

    public static void main(String[] args) {
        GetMinStack<Integer> stack = new GetMinStack();
        stack.push(7);
        stack.push(5);
        stack.push(3);
        stack.push(4);
        stack.push(6);
        Integer min1 = stack.getMin();
        stack.pop();
        Integer min2 = stack.getMin();
        stack.push(1);
        Integer min3 = stack.getMin();
        stack.pop();
        Integer min4 = stack.getMin();
        System.out.printf("Original min: %s, pop one min: %s, push 1 min: %s, pop one min: %s", min1, min2, min3, min4);
    }
}
