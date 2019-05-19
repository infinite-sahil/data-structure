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
        while (curNode.next != null) {
            curNode = curNode.next;
        }

        final Node newNode = new Node(element);
        curNode.next = newNode;
    }

    @Override
    public void deleteFromFront() {
        if (isEmpty()) {
            return;
        }

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
        Node current = head;
        Node previous = null;
        Node next = null;
        while (current != null) {
            // 1.  get the next of the current
            next = current.next;
            // 2. change the pointer of current to previous
            current.next = previous;
            // 3. make current as previous
            previous = current;
            // 4. make next as current
            current = next;
        }
        // make the last node whose next is null as head (i.e previous)
        head = previous;
    }

    public void reverseMe() {
        // curNode -> head and previous node in the start is null
        recursiveReverse(head, null);
    }

    private Node recursiveReverse(Node curNode, Node previousNode) {
        final Node nextNode = curNode.next;
        /* Base condition: If its last node --> mark it as head */
        if (nextNode == null) {
            // link it to previous
            curNode.next = previousNode;
            return (head = curNode);
        }
        curNode.next = previousNode;
        recursiveReverse(nextNode, curNode);
        return head;
    }


    public int length(Node current) {
        //base case
        if (current == null) {
            return 0;
        }
        return 1 + length(current.next);
    }

    /**
     * to get the nth node from end
     *
     * @param n * @return nth node from last
     */
    public Node getLastNode(int n) {
        Node fast = head;
        Node slow = head;
        int start = 1;
        while (fast.next != null) {
            fast = fast.next;
            start++;
            if (start > n) {
                slow = slow.next;
            }
        }

        return slow;
    }

    /**
     * returns the last node or tail of this linked list
     *
     * @return last node
     */
    public Node tail() {
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        return tail;
    }

    private boolean isEmpty() {
        return (head == null);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current).append("-->");
            current = current.next;
        }
        if (sb.length() >= 3) {
            sb.delete(sb.length() - 3, sb.length());
        }
        return sb.toString();
    }

}
