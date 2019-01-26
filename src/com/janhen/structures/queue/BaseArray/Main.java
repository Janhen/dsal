package com.janhen.structures.queue.BaseArray;


public class Main {

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);
            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
