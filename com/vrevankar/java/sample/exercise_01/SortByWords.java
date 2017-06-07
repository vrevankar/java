package com.vrevankar.java.sample.exercise_01;

import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by vinay on 6/6/17.
 */
public class SortByWords {

    public static void main(String... args) {
        System.out.print("Please enter the words: ");
        String words = new Scanner(System.in).nextLine();
        Set<String> mySet = new TreeSet<>();
        Collections.addAll(mySet, words.split(" "));
        System.out.println("Output: ");
        for(String word : mySet) System.out.print(word + " ");
        System.out.println();
    }

}
