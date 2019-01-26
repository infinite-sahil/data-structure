

/* ****************************************************************
 *  Author: Sahil Verma
 *  Created on: 26, January, 2019 8:41 PM
 * ****************************************************************
 */

import org.somebody.ds.queue.ArrayAsQueue;
import org.somebody.ds.queue.Queue;

public class QueueTester {

    public static void main(String[] args) {

        Queue<Integer> queue = new ArrayAsQueue<>(3);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        // will not throw exception, just 4 will not be added
        queue.offer(4);
        System.out.println(queue);
        //queue.insert(4);

        System.out.println(queue);
    }

}
