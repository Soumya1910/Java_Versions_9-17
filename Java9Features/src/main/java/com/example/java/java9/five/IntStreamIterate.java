package com.example.java.java9.five;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class IntStreamIterate {
    public static void main(String[] args) {
        System.out.println("------------range()-------------");
        System.out.println("************Imperative Approach*********************");
        //imperative approach
        for(int i=0; i<5; i++){
            System.out.println(i);
        }
        System.out.println("************Functional Approach*********************");
        // Functional Approach
        IntStream.range(0,5).forEach(System.out::println); // range() - excludes the upper limit

        System.out.println("------------rangeClosed()-------------");
        System.out.println("************Imperative Approach*********************");
        //imperative approach
        for(int i=0; i<=5; i++){
            System.out.println(i);
        }
        System.out.println("************Functional Approach*********************");
        // Functional Approach
        IntStream.rangeClosed(0,5).forEach(System.out::println); // rangeClosed() - includes upper limit

        System.out.println("------------iterate(seed, predicate, function)-------------");
        System.out.println("************Imperative Approach*********************");
        //imperative approach
        for(int i=0; i<=15; i+=2){
            System.out.println(i);
        }
        System.out.println("************Functional Approach*********************");
        // Functional Approach
        IntStream
                .iterate(0, e-> e<= 15, e-> e+2)
                .forEach(System.out::println);

        System.out.println("------------iterate(seed, [predicate], function)-------------");
        System.out.println("************Imperative Approach*********************");
        //imperative approach
        for(int i=0; i<=15; i+=2){
            System.out.println(i);
        }
        System.out.println("************Functional Approach*********************");
        // Functional Approach
        IntStream
                .iterate(0, e-> e+2)
                .takeWhile(e-> e<=15)
                .forEach(System.out::println);

    }
}
