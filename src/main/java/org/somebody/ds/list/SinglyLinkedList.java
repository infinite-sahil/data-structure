package org.somebody.ds.list;

/* ****************************************************************
 *  Author: Sahil Verma
 *  Created on: 27, January, 2019 7:35 PM
 * ****************************************************************
 */

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

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

    public Node findMidElementOfList() {

        Node slow = this.head;
        Node fast = this.head;
        while (fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    public int length(Node current) {
        //base case
        if (current == null) {
            return 0;
        }
        return 1 + length(current.next);
    }

    /**
     * To get the nth node from end of the list Logic: Maintain a counter and increase it by 1. when
     * this counter become greater than input value (n), then start slow node.
     *
     * by this when fast node will reach the end, slow will be at the desired node.
     *
     * @param n * @return nth node from last
     */
    public Optional<Node> getNthNodeFromLast(int n) {
        if (validateInputValue(n)) {
            return Optional.empty();
        }
        Node fast = head;
        Node slow = head;
        int whenToMoveSlowNodeCounter = 1;
        while (fast.next != null) {
            fast = fast.next;
            if ((++whenToMoveSlowNodeCounter) > n) {
                slow = slow.next;
            }
        }
        return Optional.of(slow);
    }


    /* * If singly LinkedList contains Cycle then following would be true
     * 1) slow and fast will point to same node i.e. they meet
     * On the other hand if fast will point to null or next node of
     * fast will point to null then LinkedList does not contains cycle.
     * */
    public boolean detectAndRemoveLoop(boolean doYouWannaRemoveLoop) {
        Node fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            //if fast and slow pointers are meeting then LinkedList is cyclic
            if (fast == slow) {
                if (doYouWannaRemoveLoop) {
                    removeLoop(slow, head);
                }
                return true;
            }
        }
        return false;
    }


    public boolean removeLoopUsingHashing() {

        Node ptr = head, previous = null;
        Set<Integer> nodeHash = new HashSet<>();
        while (ptr != null) {
            int curHash = ptr.hashCode();
            if (nodeHash.contains(curHash)) {
                previous.next = null;
                return true;
            }
            nodeHash.add(curHash);
            previous = ptr;
            ptr = ptr.next;
        }
        return false;
    }

    //@formatter:off
    /**
     * This is the best way to remove a loop Whenever loop is detected:
     *
     * Make Slow --> head
     * Make Fast --> meetPoint (i.e at same location it is)
     *
     * Now move both pointer with same pace.
     */

    //@formatter:on
    private void removeLoop(final Node meetPoint, final Node head) {

        Node ptr1 = head, ptr2 = meetPoint;

        while (ptr1.next != ptr2.next) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        ptr2.next = null;
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

    private boolean validateInputValue(final int n) {
        if (this.head == null) {
            return true;
        }
        if (n > this.length(head)) {
            System.out.println("N is greater than number of elements in the node");
            return true;
        }
        return false;
    }


}
