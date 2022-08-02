package com.example.java.java10.one;

import java.util.List;
import java.util.stream.Collectors;

public class CollectorsAPIDemo {
    public static void main(String[] args) {
        List<Integer> integers = List.of(10, 20, 30, 40, 50, 60);
        List<Integer> list1 = integers.stream().filter(i -> i % 3 == 0).collect(Collectors.toList());
        list1.add(20); // we can easily modify this list though this list shouldn't have 20 as it's not divisible by 3.
        System.out.println("List1 is modified successfully");
        List<Integer> list2 = integers.stream().filter(i -> i % 3 == 0).collect(Collectors.toUnmodifiableList());
        list2.add(20); // It will throw RunTimeException
    }
}
