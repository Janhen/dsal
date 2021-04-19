package com.janhen.design.queuestorecatdog;

public class Main {
    public static void main(String[] args) {
        CatDogQueue catDogQueue = new CatDogQueue();

        Pet dog1 = new Dog();
        Pet cat1 = new Cat();
        Pet dog2 = new Dog();
        Pet cat2 = new Cat();
        Pet dog3 = new Dog();
        Pet cat3 = new Cat();

        catDogQueue.offer(dog1);
        catDogQueue.offer(cat1);
        catDogQueue.offer(dog2);
        catDogQueue.offer(cat2);
        catDogQueue.offer(dog3);
        catDogQueue.offer(cat3);

        catDogQueue.offer(dog1);
        catDogQueue.offer(cat1);
        catDogQueue.offer(dog2);
        catDogQueue.offer(cat2);
        catDogQueue.offer(dog3);
        catDogQueue.offer(cat3);

        catDogQueue.offer(dog1);
        catDogQueue.offer(cat1);
        catDogQueue.offer(dog2);
        catDogQueue.offer(cat2);
        catDogQueue.offer(dog3);
        catDogQueue.offer(cat3);

        while (!catDogQueue.isDogEmpty()) {
            System.out.println(catDogQueue.pollDog().getPetType());
        }
        while (!catDogQueue.isEmpty()) {
            System.out.println(catDogQueue.poll().getPetType());
        }
    }
}
