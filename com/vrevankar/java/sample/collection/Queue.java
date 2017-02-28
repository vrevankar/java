package com.vrevankar.java.sample.collection;

import java.util.Stack;
import java.util.NoSuchElementException;

public class Queue<T> {

  Stack<Object> tmp   = new Stack<>();
  Stack<Object> queue = new Stack<>();

  public void add(Object obj) {
    if(queue.isEmpty()) queue.push(obj);
    else {
      while(!queue.isEmpty()) tmp.push(queue.pop());
      queue.push(obj);
      while(!tmp.isEmpty())  queue.push(tmp.pop());
    }
  }

  public Object remove() throws NoSuchElementException {
    if(queue.isEmpty()) throw new NoSuchElementException();
    return queue.pop();
  }

  public Object poll() {
    return !queue.isEmpty() ? queue.pop() : null;
  }

  public Object peek() {
    return !queue.isEmpty() ? queue.peek() : null;
  }

  public Object element() throws NoSuchElementException {
    if(queue.isEmpty()) throw new NoSuchElementException();
    return queue.peek();
  }

  public boolean isEmpty() {
    return queue.isEmpty();
  }

  public int size(){
    return queue.size();
  }

}

