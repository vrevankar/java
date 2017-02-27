// Singleton using synchronization

package com.vrevankar.java.sample.pattern;

import java.io.Serializable;

public class Singleton implements Serializable {

  private static final long serialVersionUID = -7604766932017737115L;
  
  private Singleton(){ }

    private static class SingletonHelper {
      private static final Singleton INSTANCE = new Singleton();
    }
    
    public static Singleton getInstance(){
      return SingletonHelper.INSTANCE;
    }

    // To make sure multiple instances of the Singleton class have same hashcode
    protected Object readResolve() {
      return getInstance();
    }

}

