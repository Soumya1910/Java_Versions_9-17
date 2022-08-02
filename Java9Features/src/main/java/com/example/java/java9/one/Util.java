package com.example.java.java9.one;

/*
Interface can contain private method.
Interface can have static private method.
Interface can't have default private method. It's an Illegal combination of modifiers default and private.


 */


public interface Util {

    public int getName(); // non-defined method
    public default int getResource() { return getResourceCount();} // default method
    public static int getResource2() {return getResourceCount2();} // static method

    private int getResourceCount(){ return 4; } // you can have a private method in interface
    private static int getResourceCount2() { return 4;} // default static method is possible
    //private default int getResourceCount3() { return 4;} // default and private method is not possible
}
