# Java_Versions_9-17
This repository contains different features published in different versions of Java

## Java 9 Features

1. <b>Private method in interface </b>

    - Interface can contain private method.
    - Interface can have static private method.
    - Interface can't have default private method. It's an <b>Illegal combination of modifiers default and private</b>.

2. <b>Effectively final in try-with-resource </b>
    - Garbage collector is meant to collect garbage resources. It cleans up the memory by collecting those objects which has null reference. But in our real life, we open so many external resources like DB Connection, File System, Socket, TCP Protocol etc. But GC doesn't collect any external resources.
    - We have finalize() method but not sure when this method is called.
    - Java 7, we have try-with-resource implementation. `try(Resource resource = new Resource()) {}`
    - We can see this try-with-resource is tightly coupled.
    - Java 9 provides implementation where we can pass any Resource class or subclass which is implemented <b>AutoCloseable interface</b>.
    - Restriction for this implementation is <b>Resource class should be final or Effectively final</b>.
    - Java 9, finalize() is deprecated.

3. <b>No _ in variable name</b>
    - From Java 9, _ is a keyword, it can't be used as an identifier.

4. <b>Stream takeWhile() and dropWhile()</b>
    - takeWhile() and dropWhile() are predicate which validates a condition.
    - `limit(number)` and `takeWhile(predicate)`
    - `skip(number)` and `dropWhile(predicate)`
