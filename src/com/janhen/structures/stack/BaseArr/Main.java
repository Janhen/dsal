package com.janhen.structures.stack.BaseArr;


public class Main {

    public static void main(String[] args) {
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
}
