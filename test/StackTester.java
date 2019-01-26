

/* ****************************************************************
 *  Author: Sahil Verma
 *  Created on: 26, January, 2019 4:39 PM
 * ****************************************************************
 */

import org.somebody.ds.stack.ArrayAsStack;
import org.somebody.ds.stack.Stack;

public class StackTester {

    public static void main(String[] args) {
        final Stack<Character> characterStack = new ArrayAsStack(3);

        //Exception in thread "main" org.somebody.ds.stackUsingArray.StackException: ArrayAsStack is Empty!
        // stackUsingArray.peak();

        characterStack.push('A');
        characterStack.push('B');
        characterStack.push('C');
        System.out.println(characterStack);

        Character objectPopped = characterStack.pop();

        characterStack.push('D');
        System.out.println(characterStack);
        System.out.println(characterStack.peek());

        // reverse word 'somebody'
        System.out.println("Reversed work : " + reverseString("somebody"));

    }

    /**
     * Use case: Reverse a string using stack
     */
    public static String reverseString(final String input) {

        final Stack<Character> characterStack = new ArrayAsStack<>(input.length());
        for (char charAtIndex : input.toCharArray())
            characterStack.push(charAtIndex);

        final StringBuilder resultant = new StringBuilder();
        for (int i = 0; i < characterStack.size(); i++)
            resultant.append(characterStack.pop());

        return resultant.toString();
    }

}
