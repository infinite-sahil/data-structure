package org.somebody.ds.list;

/* ****************************************************************
 *  Author: Sahil Verma
 *  Created on: 27, January, 2019 8:02 PM
 * ****************************************************************
 */

public interface List<E> {

    void insertAtFront(final E element);

    void insertAtEnd(final E element);

    void deleteFromFront();

    void display();

}
