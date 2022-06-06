package com.example.java9.eight;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ListOfExample {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println("list1--->"+list1.getClass()); // class java.util.Arrays$ArrayList
        // Doesn't matter how many elements are present, it always returns Arrays$ArrayList
        // We will be able to add element in this list

        List<Integer> list2 = List.of(1,2,3,4);
        System.out.println("list2---->"+list2.getClass()); // class java.util.ImmutableCollections$ListN
        // It produces an immutable list of size N.
        // We cannot do add() in this list
        //list2.add(10); // it will throw error as list2 is immutable

        List<Integer> list3 = List.of(1,2);
        System.out.println("list3---->"+list3.getClass());

        List<Integer> list4 = List.of(1);
        System.out.println("list4----->"+list4.getClass());

        List<Integer> list0 = List.of();
        System.out.println("list0----->"+list0.getClass());


    }
}
