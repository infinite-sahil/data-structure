package org.somebody.ds.queue;

/* ****************************************************************
 *  Author: Sahil Verma
 *  Created on: 26, January, 2019 8:17 PM
 * ****************************************************************
 */

import org.somebody.ds.queue.QueueException.EmptyQueueException;

public abstract class AbstractQueue<E> implements Queue<E> {

    /**
     * Constructor for use by subclasses.
     */
    protected AbstractQueue() {
    }

    public boolean insert(E e) {
        if (offer(e))
            return true;
        else
            throw new QueueException.QueueOutOfBoundException("Queue is full!");
    }


    public E remove() {
        E x = poll();
        if (x != null)
            return x;
        else
            throw new EmptyQueueException("Queue is empty!");
    }


    public E element() {
        E x = peek();
        if (x != null)
            return x;
        else
            throw new EmptyQueueException("Queue is empty!");
    }


    public void clear() {
        while (poll() != null)
            ;
    }

}
