package com.vrevankar.java.sample.exercise_02;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeSet;

/**
 * Created by Vinay on 8/4/17.
 */
public class SortStack {

    public static void main(String[] args) {
        int[] data = {5, 2, 1, 9, 0, 10};
        Stack<Integer> myStack = new Stack<>();
        for (int i = 0; i < data.length; i++) {
            myStack.push(data[i]);
        }
        System.out.println(sortstk(myStack));
    }

    public static Stack<Integer> sortstk(Stack<Integer> inputStack) {
        Stack<Integer> sortedStack = new Stack<>();
        while(!inputStack.isEmpty()) {
            int min = inputStack.pop();
            while(!sortedStack.isEmpty() && (sortedStack.peek() > min)) inputStack.push(sortedStack.pop());
            sortedStack.push(min);
        }
        return sortedStack;
    }

}
