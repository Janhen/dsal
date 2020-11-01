package com.janhen.structures.stack.basenode;

import com.janhen.structures.stack.IStack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<E> implements IStack<E>, Iterable<E> {
  private Node<E> first;

  private int N;

  private class Node<E> {
    E item;
    Node<E> next;

    Node(E item) {
      this.item = item;
    }

    Node(E item, Node next) {
      this.item = item;
      this.next = next;
    }
  }

  @Override
  public boolean isEmpty() {
    return first == null;
  }

  @Override
  public int size() {
    return N;
  }

  @Override
  public void push(E item) {
    Node node = new Node(item);
    node.next = first;
    first = node;
    N++;
  }

  @Override
  public E pop() {
    if (isEmpty()) throw new NoSuchElementException();

    Node oldTop = first;
    first = first.next;
    oldTop.next = null;
    N--;
    return (E) oldTop.item;
  }

  @Override
  public E peek() {
    if (isEmpty()) throw new NoSuchElementException();

    return first.item;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(String.format("Stack: size = %d\n", size()));
    for (E item : this) {
      sb.append(item).append("->");
    }
    sb.delete(sb.length() - 2, sb.length());
    return sb.toString();
  }


  @Override
  public Iterator<E> iterator() {
    return new ListIterator<>();
  }

  private class ListIterator<E> implements Iterator<E> {
    Node cur = first;

    @Override
    public boolean hasNext() {
      return cur != null;
    }

    @Override
    public E next() {
      if (!hasNext()) throw new NoSuchElementException();

      E item = (E) cur.item;
      cur = cur.next;
      return item;
    }
  }
}