package org.somebody.ds.stack;

/* ****************************************************************
 *  Author: Sahil Verma
 *  Created on: 26, January, 2019 6:31 PM
 * ****************************************************************
 */

import org.somebody.ds.stack.StackException.StackOutOfBoundException;

public interface Stack<E> {

    /**
     * add element in the stack
     *
     * @throws StackOutOfBoundException in case max size limit breached
     */
    void add(E element) throws StackOutOfBoundException;

    /**
     * add element in the stack
     *
     * @return true if element added, else false
     */
    boolean push(E element);

    /**
     * this will remove the last/top most element from the stack
     *
     * @return popped element from the stack of type T
     */
    E pop();

    /**
     * @return the top most element present in the stack, else {@code null}
     */
    E peek();

    /**
     * @return current size of the stack
     */
    int size();

}
