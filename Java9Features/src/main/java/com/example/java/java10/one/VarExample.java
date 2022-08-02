package com.example.java.java10.one;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class VarExample {
    public static void main(String[] args) {
        var x = 10; // whenever we are not defining any specific datatype, we can declare it as var.
        // var is not a Java reserve keyword cz java wants to make to it backward compatible. previously declared variable shouldn't throw any error.
        // When we declare one variable as var and assign some type of value, we cannot assign different type of value in that variable.
        /*
            x = "abc";
            x = 0.3;
         */

        Map<String, List<String>> map = new HashMap<String, List<String>>();
        var map2 = new HashMap<String, List<String>>(); // Java will automatically infer the type of var
        for(Map.Entry<String, List<String>> entry : map.entrySet()){}
        for(var entry: map2.entrySet()) {}


        Consumer<Integer> l = (i) -> {
            System.out.println(i);
        };
        /*var l2 = (i) -> {
            System.out.println(i);
        };*/

    }
}
