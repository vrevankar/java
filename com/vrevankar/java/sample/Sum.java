package com.vrevankar.java.sample;

import java.util.Scanner;

public class Sum {
  public static void main(String[] args){
    int sum = 0;
    System.out.print("Please enter the string: ");
    String[] nums = new Scanner(System.in).nextLine().replaceAll("[^-?0-9]+", " ").trim().split(" ");
    for(int k=0; k<nums.length; ++k) sum += Integer.parseInt(nums[k]);
    System.out.println("SUM: " + sum);
  }
}
