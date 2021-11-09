/*
Stacks are often used to evaluate expressions in programming languages. Using
net.mindview.icu.trub.util.Stack, evaluate the following expression, where '+' means
"push the following letter onto the stack," and '-' means "pop the top of
the stack and print it": "+U+n+c---+e+r+t---+a-+i-+n+t+y---+ -+r+u--+l+e+s---"
*/

package icu.trub.tij.chapter11_holding;

import java.util.ArrayDeque;
import java.util.Deque;

public class E15_Stack {
    static void evaluate(String string) {
        // Use the standard implementation of Stack instead of the suggested one
        Deque<Character> stack = new ArrayDeque<>();
        char[] charArray = string.toCharArray();
        for (int i = 0; i < charArray.length; ) {
            switch (charArray[i++]) {
                case '+':
                    stack.push(charArray[i]);
                    break;
                case '-':
                    System.out.print(stack.pop());
            }
        }
    }

    public static void main(String[] args) {
        evaluate("+U+n+c---+e+r+t---+a-+i-+n+t+y---+ -+r+u--+l+e+s---");
    }
}
