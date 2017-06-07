package com.vrevankar.java.sample.exercise_01;

import java.util.*;

/**
 * Created by Vinay on 6/6/17.
 */
public class MergeLists<T> {

    public static void main(String... args) {

        MergeLists merge = new MergeLists();
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();

        merge.readList("List #1", list1);
        merge.readList("List #2", list2);
        list1.addAll(list2);

        merge.printList(list1);

    }

    private void readList(String caption, List<Integer> list){
        System.out.println(caption);
        System.out.print("\tSize: ");
        int size = new Scanner(System.in).nextInt();
        System.out.println("\tElements: ");
        while(size-- > 0) list.add(new Scanner(System.in).nextInt());
    }

    private void printList(List<T> list){
        for(T ele : list) System.out.print(ele + " ");
	System.out.println();
    }

}
