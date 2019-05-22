package org.somebody.ds.tree.impl;


import org.somebody.ds.tree.BinarySearchTree;
import org.somebody.ds.tree.domain.TreeNode;

// this uses recursion to implement BST
public class RecursiveBST implements BinarySearchTree {

    private TreeNode root;

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            root.insert(value);
        }
    }

    public void traverseInOrder() {
        if (root != null) {
            root.traverseInOrder();
        }
    }

    public void traversePostOrder() {
        if (root != null) {
            root.traversePostOrder();
        }
    }

    public void traversePreOrder() {
        if (root != null) {
            root.traversePreOrder();
        }
    }

    public TreeNode get(final int value) {
        if (root != null) {
            final TreeNode treeNode = root.get(value);
            if (treeNode == null) {
                System.out.println("Node with value: " + value + " not found in the tree!");
            }
            return treeNode;
        }
        System.out.println("Root of the tree found null");
        return null;
    }

    public int min() {
        if (root != null) {
            return root.min();
        }
        return Integer.MIN_VALUE;
    }

    @Override
    public int max() {
        if (root != null) {
            return root.max();
        }
        return Integer.MAX_VALUE;
    }

    @Override
    public void delete(final int value) {
        root = delete(root, value);
    }

    @Override
    public void levelOrderTraversal() {
        if (root != null)
            root.levelOrderTraversal();
    }

    @Override
    public void reverseLevelOrderTraversal() {
        if (root != null)
            root.reverseLevelOrderTraversal(root);
    }

    @Override
    public boolean areMirror(TreeNode first, TreeNode second) {
        /* Base case : Both empty */
        if (first == null && second == null)
            return true;
        // If only one is empty
        if (first == null || second == null)
            return false;

        /* Both non-empty, compare them recursively
           Note that in recursive calls, we pass left
           of one tree and right of other tree */
        return first.getData() == second.getData()
                && areMirror(first.getLeftChild(), second.getRightChild())
                && areMirror(first.getRightChild(), second.getLeftChild());

    }


    /**
     * This function is returning the replacement node
     */
    private TreeNode delete(final TreeNode subTreeRoot, final int value) {
        if (subTreeRoot == null)
            return subTreeRoot;
        if (value < subTreeRoot.getData())
            delete(subTreeRoot.getLeftChild(), value);
        else if (value > subTreeRoot.getData())
            subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(), value));
        else {
            // value match the node to delete
            // case : node to delete has 0 or 1 child
            if (subTreeRoot.getLeftChild() == null)
                return subTreeRoot.getRightChild();
            else if (subTreeRoot.getRightChild() == null)
                return subTreeRoot.getLeftChild();

            // case: node to delete has 2 children
            // replace the value in the subTreeNode with the minimum value from the right subTree
            subTreeRoot.setData(subTreeRoot.getRightChild().min());
            // delete the node that has the smallest value in the right subtree
            subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(), subTreeRoot.getData()));
        }
        return subTreeRoot;
    }


    public static void main(String[] args) {
        RecursiveBST recursiveBST = new RecursiveBST();
        recursiveBST.insert(12);
        recursiveBST.insert(89);
        recursiveBST.insert(90);
        recursiveBST.insert(23);
        recursiveBST.insert(14);
        recursiveBST.insert(11);
        recursiveBST.insert(9);
        recursiveBST.insert(5);

        System.out.println(recursiveBST.min());
        System.out.println(recursiveBST.max());
        recursiveBST.reverseLevelOrderTraversal();

    }

}
