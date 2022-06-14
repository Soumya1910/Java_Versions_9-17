package com.example.java9.eight;

import java.util.*;

public class ListOfExample {
    public static void main(String[] args) {

        // Prior Java 9, we used to create unmodifiable list like this.
        List<String> courseList = new ArrayList<>();
        courseList.add("English"); courseList.add("Mathematics"); courseList.add("Physics");
        List<String> immutableCourseList = Collections.unmodifiableList(courseList);

        // We can't modify immutableCourseList but we can add element in courseList which reflects in immutableCourseList as well.
        System.out.println("ImmutableCourseList before: "+immutableCourseList);
        courseList.add("Physics");
        System.out.println("ImmutableCourseList after: "+immutableCourseList);


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
