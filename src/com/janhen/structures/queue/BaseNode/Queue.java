package com.janhen.structures.queue.BaseNode;

import com.janhen.structures.queue.IQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class Queue<E> implements IQueue<E>, Iterable<E> {
	
	private Node<E> first;
	private Node<E> last;
	private int N;
	
    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }
    
    public E peek() {
    	if(isEmpty()) throw new NoSuchElementException();
    	return first.item;
    }
    

    // rpush + lpop
    public void enqueue(E item) {
    	Node node = new Node<>(item, null);
    	if (isEmpty()) {
    	    first = node;
    	    last = first;
        } else {
    	    last.next = node;
    	    last = last.next;
        }
    	N ++;
    }

    // lpop
    public E dequeue() {
    	if(isEmpty()) throw new NoSuchElementException();

    	Node oldFront = first;
    	first = first.next;
    	oldFront.next = null;
    	N --;

    	if (isEmpty()) last = null;
    	return (E) oldFront.item;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (E item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    } 


	@Override
	public Iterator<E> iterator() {
        return new ListIterator();
	}

    private class ListIterator<E> implements Iterator<E> {
        private Node cur = first;

        public boolean hasNext()  {
            return cur != null;
        }

        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            E item = (E) cur.item;
            cur = cur.next; 
            return item;
        }
    }

    private static class Node<E> {
        private E item;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.next = next;
            this.item = element;
        }
    }
}











