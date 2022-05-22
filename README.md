# Java_Versions_9-17
This repository contains different features published in different versions of Java

## Java 9 Features

1. Private method in interface

    - Interface can contain private method.
    - Interface can have static private method.
    - Interface can't have default private method. It's an <b>Illegal combination of modifiers default and private</b>.

2. Effectively final in try-with-resource
    - Garbage collector is meant to collect garbage resources. It cleans up the memory by collecting those objects which has null reference. But in our real life, we open so many external resources like DB Connection, File System, Socket, TCP Protocol etc. But GC doesn't collect any external resources.
    - We have finalize() method but not sure when this method is called.
    - Java 7, we have try-with-resource implementation. `try(Resource resource = new Resource()) {}`
    - We can see this try-with-resource is tightly coupled.
    - Java 9 provides implementation where we can pass any Resource class or subclass which is implemented AutoCloseable interface.
    - Restriction for this implementation is Resource class should be final or Effectively final.
    - Java 9, finalize() is deprecated.

3. No _ in variable name
    - From Java 9, _ is a keyword, it can't be used as an identifier.

4. 
