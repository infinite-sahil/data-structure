package org.somebody.ds.stack;

/* ****************************************************************
 *  Author: Sahil Verma
 *  Created on: 26, January, 2019 5:52 PM
 * ****************************************************************
 */

public class StackException extends RuntimeException {

    static class EmptyStackException extends RuntimeException {

        public EmptyStackException(String errorMessage) {
            super(errorMessage);
        }
    }

    static class StackOutOfBoundException extends RuntimeException {

        public StackOutOfBoundException(String errorMessage) {
            super(errorMessage);
        }
    }

}
