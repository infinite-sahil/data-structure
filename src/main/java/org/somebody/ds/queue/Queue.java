package org.somebody.ds.queue;

/* ****************************************************************
 *  Author: Sahil Verma
 *  Created on: 26, January, 2019 6:31 PM
 * ****************************************************************
 */

import org.somebody.ds.queue.QueueException.EmptyQueueException;
import org.somebody.ds.queue.QueueException.QueueOutOfBoundException;

public interface Queue<E> {

    /**
     * Inserts the specified element into this queue if it is possible to do so immediately without
     * violating capacity restrictions, returning {@code true} upon success and throwing an {@code
     * QueueOutOfBoundException} if no space is currently available.
     *
     * @param element the element to add
     *
     * @throws QueueOutOfBoundException if queue max size limit reached
     */
    boolean insert(E element) throws QueueOutOfBoundException;

    /**
     * Inserts the specified element into this queue if it is possible to do so immediately without
     * violating capacity restrictions. When using a capacity-restricted queue, this method is
     * generally preferable to insert, which can fail to insert an element only by throwing an
     * exception.
     *
     * @param e the element to add
     *
     * @return true if element if added, false in case element addition failed due to capacity
     * constraint. *
     */
    boolean offer(E e);

    /**
     * Retrieves and removes the head of this queue.  This method differs from {@link #poll poll}
     * only in that it throws an exception if this queue is empty.
     *
     * @return the head of this queue
     *
     * @throws EmptyQueueException if this queue is empty
     */
    E remove() throws EmptyQueueException;


    /**
     * Retrieves and removes the head of this queue, or returns null if this queue is empty.
     *
     * @return the head of this queue, or null if this queue is empty
     */
    E poll();

    /**
     * Retrieves, but does not remove, the head of this queue.  This method differs from peek only
     * in that it throws an exception if this queue is empty.
     *
     * @return the head of this queue
     *
     * @throws EmptyQueueException if this queue is empty
     */
    E element() throws EmptyQueueException;


    /**
     * Retrieves, but does not remove, the head of this queue,
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    E peek();

    /**
     * @return current size of the stack
     */
    int size();

}
