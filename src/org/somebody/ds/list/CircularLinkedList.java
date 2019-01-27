package org.somebody.ds.list;

/* ****************************************************************
 *  Author: Sahil Verma
 *  Created on: 27, January, 2019 8:01 PM
 * ****************************************************************
 */

public class CircularLinkedList<E> implements List<E> {

    private Node head;
    private Node last;

    public CircularLinkedList() {
        head = null;
        last = null;
    }


    @Override
    public void insertAtFront(final E element) {
        final Node newNode = new Node(element);

        if (isEmpty()) {
            last = newNode;
        }
        newNode.next = head; // newNode --> old head
        head = newNode; // make it head
    }

    @Override
    public void insertAtEnd(final E element) {

        final Node newNode = new Node(element);
        if (isEmpty())
            head = newNode;
        else {
            last.next = newNode;
            last = newNode;
        }
    }

    @Override
    public void deleteFromFront() {
        if (isEmpty())
            return;

        // only node in the list
        if (head.next == null)
            last = null;

        head = head.next;
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


    private boolean isEmpty() {
        return head == null;
    }
}
