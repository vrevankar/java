package com.vrevankar.java.sample.multithreading.printUrl;

import java.util.concurrent.Callable;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class PrintUrl implements Callable { 

  public static String url;

  @Override
  public Integer call() { 
    URL url;
    HttpURLConnection http;
    BufferedReader br = null;
    try {
      url  = new URL(PrintUrl.url);
      http = (HttpURLConnection)url.openConnection();
      br = new BufferedReader(new InputStreamReader(http.getInputStream()));
      while (br.readLine() != null);
      return http.getResponseCode();
    } catch (MalformedURLException malformedUrlEx){
       try {
         url = new URL(PrintUrl.url);
         http = (HttpURLConnection) url.openConnection();
         return http.getResponseCode();
       } catch(Exception ex) { 
         System.err.println(ex.getMessage());
       }
    } catch (IOException ioEx){
      System.err.println(ioEx.getMessage());
    } finally {
      try {
      	if (br != null) br.close();
      } catch(IOException ioEx){
        System.err.println(ioEx.getMessage());
      }
    }
    return 0;
  } 

}

