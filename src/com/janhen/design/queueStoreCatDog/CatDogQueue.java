package com.janhen.design.queueStoreCatDog;

import java.util.LinkedList;
import java.util.Queue;

public class CatDogQueue  {

    private Queue<WrappedPet> dogs = new LinkedList<>();
    private Queue<WrappedPet> cats = new LinkedList<>();
    private int               count;    // as index

    public boolean isEmpty() {
        return dogs.isEmpty() && cats.isEmpty();
    }

    public boolean isCatEmpty() {
        return cats.isEmpty();
    }

    public boolean isDogEmpty() {
        return dogs.isEmpty();
    }

    // add pet to different queue by pet type
    public void add(Pet pet) {
        if (pet instanceof Dog)
            dogs.add(new WrappedPet(pet, count ++));
        else if (pet instanceof Cat)
            cats.add(new WrappedPet(pet, count ++));
        else
            throw new IllegalArgumentException("not a dog or cat");
    }

    public Pet pollAll() {
        if (dogs.isEmpty() && cats.isEmpty())
            throw new IllegalArgumentException("queue is empty");

        if (dogs.isEmpty())
            return cats.poll().getPet();
        if (cats.isEmpty())
            return dogs.poll().getPet();

        // compare sequence number
        return dogs.peek().getCount() < cats.peek().getCount() ? dogs.poll().getPet() : cats.poll().getPet();
    }

    public Cat pollCat() {
        if (cats.isEmpty())
            throw new IllegalArgumentException("have no cat");

        return (Cat) cats.poll().getPet();
    }

    public Dog pollDog() {
        if (dogs.isEmpty())
            throw new IllegalArgumentException("have no dog");

        return (Dog) dogs.poll().getPet();
    }

    class WrappedPet {
        private Pet pet;
        private int count;

        public WrappedPet(Pet pet, int count) {
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return pet;
        }

        public int getCount() {
            return count;
        }
    }
}
