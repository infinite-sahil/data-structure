package org.somebody.ds.searchalgo;

/* ****************************************************************
 *  Author: Sahil Verma
 *  Created on: 30, January, 2019 9:18 PM
 * ****************************************************************
 */
public class Searcher {

    private Searcher() {
    }

    /**
     * time complexity: o(n)
     *
     * @param elements : store of elements in which search needs to be performed
     * @param searchElement : element to search in the store
     *
     * @return element index of the element if found, else -1
     */
    public static int linearSearch(final int[] elements, final int searchElement) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == searchElement)
                return i;
        }
        return -1;

        // Java8 Way
        /*return Arrays.stream(elements)
                .filter(x -> x == searchElement)
                .findFirst()
                .orElse(-1);*/
    }

    /**
     * Author John Bentley mentions that, only 10% of professional programmer able to implement
     * binary search, they know what it is theoretically but not able to write code perfectly.
     *
     * @param elements : store of 'sorted elements' in which search needs to be performed
     * @param searchElement : element to search in the store
     *
     * @return element index of the element if found, else -1
     */
    public static int binarySearch(final int[] elements, final int searchElement) {
        int low = 0;
        int high = elements.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (searchElement == elements[mid])
                return mid;

            if (searchElement < elements[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }

        return -1;
    }


}
