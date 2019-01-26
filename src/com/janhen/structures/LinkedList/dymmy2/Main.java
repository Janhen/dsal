package com.janhen.structures.LinkedList.dymmy2;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        LinkedList<Integer> intList = new LinkedList<>();
        LinkedList<Character> clist = new LinkedList<>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7'));

        System.out.println(intList);
        System.out.println(clist);

        // dynamic query
        for (int i = 0; i < clist.size(); i++) {
            System.out.print(clist.get(i) + " ");
        }
        System.out.println(clist.contains('6'));
        System.out.println(clist.contains('#'));

        // dynamic update
        clist.set(3, 'C');
        clist.set(5, 'E');
        System.out.println(clist);


        for (int i = 0; i < 6; i ++) {
            // O(1)
            intList.addFirst(i);
            System.out.println(intList);
        }
        intList.remove(2);
        System.out.println(intList);
        intList.removeLast();
        intList.removeFirst();
        System.out.println(intList);
    }
}
