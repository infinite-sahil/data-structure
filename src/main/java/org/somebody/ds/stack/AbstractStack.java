package org.somebody.ds.stack;

/* ****************************************************************
 *  Author: Sahil Verma
 *  Created on: 26, January, 2019 7:30 PM
 * ****************************************************************
 */

import org.somebody.ds.stack.StackException.StackOutOfBoundException;

public abstract class AbstractStack<E> implements Stack<E> {


    protected AbstractStack() {
    }

    @Override
    public void add(E element) throws StackOutOfBoundException {
        boolean isElementAdded = push(element);
        if (!isElementAdded)
            throw new StackOutOfBoundException("Stack is full!");

    }


}
