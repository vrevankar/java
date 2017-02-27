// reverse a String

package com.vrevankar.java.sample;

import java.util.Scanner;

public class ReverseStr {

  public static void main (String args[]){
    Scanner scanner = new Scanner(System.in);
    /*
    if(args.length == 0){
      return;
    }
    */
    System.out.print("Please enter the String: ");
    System.out.println(new ReverseStr().reverse(scanner.nextLine()));
  }

  private String reverse(String str){
    char[] chArr = str.toCharArray();
    char tmp;
    for(int begin=0, end=chArr.length-1; end>begin; begin++, end--){
      tmp = chArr[begin];
      chArr[begin]=chArr[end];
      chArr[end] = tmp;
    }
    return String.valueOf(chArr);
  }

}

