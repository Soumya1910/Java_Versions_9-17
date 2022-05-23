package com.example.java9.six;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalIfPresentOrElse {
    public static void process(Optional<Integer> result){
        /*we shouldn't use a function where we are taking a parameter as optional.
        cz caller needs to wrap the value in optional and this function needs to check if the value is present or it's an empty.*/

        //System.out.println(result.get()); // never use get() as it blows up if there is no element.

        /*Instead we should use either orElse()- when we can pass some dummy value instead of throwing error or
        we can throw error by calling orElseThrow()*/
        //System.out.println(result.orElse(0));
        //System.out.println(result.orElseThrow());

        /*Another approach we can check if element is present or not by calling isPresent. This is an imperative approach*/
        /*if(result.isPresent()){
            System.out.println(result.orElse(0));
        }
        else{
            System.out.println("No value");
        }*/

        /*Below is the example of functional approach*/
        result.ifPresentOrElse(
                value-> System.out.println("The value is : "+value), // consumer  --- if part
                ()-> System.out.println("No value")); // runnable  // else part
    }

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(10,20,30,40,50,60,70,25,35,45,65,75,85,90);
        // want to find out the first element which is greater than 70
        process(intList.stream()
                .filter(e-> e<70)
                .findFirst());

        process(intList.stream()
                .filter(e-> e>100)
                .findFirst());
    }
}
