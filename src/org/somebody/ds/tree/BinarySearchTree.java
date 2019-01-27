package org.somebody.ds.tree;

/* ****************************************************************
 *  Author: Sahil Verma
 *  Created on: 27, January, 2019 9:49 PM
 * ****************************************************************
 */

import java.util.Objects;
import java.util.Optional;

public class BinarySearchTree {

    private Node root;


    public void insert(final int key, final String value) {

        final Node newNode = new Node(key, value);

        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;

            while (true) {
                parent = current;
                if (key < current.getKey()) {
                    current = current.getLeftChild();
                    if (current == null) {
                        parent.setLeftChild(newNode);
                        return;
                    }
                } else {
                    current = current.getRightChild();
                    if (current == null) {
                        parent.setRightChild(newNode);
                        return;
                    }
                }
            }
        }
    }

    public Optional<Node> findMin() {
        Node current = root;
        if (Objects.isNull(current))
            return Optional.empty();

        while (current.getLeftChild() != null)
            current = current.getLeftChild();

        return Optional.of(current);
    }

    public Optional<Node> findMax() {
        Node current = root;
        if (Objects.isNull(current))
            return Optional.empty();

        while (current.getRightChild() != null)
            current = current.getRightChild();

        return Optional.of(current);
    }

    // TODO: WIP

    /**
     * 1. if node is a leaf node  2.        if node has one child 3.        if node has two child
     */
    public boolean remove(final int key) {

        Node currentNode = root;
        Node parentNode = root;

        boolean isLeftChild = false;

        //search the key - node
        while (currentNode.getKey() != key) {
            parentNode = currentNode;
            if (key < currentNode.getKey()) {
                isLeftChild = true;
                currentNode = currentNode.getLeftChild();
            } else {
                currentNode = currentNode.getRightChild();
                isLeftChild = false;
            }

            // in case not able to find the required node
            if (currentNode == null)
                return false;
        }

        // at this point we found the node
        Node nodeToDelete = currentNode;

        // if node is a leaf node
        if (nodeToDelete.getLeftChild() == null && nodeToDelete.getRightChild() == null) {
            if (nodeToDelete == root)
                root = null;
            else if (isLeftChild)
                parentNode.setLeftChild(null);
            else
                parentNode.setRightChild(null);

            return true;
        }
        // if node has one child that is on the left
        else if (nodeToDelete.getRightChild() == null) {
            if (nodeToDelete == root) {
                root = nodeToDelete.getLeftChild();
            } else if (isLeftChild) {
                parentNode.setLeftChild(nodeToDelete.getLeftChild());
            } else {
                parentNode.setRightChild(nodeToDelete.getLeftChild());
            }
        }
        // if node has one child that is on the left
        else if (nodeToDelete.getLeftChild() == null) {
            if (nodeToDelete == root) {
                root = nodeToDelete.getRightChild();
            } else if (isLeftChild) {
                parentNode.setLeftChild(nodeToDelete.getRightChild());
            } else {
                parentNode.setRightChild(nodeToDelete.getRightChild());
            }
        }

        // if node has two child

        return true;
    }

}
