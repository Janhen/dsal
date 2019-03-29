package com.janhen.design.stackByQueue;

public class Main {

    public static void main(String[] args) {
        Stack<String> stack = new Stack();
        stack.push("ddd");
        stack.push("eee");
        stack.push("fff");
        stack.push("hhh");
        System.out.println(stack);

        String pop1 = stack.pop();
        String pop2 = stack.pop();
        String peek = stack.peek();
        System.out.printf("%s %s %s", pop1, pop2, peek);
    }
}
