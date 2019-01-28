package org.somebody.ds.list;

/* ****************************************************************
 *  Author: Sahil Verma
 *  Created on: 27, January, 2019 8:00 PM
 * ****************************************************************
 */

public class Node<E> {

    public final E data;
    public Node next;

    public Node(final E data) {
        this.data = data;
    }

    public void display() {
        System.out.println("Element :" + this.data);
    }

}
