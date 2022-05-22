package com.example.java9.four;

import java.util.Arrays;
import java.util.List;

public class TakeAndDropWhile {
    /*
    Haskal                          Java
    -----------------------------------------------------
    take                            limit
    drop                            skip
    takeWhile                       takeWhile
    dropWhile                       dropWhile
    * */
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(10,20,30,55,25,60,15,35,90,50);
        // limit --> opens the door and close it forever after certain number
        intList.stream()
                .limit(4)
                .forEach(System.out::println);

        System.out.println("-----------skip--------------");
        // skip ---> opens the door forever after certain number
        intList.stream()
                .skip(4)
                .forEach(System.out::println);

        System.out.println("----------takeWhile---------------");

        /* In Java 8, there was no scope to validate one condition (Predicate) and do skip or limit operation.*/
        // Whenever, we need to put any predicate, for limit, it's takeWhile and for skip, it's dropWhile()

        intList.stream()
                .takeWhile(e-> e < 50)
                .forEach(System.out::println);

        System.out.println("-----------dropWhile--------------");

        intList.stream()
                .dropWhile(e-> e < 60)
                .forEach(System.out::println);

    }
}
