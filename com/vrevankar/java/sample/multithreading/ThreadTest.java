package com.vrevankar.java.sample.multithreading;

import java.util.Scanner;
import java.util.InputMismatchException;

import java.time.LocalDateTime;
import java.time.Duration;

public class ThreadTest {
  
  public static void main (String arg[]) { 
    Scanner scanner = new Scanner(System.in);
    System.out.print("Please enter the url: ");    
    String url = scanner.next();

    ThreadTest threadTest = new ThreadTest();
    int printCount  = threadTest.getCount("print");
    int threadCount = threadTest.getCount("thread");
    
    LocalDateTime dateTime = LocalDateTime.now();
    System.out.println("\n> fetch_url.sh " + url);
    int totalCount = printCount * threadCount;
    for (int count=0; count<totalCount; ++count){
      ThreadDemo task = new ThreadDemo(String.valueOf(count));
      task.start();
    }

    long duration = Duration.between(dateTime, LocalDateTime.now()).getSeconds();
    System.out.println(
      "total number of request=" + totalCount + ", " +
      "total time spent=" + duration + " seconds, " +
      "number of responses per second=" + duration/totalCount
    );
  }

  private int getCount(String caption) {
    Scanner scanner = new Scanner(System.in);
    while(true){
     try {
        System.out.print("Please enter the " + caption + " count: ");
        scanner = new Scanner(System.in);
        return scanner.nextInt();
      } catch (InputMismatchException exc){
        System.err.println("Invalid Number");
      }
    }    
  }

}

