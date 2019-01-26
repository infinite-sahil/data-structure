package org.somebody.ds.stack;

/* ****************************************************************
 *  Author: Sahil Verma
 *  Created on: 26, January, 2019 4:27 PM
 * ****************************************************************
 */

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import org.somebody.ds.stack.StackException.EmptyStackException;

public class ArrayAsStack<E> extends AbstractStack<E> implements Stack<E>, Serializable {

    private final int maxSize;
    private final Object[] array;
    private int top;


    public ArrayAsStack(final int maxSize) {
        this.maxSize = maxSize;
        this.array = new Object[maxSize];
        // default initialization to -1
        this.top = -1;
    }

    @Override
    public boolean push(final E element) {
        if (isFull())
            return false;

        array[++top] = element;
        return true;
    }

    @Override
    public E pop() {
        E elementAtTop = peek();
        if (Objects.isNull(elementAtTop))
            throw new EmptyStackException("Stack is Empty!");

        removeElementFromTop();
        return elementAtTop;
    }

    @Override
    public E peek() {
        if (isEmpty())
            return null;
        return (E) array[top];
    }

    @Override
    public String toString() {
        return "Stack{" + Arrays.toString(array) + '}';
    }


    /* ********************* Helper Methods ************************** */

    private void removeElementFromTop() {
        array[top--] = null;
    }

    protected boolean isEmpty() {
        return (top == -1);
    }

    protected boolean isFull() {
        return (maxSize - 1) == top;
    }

    @Override
    public int size() {
        return this.array.length;
    }

    private static final long serialVersionUID = 8264166301053956358L;

}
