package com.janhen.design.queuestorecatdog;

import java.util.LinkedList;
import java.util.Queue;

public class CatDogQueue {
    private final Queue<WrappedPet> dogs = new LinkedList<>();
    private final Queue<WrappedPet> cats = new LinkedList<>();
    private int sequence; // as index to keep order

    public boolean isEmpty() {
        return dogs.isEmpty() && cats.isEmpty();
    }

    public boolean isCatEmpty() {
        return cats.isEmpty();
    }

    public boolean isDogEmpty() {
        return dogs.isEmpty();
    }

    public void offer(Pet pet) {
        // add pet to different queue by pet type
        if (pet instanceof Dog) {
            dogs.add(new WrappedPet(pet, sequence++));
        } else if (pet instanceof Cat) {
            cats.add(new WrappedPet(pet, sequence++));
        } else {
            throw new IllegalArgumentException("not a dog or cat");
        }
    }

    public Pet poll() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty");
        }

        // one queue is empty
        if (dogs.isEmpty()) {
            return cats.poll().getPet();
        }
        if (cats.isEmpty()) {
            return dogs.poll().getPet();
        }

        // compare sequence number
        return dogs.peek().getCount() < cats.peek().getCount() ?
          dogs.poll().getPet() :
          cats.poll().getPet();
    }

    public Cat pollCat() {
        if (cats.isEmpty()) {
            throw new IllegalArgumentException("have no cat");
        }

        return (Cat) cats.poll().getPet();
    }

    public Dog pollDog() {
        if (dogs.isEmpty()) {
            throw new IllegalArgumentException("have no dog");
        }

        return (Dog) dogs.poll().getPet();
    }

    static class WrappedPet {
        private final Pet pet;
        private final int count;

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
