package com.example.java9.six;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OptionalOr {
    public void display(Stream<Integer> intList) {
        intList.forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Integer> arrays = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10);
        OptionalInt first = IntStream.rangeClosed(0, 10)
                .filter(e -> e < 5)
                .findFirst();// it generates an Optional<Integer>

        // In Java 8, we used to apply map and orElse() method
        // map method performs operation if optional has value. It doesn't do anything if optional is empty
        // orElse() -> will execute if optional is empty
        // or method will generate an optional with the given value

        Optional<Integer> or = arrays.stream()
                .filter(e -> e > 5)
                .findFirst()
                .or(() -> Optional.of(7));

        System.out.println(or);

        Optional<Integer> or1 = arrays.stream()
                .filter(e -> e > 50)
                .findFirst()
                .or(() -> Optional.of(7));

        System.out.println(or1);
    }
}
