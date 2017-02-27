package com.vrevankar.java.sample;

import java.util.regex.*;
import java.util.Scanner;

public class StringSum {
    public static void main(String[] args) {
        int sum = 0;
        // Pattern pattern = Pattern.compile("([0-468])"); // 0,1,2,3,4,6,8
        // Pattern pattern = Pattern.compile("([02468])"); // Even numbers
        Pattern pattern = Pattern.compile("([0-9])");      // All Digits
        System.out.print("Please enter the string: ");
        Matcher matcher = pattern.matcher(new Scanner(System.in).nextLine());
        while (matcher.find()) sum += Integer.parseInt(matcher.group(1));
        System.out.println("SUM: " + sum);
    }
}

