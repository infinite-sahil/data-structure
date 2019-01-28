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
     * 1. if node is a leaf node 2.        if node has one child 3.        if node has two child
     */
    public boolean remove(final int key) {

        Node currentNode = root;
        Node parentNode = root;

        boolean isLeftChild = false;

        //search the find the node with the key to delete
        while (currentNode.getKey() != key) {
            parentNode = currentNode;
            if (key < currentNode.getKey()) {
                isLeftChild = true;
                currentNode = currentNode.getLeftChild();
            } else {
                isLeftChild = false;
                currentNode = currentNode.getRightChild();
            }
            // in case, not able to find the key
            if (currentNode == null)
                return false;
        }

        // at this point we found the node
        Node nodeToBeDeleted = currentNode;

        // if node is a leaf node
        if (nodeToBeDeleted.getLeftChild() == null && nodeToBeDeleted.getRightChild() == null) {
            if (nodeToBeDeleted == root) {
                root = null;
            } else if (isLeftChild) {
                parentNode.setLeftChild(null);
            } else {
                parentNode.setRightChild(null);
            }
        }
        // if node has one child that is on the left
        else if (nodeToBeDeleted.getRightChild() == null) {
            if (nodeToBeDeleted == root) {
                root = nodeToBeDeleted.getLeftChild();
            } else if (isLeftChild) {
                parentNode.setLeftChild(nodeToBeDeleted.getLeftChild());
            } else {
                parentNode.setRightChild(nodeToBeDeleted.getLeftChild());
            }
        }
        
        // if node has one child that is on the right
        else if (nodeToBeDeleted.getLeftChild() == null) {
            if (nodeToBeDeleted == root) {
                root = nodeToBeDeleted.getRightChild();
            } else if (isLeftChild) {
                parentNode.setLeftChild(nodeToBeDeleted.getRightChild());
            } else {
                parentNode.setRightChild(nodeToBeDeleted.getRightChild());
            }
        }
        // if node has two child (tricky)
        // get the minimum node of the right sub tree and put it in the place of deleted node
        else {
            Node successor = getSuccessorOf(nodeToBeDeleted);

            // connect parent of the node to delete with successor
            if (nodeToBeDeleted == root) {
                root = successor;
            } else if (isLeftChild) {
                parentNode.setLeftChild(successor);
            } else {
                parentNode.setRightChild(successor);
            }

            successor.setLeftChild(nodeToBeDeleted.getLeftChild());
        }

        return true;
    }

    // logic to get successor is: nodeToBeDeleted -->right ------> left-most
    private Node getSuccessorOf(final Node nodeToBeDeleted) {
        Node successorParent = nodeToBeDeleted;
        Node successor = nodeToBeDeleted;

        // go to the right child
        Node current = successor.getRightChild();

        // start going left down the tree until node has no left child
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }
        // if successor is not a right child
        if (successor != nodeToBeDeleted.getRightChild()) {
            // plug right child of the successor to the left child of successor parent
            successorParent.setLeftChild(successor.getRightChild());
            // plug right child of the node to be deleted inside the successor right
            successor.setRightChild(nodeToBeDeleted.getRightChild());
        }

        return successorParent;
    }

}
