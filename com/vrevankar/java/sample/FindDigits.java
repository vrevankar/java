// Find digits in a string

package com.vrevankar.java.sample;

import java.util.regex.*;
import java.util.Scanner;

public class FindDigits {
  public static void main(String[] args) {
    Pattern pattern = Pattern.compile("([0-9])");
    System.out.print("Please enter the string: ");
    Matcher matcher = pattern.matcher(new Scanner(System.in).nextLine());
    while (matcher.find()) System.out.println(matcher.group(1));
  }
}

