package com.janhen.design.queueStoreCatDog;

// 实现一种狗猫队列的结构，要求如下： 用户可以调用
// add        方法，将cat类或dog类的实例放入队列中； 用户可以调用
// pollAll    方法，将队列中所有的实例按照进队列的先后顺序依次弹出； 用户可以调用
// pollDog    方法，将队列中dog类的实例按照进队列的先后顺序依次弹出； 用户可以调用
// pollCat    方法，将队列中cat类的实例按照进队列的先后顺序依次弹出； 用户可以调用
// isEmpty    方法，检查队列中是否还有dog或cat的实例； 用户可以调用
// isDogEmpty 方法，检查队列中是否有dog类的实例； 用户可以调用
// isCatEmpty 方法，检查队列中是否有cat类的实例。

import java.util.LinkedList;
import java.util.Queue;

public class CatDogQueue  {

    private Queue<WrappedPet> dogs = new LinkedList<>();
    private Queue<WrappedPet> cats = new LinkedList<>();
    private int               count;

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

        if (dogs.isEmpty())     // dogs OR cats is empty
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
