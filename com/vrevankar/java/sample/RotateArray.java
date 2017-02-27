/*
 * Rotate an array
 */

package com.vrevankar.java.sample;

import java.util.Scanner;

public class RotateArray {

  public static void main(String[] args) {
    int[] nums = {9, 2, 6, 4, 12, 19, 11, 21, 18};
    RotateArray rotateArr = new RotateArray();
    rotateArr.printArr("Original Array", nums);
    System.out.print("Please enter the factor: ");
    rotateArr.printArr("Rotated Array", rotateArr.rotate(nums, new Scanner(System.in).nextInt()));
  }

  private int[] rotate(int[] nums, int factor) {	
    if (nums == null || nums.length==0 || factor < 0) throw new IllegalArgumentException("Illegal argument!");
    if(factor > nums.length) factor = factor%nums.length;
 
    // length of first part
    int part1Len = nums.length-factor; 
 
    reverse(nums, 0, part1Len-1);
    reverse(nums, part1Len, nums.length-1);
    return reverse(nums, 0, nums.length-1);
 
  }
 
  private int[] reverse(int[] nums, int left, int right){
    while(left < right){
      nums[left]  += nums[right];
      nums[right] = nums[left] - nums[right];
      nums[left++]  -= nums[right--];
    }
    return nums;
  }

  private void printArr(String caption, int[] nums){
    System.out.print(caption + ": ");
    for(int k=0; k<nums.length-1; ++k) System.out.print(nums[k] + ", ");
    System.out.println(nums[nums.length-1]);
  }

}
