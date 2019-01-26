package com.janhen.structures.array.BaseInt;

public class Main {

    public static void main(String[] args) {
        Array arr = new Array(20);
        for (int i = 0; i < 10; i++)
            arr.add(i);

        arr.add(1, 90);
        System.out.println(arr);
        arr.addFirst(91);
        System.out.println(arr);
        arr.add(3, 93);
        System.out.println(arr);

        arr.remove(3);
        System.out.println(arr);
        arr.removeFirst();
        System.out.println(arr);
        arr.removeElement(90);
        System.out.println(arr);
    }
}
