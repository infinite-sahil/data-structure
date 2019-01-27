package org.somebody.ds.tree;

/* ****************************************************************
 *  Author: Sahil Verma
 *  Created on: 27, January, 2019 9:47 PM
 * ****************************************************************
 */

public class Node {

    private final int key;
    private final String value;
    private Node leftChild, rightChild;

    public Node(final int key, final String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setLeftChild(final Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(final Node rightChild) {
        this.rightChild = rightChild;
    }
}
