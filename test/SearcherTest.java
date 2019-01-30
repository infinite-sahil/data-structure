

/* ****************************************************************
 *  Author: Sahil Verma
 *  Created on: 30, January, 2019 9:31 PM
 * ****************************************************************
 */

import org.somebody.ds.searchalgo.Searcher;

public class SearcherTest {

    public static void main(String[] args) {
        // Linear search
        int[] linearSearchInput = new int[]{1, 2, 5, 6, 9, 10, 24, 16};
        System.out.println("Using Linear Search - Element found at index: "
                + Searcher.linearSearch(linearSearchInput, 9));

        // Binary Search
        int[] arr = new int[]{10, 11, 15, 34, 56, 76, 87, 98};
        System.out.println("Using Binary Search - Element found at index: "
                + Searcher.binarySearch(arr, 98));

        System.out.println("Using recursive Binary Search - Element found at index: "
                + Searcher.recursiveBinarySearch(arr, 11));

    }

}
