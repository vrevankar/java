package com.vrevankar.java.sample.multithreading.printUrl;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.time.LocalDateTime;
import java.time.Duration;
import java.lang.InterruptedException;
import java.util.concurrent.ExecutionException;
import com.vrevankar.java.sample.multithreading.printUrl.PrintUrl;

public class PrintUrlTest {
  
  public static void main (String args[]) throws InterruptedException, ExecutionException { 
    PrintUrl.url = args[0];
    LocalDateTime dateTimeAna = LocalDateTime.now();
    System.out.println("\n> fetch_url.sh " + args[0]);
    int reqCount = Integer.parseInt(args[1]);
    int trdCount = Integer.parseInt(args[2]);
    PrintUrlTest urlTest = new PrintUrlTest();
    
    ExecutorService pool = Executors.newFixedThreadPool(2147483647);
    LocalDateTime dateTimeResp = LocalDateTime.now();
    Callable<Integer> callable = new PrintUrl();
    Future<Integer> future = pool.submit(callable);
    for(int req=1; req<=reqCount; ++req){
      for(int trd=1; trd<=trdCount; ++trd){
        dateTimeResp = LocalDateTime.now();
	urlTest.printResponse(req, trd, (Integer) pool.submit(new PrintUrl()).get(), dateTimeResp);
      }
    }
    pool.shutdown();
    urlTest.printAnalysis(dateTimeAna, reqCount, trdCount);
  }

  private void printResponse(int req, int trd, int respCode, LocalDateTime dateTime){
    System.out.println(
      "request" + req +
      "/thread" + trd +
      ", HTTP " + respCode +
      ", " + Duration.between(dateTime, LocalDateTime.now()).toMillis() + " milliseconds"
    );
  }

  private void printAnalysis(LocalDateTime dateTime, long reqCount, long trdCount) {
    long duration = Duration.between(dateTime, LocalDateTime.now()).getSeconds();
    long count = reqCount * trdCount;
    System.out.print(
      "total number of request=" + count + ", " +
      "total time spent=" + duration + " seconds, " +
      "number of responses per second=" + duration/count + " (");
    System.out.printf("%.8f", (float) duration/count);
    System.out.println(")");
  }

}
