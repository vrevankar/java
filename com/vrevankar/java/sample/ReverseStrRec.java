// reverse a String using recursion
package com.vrevankar.java.sample;

import java.util.Scanner;

public class ReverseStrRec {
  public static void main (String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.print("Please enter the String: ");
    System.out.println("Reverse String: " + new ReverseStrRec().reverseStr(scanner.nextLine()));
  }

  public String reverseStr(String str) {
    if (str.length() == 0) return str;
    return reverseStr(str.substring(1)) + str.charAt(0);
  }

}
