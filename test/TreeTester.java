

/* ****************************************************************
 *  Author: Sahil Verma
 *  Created on: 27, January, 2019 11:01 PM
 * ****************************************************************
 */

import org.somebody.ds.tree.another.BinarySearchTree;

public class TreeTester {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10, "TEN");
        bst.insert(20, "FIFTEEN");
        bst.insert(21, "TWELVE");
        bst.insert(22, "TWENTY-TWO");

        bst.inOrder();

        //   bst.findMin().ifPresent((x) -> System.out.println("MIN: " + x.getKey()));
        //  bst.findMax().ifPresent((x) -> System.out.println("MAX: " + x.getKey()));

    }

}
