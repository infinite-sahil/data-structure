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
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
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

        while (current.leftChild != null)
            current = current.leftChild;

        return Optional.of(current);
    }

    public Optional<Node> findMax() {
        Node current = root;
        if (Objects.isNull(current))
            return Optional.empty();

        while (current.rightChild != null)
            current = current.rightChild;

        return Optional.of(current);
    }

    /**
     * 1. if node is a leaf node  2.        if node has one child 3.        if node has two child
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
                currentNode = currentNode.leftChild;
            } else {
                isLeftChild = false;
                currentNode = currentNode.rightChild;
            }
            // in case, not able to find the key
            if (currentNode == null)
                return false;
        }

        // at this point we found the node
        Node nodeToBeDeleted = currentNode;

        // if node is a leaf node
        if (nodeToBeDeleted.leftChild == null && nodeToBeDeleted.rightChild == null) {
            if (nodeToBeDeleted == root) {
                root = null;
            } else if (isLeftChild) {
                parentNode.leftChild = null;
            } else {
                parentNode.rightChild = null;
            }
        }
        // if node has one child that is on the left
        else if (nodeToBeDeleted.rightChild == null) {
            if (nodeToBeDeleted == root) {
                root = nodeToBeDeleted.leftChild;
            } else if (isLeftChild) {
                parentNode.leftChild = nodeToBeDeleted.leftChild;
            } else {
                parentNode.rightChild = nodeToBeDeleted.leftChild;
            }
        }
        // if node has one child that is on the right
        else if (nodeToBeDeleted.leftChild == null) {
            if (nodeToBeDeleted == root) {
                root = nodeToBeDeleted.rightChild;
            } else if (isLeftChild) {
                parentNode.leftChild = nodeToBeDeleted.rightChild;
            } else {
                parentNode.rightChild = nodeToBeDeleted.rightChild;
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
                parentNode.leftChild = successor;
            } else {
                parentNode.rightChild = successor;
            }

            successor.leftChild = nodeToBeDeleted.leftChild;
        }

        return true;
    }

    // logic to get successor is: nodeToBeDeleted -->right ------> left-most
    private Node getSuccessorOf(final Node nodeToBeDeleted) {
        Node successorParent = nodeToBeDeleted;
        Node successor = nodeToBeDeleted;

        // go to the right child
        Node current = successor.rightChild;

        // start going left down the tree until node has no left child
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        // if successor is not a right child
        if (successor != nodeToBeDeleted.rightChild) {
            // plug right child of the successor to the left child of successor parent
            successorParent.leftChild = successor.rightChild;
            // plug right child of the node to be deleted inside the successor right
            successor.rightChild = nodeToBeDeleted.rightChild;
        }

        return successorParent;
    }


    /**
     * LEFT --> ROOT --> RIGHT traverse the binary tree on InOrder traversal algorithm
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(final Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.leftChild);
        System.out.printf("%s ", node.getKey());
        inOrder(node.rightChild);
    }

    /**
     * ROOT --> LEFT --> RIGHT Java method to print tree nodes in PreOrder traversal
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(final Node node) {
        if (node == null) {
            return;
        }
        System.out.printf("%s ", node.getKey());
        preOrder(node.leftChild);
        preOrder(node.rightChild);
    }


    /**
     * LEFT --> RIGHT --> ROOT traverse the binary tree on postOrder traversal algorithm
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(final Node currRoot) {
        if (currRoot == null) {
            return;
        }
        postOrder(currRoot.leftChild);
        postOrder(currRoot.rightChild);
        System.out.printf("%s ", currRoot.getKey());
    }

    public static void printLeafNodes(final Node node) {
        // base condition
        if (node == null) {
            return;
        }
        if (node.leftChild == null && node.rightChild == null) {
            System.out.printf("%d ", node.getKey());
        }
        printLeafNodes(node.leftChild);
        printLeafNodes(node.rightChild);
    }

    static class Node {

        private final int key;
        final String value;
        Node leftChild;
        Node rightChild;

        public Node(final int key, final String value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }
    }

}
