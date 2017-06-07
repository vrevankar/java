package com.vrevankar.java.sample.exercise_01;

import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Vinay on 6/6/17.
 */
public class SortByWords {

    public static void main(String... args) {
    	System.out.println("Input: ");
        Set<String> words = new TreeSet<>();
        Collections.addAll(words, new Scanner(System.in).nextLine().split(" "));
        System.out.println("Output: ");
        for(String word : words) System.out.print(word + " ");
	System.out.println();
    }

}
