package com.janhen.design.boundedpriorityqueue;

import java.util.*;

/**
 * 有界优先队列<br>
 * 按照给定的排序规则，排序元素，当队列满时，按照给定的排序规则淘汰末尾元素（去除末尾元素）
 */
public class BoundedPriorityQueue<E> extends PriorityQueue<E> {
  private static final long serialVersionUID = 8901641696702347759L;

	private static final int DEFAULT_INITIAL_CAPACITY = 11;

  private final int capacity;
  private final Comparator<? super E> comparator;

  public BoundedPriorityQueue() {
  	this(DEFAULT_INITIAL_CAPACITY);
	}

  public BoundedPriorityQueue(int capacity) {
    this(capacity, null);
  }

  public BoundedPriorityQueue(int capacity, final Comparator<? super E> comparator) {
    super(capacity, (o1, o2) -> {
      int compareResult;
      if (comparator != null) {
        compareResult = comparator.compare(o1, o2);
      } else {
      	// E must Comparable
        Comparable<E> o1c = (Comparable<E>) o1;
        compareResult = o1c.compareTo(o2);
      }
			// max heap
      return -compareResult;
    });
    this.capacity = capacity;
    this.comparator = comparator;
  }

  @Override
  public boolean offer(E e) {
    if (size() >= capacity) {
      E head = peek();
      if (this.comparator().compare(e, head) <= 0) {
        return true;
      }
      // eliminate old element
      poll();
    }
    return super.offer(e);
  }

  public boolean addAll(E[] c) {
    return this.addAll(Arrays.asList(c));
  }

  /**
   * @return 返回排序后的列表
   */
  public ArrayList<E> toList() {
    final ArrayList<E> list = new ArrayList<>(this);
    list.sort(comparator);
    return list;
  }

  @Override
  public Iterator<E> iterator() {
    return toList().iterator();
  }
}
