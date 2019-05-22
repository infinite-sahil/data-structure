package org.somebody.ds.tree;

import org.somebody.ds.tree.domain.TreeNode;

public interface BinarySearchTree {

    /**
     * dupllicate will be have count of duplicate of a particular node
     */
    void insert(int value);

    void traverseInOrder();

    void traversePostOrder();

    TreeNode get(final int value);

    int min();

    int max();

    void delete(int value);

    void levelOrderTraversal();

    void reverseLevelOrderTraversal();

    boolean areMirror(TreeNode first, TreeNode second);
}
