package com.example.java.java9.two;

class Resource{

    public Resource() { System.out.println("Creating external resources"); }

    public void op1() { System.out.println("Op1 is called"); }

    public void finalize() { System.out.println("Cleaning up external resources.."); }
}

class ResourceAfterJava9 implements AutoCloseable{

    public ResourceAfterJava9() { System.out.println("Creating external resources"); }

    public void op1() { System.out.println("Op1 is called"); }

    public void close() { System.out.println("Cleaning up external resources.."); }
}

public class TryWithResource {
    public static void main(String[] args) {

        Resource resource = new Resource();
        resource.op1(); // finalize method will not be called immediately as JVM has sufficient memory

        System.out.println("-------------------------------");
        // Java 7 implementation
        try(ResourceAfterJava9 resource2 = new ResourceAfterJava9()){
            resource2.op1();
        }

        // Java 9 implementation
        use(new ResourceAfterJava9()); // we can pass any Resource class or subclass which implements AutoCloseable interface
    }

    public static void use(ResourceAfterJava9 resource){
        // Disadvantage is this resource will be available throughout this function scope.
        // Resource should be final or effectively final (Effectively final means we can't mutate this object)
        //resource = resource; // it will give compilation error as resource should be final or effectively final.

        try(resource){
            resource.op1();
        }
    }
}
