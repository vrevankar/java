package com.vrevankar.java.sample.exercise_01;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Vinay on 6/6/17.
 */
public class Bag<E> {

    final ConcurrentHashMap<E, Integer> map;
    int capaity = 0;

    public Bag(int capaity) {
        map = new ConcurrentHashMap<E, Integer>();
        this.capaity = capaity;
    }

    public Bag(ConcurrentHashMap<E, Integer> map, int capaity) {
        this.map = map;
        this.capaity = capaity;
    }

    public boolean add(E e) {
        if(map.size() >= capaity) return false;
        Integer v = map.get(e);
        if (v == null) map.put(e, 1);
        else map.put(e, v+1);
        return true;
    }

    public boolean add(E e, int count) {
        if(map.size() >= capaity) return false;
        Integer v = map.get(e);
        if (v == null) map.put(e, count);
        else map.put(e, v+count);
        return true;
    }

    public Set<E> keySet() {
        return map.keySet();
    }

    public Collection<Map.Entry<E, Integer>> entrySet() {
        return map.entrySet();
    }

    public int getCount(E e) {
        Integer v = map.get(e);
        if (v == null) return 0;
        else return v;
    }

    public E remove(){
        for (Map.Entry<E, Integer> entry : map.entrySet()) {
            map.remove(entry.getKey());
            return entry.getKey();
        }
        return null;
    }

}
