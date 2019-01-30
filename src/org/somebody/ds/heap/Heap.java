package org.somebody.ds.heap;

/**
 * Its an array implementation of heap.
 */
public class Heap {

    private final Node[] heapArray;
    private final int maxSize;
    // number of nodes in the array
    private int currentSize;

    public Heap(final int maxSize) {
        this.maxSize = maxSize;
        this.currentSize = 0;
        this.heapArray = new Node[maxSize];
    }


    public int getMaxSize() {
        return currentSize;
    }

    public boolean isEmpty() {
        return this.currentSize == 0;
    }

    public boolean insert(final int key) {
        // check array is not full
        if (currentSize == maxSize) {
            return false;
        }

        Node newNode = new Node(key);
        // put it at the bottom of the heap
        heapArray[currentSize] = newNode;

        // this is where most of the magic is happening
        trickleUp(currentSize);

        // increase count of the nodes in the heap
        currentSize++;
        return true;
    }

    private void trickleUp(int index) {
        int parentIdx = (index - 1) / 2;
        Node nodeToInsert = heapArray[index];

        // loop as long as we haven't reached the root of the heap
        // and key of the nodeToInsert parent is less than new node

        while (index > 0 && heapArray[parentIdx].key < nodeToInsert.key) {
            heapArray[index] = heapArray[parentIdx]; // move parent down
            index = parentIdx;
            parentIdx = (parentIdx - 1) / 2; // new parent (parent of parent)
        }

        heapArray[index] = nodeToInsert;
    }

    public void remove(){

    }


    static class Node {

        int key;

        public Node(final int key) {
            this.key = key;
        }
    }

}
