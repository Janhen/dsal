package com.janhen.structures.avl.ref;

import com.janhen.structures.avl.AVLTree;
import com.janhen.structures.setandmap.set.Set;

public class AVLSet<E extends Comparable<E>> implements Set<E> {

    AVLTree<E, Object> avlTree;

    public AVLSet() {
        avlTree = new AVLTree<>();
    }

    @Override
    public void add(E e) {
        avlTree.add(e, null);
    }

    @Override
    public void remove(E e) {
        avlTree.remove(e);
    }

    @Override
    public int size() {
        return avlTree.size();
    }

    @Override
    public boolean isEmpty() {
        return avlTree.isEmpty();
    }

    @Override
    public boolean contains(E e) {
        return avlTree.contains(e);
    }
}
