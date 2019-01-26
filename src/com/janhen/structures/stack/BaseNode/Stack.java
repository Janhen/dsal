package com.janhen.structures.stack.BaseNode;

import com.janhen.structures.stack.IStack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<E> implements IStack<E>,Iterable<E> {
	private Node<E> first;

	private int N;

	private class Node<E>{
		E item;
		Node<E> next;

		Node(E element, Node next) {
			this.item = element;
			this.next = next;
		}
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int size() {
		return N;
	}

	// first interpolation
	public void push(E item) {
		Node<E> oldFirst = first;
		first = new Node<>(item, oldFirst);
		N ++;
	}
	
	public E pop() {
		if(isEmpty()) throw new NoSuchElementException();
		
		E item = first.item;
		first = first.next;
		N --;
		return item;
	}
	
	public E peek() {
		if(isEmpty()) throw new NoSuchElementException();

		return first.item;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("GetMinStack: size = %d\n", size()));
		sb.append("[");
		for(E item: this) {
			sb.append(item).append(", ");
		}
		// must have one element
		sb.delete(sb.length() - 2,sb.length()).append("]");
		return sb.toString();
	}
	
	
	@Override
	public Iterator<E> iterator() {
		return new ListIterator<>();
	}
	
	private class ListIterator<E> implements Iterator<E>{
		Node cur = first;

		@Override
		public boolean hasNext() {
			return cur != null;
		}

		@Override
		public E next() {
			if(!hasNext()) throw new NoSuchElementException();

			E item = (E) cur.item;
			cur = cur.next;
			return item;
		}
	}


}
























