package com.vrevankar.java.sample;

import java.util.Scanner;

public class FindNums {
  public static void main(String[] args){
    System.out.print("Please enter the string: ");
    String[] nums = new Scanner(System.in).nextLine().replaceAll("[^-?0-9]+", " ").trim().split(" ");
    for(int k=0; k<nums.length; ++k) System.out.println(nums[k]);
  }
}
