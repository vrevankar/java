/*
 * Kth Largest element
 * Time Complexity: O(nlog(k)); Space Complexity: O(k)
 */

package com.vrevankar.java.sample;

import java.util.Scanner;
import java.util.PriorityQueue;

public class KthLargest {

  public static void main(String[] args) {
    int[] nums = {8, 3, 8, 18, 8, 16, 43, 29, 16, 22, 44};
    System.out.print("Please enter the factor: ");
    int factor = new Scanner(System.in).nextInt();
    System.out.println(factor + "th largest: " + new KthLargest().findKthLargest(nums, factor));
  }

  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
    for(int i: nums){
      q.offer(i);
      if(q.size() > k){
        q.poll();
      }
    }
    return q.peek();
  }
}
