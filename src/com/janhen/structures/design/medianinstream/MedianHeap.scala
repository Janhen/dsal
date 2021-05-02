package com.janhen.structures.design.medianinstream

import scala.collection.mutable.PriorityQueue

/**
 * MedianHeap 被设计用来快速跟踪可能包含重复的一组数字的中值。
 */
class MedianHeap(implicit val ord: Ordering[Double]) {

    /**
     * Stores all the numbers less than the current median in a smallerHalf,
     * i.e median is the maximum, at the root.
     */
    private[this] var smallerHalf = PriorityQueue.empty[Double](ord)

    /**
     * Stores all the numbers greater than the current median in a largerHalf,
     * i.e median is the minimum, at the root.
     */
    private[this] var largerHalf = PriorityQueue.empty[Double](ord.reverse)

    def isEmpty(): Boolean = {
        smallerHalf.isEmpty && largerHalf.isEmpty
    }

    def size(): Int = {
        smallerHalf.size + largerHalf.size
    }

    def insert(x: Double): Unit = {
        // If both heaps are empty, we arbitrarily insert it into a heap, let's say, the largerHalf.
        if (isEmpty) {
            largerHalf.enqueue(x)
        } else {
            // If the number is larger than current median, it should be inserted into largerHalf,
            // otherwise smallerHalf.
            if (x > median) {
                largerHalf.enqueue(x)
            } else {
                smallerHalf.enqueue(x)
            }
        }
        rebalance()
    }

    private[this] def rebalance(): Unit = {
        if (largerHalf.size - smallerHalf.size > 1) {
            smallerHalf.enqueue(largerHalf.dequeue())
        }
        if (smallerHalf.size - largerHalf.size > 1) {
            largerHalf.enqueue(smallerHalf.dequeue)
        }
    }

    def median: Double = {
        if (isEmpty) {
            throw new NoSuchElementException("MedianHeap is empty.")
        }
        if (largerHalf.size == smallerHalf.size) {
            (largerHalf.head + smallerHalf.head) / 2.0
        } else if (largerHalf.size > smallerHalf.size) {
            largerHalf.head
        } else {
            smallerHalf.head
        }
    }
}
