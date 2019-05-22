package org.somebody.ds.tree.domain;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeNode {

    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;
    // used to keep in case duplicate node
    private int count;


    public TreeNode(final int data) {
        this.data = data;
    }

    public void insert(int value) {
        if (value == data) {
            count++;
            return;
        }
        if (value < data) {
            if (leftChild == null) {
                leftChild = new TreeNode(value);
            } else {
                leftChild.insert(value);
            }
        } else {
            if (rightChild == null) {
                rightChild = new TreeNode(value);
            } else {
                rightChild.insert(value);
            }
        }
    }

    public void traverseInOrder() {
        if (leftChild != null) {
            leftChild.traverseInOrder();
        }
        System.out.println("Data : " + data + " ,");

        if (rightChild != null) {
            rightChild.traverseInOrder();
        }
    }

    public void traversePostOrder() {
        if (leftChild != null) {
            leftChild.traversePostOrder();
        }
        if (rightChild != null) {
            rightChild.traversePostOrder();
        }
        System.out.println("Data : " + data + " ,");
    }

    public void traversePreOrder() {
        System.out.println("Data : " + data + " ,");
        if (leftChild != null) {
            leftChild.traversePostOrder();
        }
        if (rightChild != null) {
            rightChild.traversePostOrder();
        }
    }

    public void levelOrderTraversal() {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this);

        while (!queue.isEmpty()) {
            TreeNode tempTreeNode = queue.poll();
            System.out.printf("%d ", tempTreeNode.getData());
            if (tempTreeNode.leftChild != null) {
                queue.add(tempTreeNode.leftChild);
            }
            if (tempTreeNode.rightChild != null) {
                queue.add(tempTreeNode.rightChild);
            }
        }
    }

    public void reverseLevelOrderTraversal(TreeNode startTreeNode) {
        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(startTreeNode);

        while (!queue.isEmpty()) {
            TreeNode tempTreeNode = queue.poll();
            stack.push(tempTreeNode);
            if (tempTreeNode.rightChild != null) {
                queue.add(tempTreeNode.rightChild);
            }
            if (tempTreeNode.leftChild != null) {
                queue.add(tempTreeNode.leftChild);
            }
            while (!stack.isEmpty()) {
                final TreeNode poppedNode = stack.pop();
                System.out.println(poppedNode.getData() + ", ");
            }
        }

        while (!stack.isEmpty()) {
            final TreeNode poppedNode = stack.pop();
            System.out.println(poppedNode.getData());
        }
    }


    public TreeNode get(final int value) {
        if (value == data) {
            return this;
        }

        if (value < data) {
            if (leftChild != null) {
                return leftChild.get(value);
            }
        } else {
            if (rightChild != null) {
                return rightChild.get(value);
            }
        }

        return null;
    }

    public int min() {
        if (leftChild == null) {
            return this.getData();
        } else {
            return leftChild.min();
        }
    }

    public int max() {
        if (rightChild == null) {
            return this.getData();
        } else {
            return rightChild.max();
        }
    }



    /* *********** Helper Methods *********************** */

    public int getData() {
        return data;
    }

    public void setData(final int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(final TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(final TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public int getCount() {
        return count;
    }

    public void setCount(final int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                '}';
    }
}
