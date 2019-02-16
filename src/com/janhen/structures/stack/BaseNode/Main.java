package com.janhen.structures.stack.BaseNode;

public class Main {

    public static void main(String[] args) {
        Stack<String> stack = new Stack();
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
