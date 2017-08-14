package com.vrevankar.java.sample.exercise_02;

import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Vinay on 8/4/17.
 */
public class LetterCount {

    public static void main(String... args){
        System.out.println(countOccurrences("Hare Krishna Hare Rama", 'a'));
        System.out.println(count("Hare Krishna Hare Rama", 'a', 0));
    }

    public static int countOccurrences(String inputStr, char needle) {
        int count = 0;
        for (int i=0; i<inputStr.length(); ++i) {
            if (inputStr.charAt(i) == needle) ++count;
        }
        return count;
    }

    public static int count(String line, char c, int pos) {
        if (pos >= line.length()) return 0;
        return compare(line.charAt(pos), c) + count(line, c, pos+1);
    }

    public static int compare(char a, char b){
        return a == b ? 1 : 0;
    }


}
