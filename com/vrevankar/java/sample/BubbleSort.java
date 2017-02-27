package com.vrevankar.java.sample;

public class BubbleSort {  
  private void bubbleSort(int[] arr) {  
    int n = arr.length;  
    int temp = 0;  
    for(int i=0; i < n; i++){  
      for(int j=1; j < (n-i); j++){  
        if(arr[j-1] > arr[j]){  
          temp = arr[j-1];  
          arr[j-1] = arr[j];  
          arr[j] = temp;  
        }  
      }  
    }  
  }  

  private void printArr(String caption, int[] arr){
    System.out.println(caption);
    for(int i=0; i < arr.length-1; i++) System.out.print(arr[i] + ", ");
    System.out.println(arr[arr.length-1]);
  }
   
  public static void main(String[] args) {  
    int arr[] = {3, 60, 35, 2, 45, 320, 5};  
    BubbleSort bubbleSort = new BubbleSort();
    bubbleSort.printArr("Original Array", arr);              
    bubbleSort.bubbleSort(arr);
    bubbleSort.printArr("Sorted Array", arr);              
    
  }
  
}

