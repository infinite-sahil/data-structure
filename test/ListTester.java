

/* ****************************************************************
 *  Author: Sahil Verma
 *  Created on: 27, January, 2019 7:45 PM
 * ****************************************************************
 */

import org.somebody.ds.list.SinglyLinkedList;

public class ListTester {

    public static void main(String[] args) {

        final SinglyLinkedList<Character> linkedList = new SinglyLinkedList();
        linkedList.insertAtFront('D');
        linkedList.insertAtFront('C');
        linkedList.insertAtFront('B');
        linkedList.insertAtFront('A');

        linkedList.display();
        //linkedList.reverseMe();
        System.out.println(linkedList.getNthNodeFromLast(10));
        linkedList.display();

     /*   linkedList.deleteFromFront();
        linkedList.insertAtFront('X');
        linkedList.insertAtEnd('Z');
        linkedList.display();*/

    }


}
