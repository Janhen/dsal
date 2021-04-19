package com.janhen.design.randomqueue;

import java.util.ArrayList;
import java.util.List;

public class RandomQueue<E> {
    // not keep original put order
    private final List<E> queue;

    public RandomQueue() {
        queue = new ArrayList<E>();
    }

    public void add(E e) {
        queue.add(e);
    }

    // O(1)
    public E remove() {
        if (queue.size() == 0)
            throw new IllegalArgumentException("There's no element to remove in Random Qeuue");

        int randIdx = (int) (Math.random() * queue.size());
        E randElement = queue.get(randIdx);

        // take [N-1] to [randIdx]
        queue.set(randIdx, queue.get(queue.size() - 1));
        queue.remove(queue.size() - 1);

        return randElement;
    }

    public int size() {
        return queue.size();
    }

    public boolean empty() {
        return size() == 0;
    }
}
