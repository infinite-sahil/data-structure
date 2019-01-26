package org.somebody.ds.queue;

/* ****************************************************************
 *  Author: Sahil Verma
 *  Created on: 26, January, 2019 5:52 PM
 * ****************************************************************
 */

public class QueueException extends RuntimeException {

    static class EmptyQueueException extends RuntimeException {

        public EmptyQueueException(String errorMessage) {
            super(errorMessage);
        }
    }

    static class QueueOutOfBoundException extends RuntimeException {

        public QueueOutOfBoundException(String errorMessage) {
            super(errorMessage);
        }
    }

}
