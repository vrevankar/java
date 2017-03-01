package com.vrevankar.java.sample.multithreading;

import java.time.LocalDateTime;
import java.time.Duration;

public class ThreadDemo extends Thread { 

  public ThreadDemo(String seq) { 
    super(seq);
  }

  public void run() { 
    LocalDateTime dateTime = LocalDateTime.now();
    System.out.println("request" + getName() +"/thread" + getName() + ",HTTP 200 " + Duration.between(dateTime, LocalDateTime.now()).toMillis());
  } 

}

