package org.somebody.ds.list;

/* ****************************************************************
 *  Author: Sahil Verma
 *  Created on: 27, January, 2019 7:35 PM
 * ****************************************************************
 */

public class SinglyLinkedList<E> implements List<E> {

    private Node head;

    public SinglyLinkedList() {
    }

    @Override
    public void insertAtFront(final E element) {
        final Node newNode = new Node(element);
        newNode.next = head;
        head = newNode;
    }

    @Override
    public void insertAtEnd(final E element) {
        Node curNode = this.head;
        while (curNode.next != null)
            curNode = curNode.next;

        final Node newNode = new Node(element);
        curNode.next = newNode;
    }

    @Override
    public void deleteFromFront() {
        if (isEmpty())
            return;

        head = this.head.next;
        //todo nullify deleted object to avail for GC
    }

    @Override
    public void display() {
        System.out.println("* *************** displaying ***************** *");
        Node currentNode = this.head;
        while (currentNode != null) {
            currentNode.display();
            currentNode = currentNode.next;
        }
        System.out.println("* ******************************************** *");
    }

    public void reverse() {
        Node currentNode = null;
        Node previousNode = null;


    }

    private boolean isEmpty() {
        return (head == null);
    }


}
