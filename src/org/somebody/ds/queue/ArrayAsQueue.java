package org.somebody.ds.queue;

/* ****************************************************************
 *  Author: Sahil Verma
 *  Created on: 26, January, 2019 8:19 PM
 * ****************************************************************
 */

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class ArrayAsQueue<E> extends AbstractQueue<E> implements Queue<E>, Serializable {

    private final int maxSize;
    private final Object[] elements;
    private int front = 0;
    private int rear = -1;
    private int nItems = 0;

    @Override
    public String toString() {

        return "Queue{" + Arrays.toString(elements) + '}';
    }

    public ArrayAsQueue(final int maxSize) {
        this.maxSize = maxSize;
        this.elements = new Object[maxSize];
    }


    @Override
    public boolean offer(final E e) {
        if (!isFull()) {
            elements[++rear] = e;
            nItems++;
            return true;
        }

        return false;
    }

    @Override
    public E poll() {
        E elementFound = peek();
        if (Objects.nonNull(elementFound)) {
            elements[front] = 0;
            front++;
            if (front == maxSize)
                front = 0;
            --nItems;
            // in case rear reached at end and number of items = 0, reset rear
            if (nItems == 0 && rear == maxSize - 1)
                rear = -1;
        }

        return elementFound;
    }

    @Override
    public E peek() {
        if (!isEmpty()) {
            return (E) elements[front];
        }

        return null;
    }

    @Override
    public int size() {
        return nItems;
    }

    private boolean isFull() {
        return this.nItems == maxSize;
    }

    private boolean isEmpty() {
        return nItems == 0;
    }

    private static final long serialVersionUID = 4097548657747348257L;

}
