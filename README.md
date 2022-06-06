# Java_Versions_9-17
This repository contains different features published in different versions of Java

## Java 9 Features

1. <b>Private method in interface </b>

    - Interface can contain private method.
    - Interface can have static private method.
    - Interface can't have default private method. It's an <b>Illegal combination of modifiers default and private</b>.
    - From Java 9 onwards, interfaces can have 6 type of members:
        1. Constant Variable
        2. Abstract Methods
        3. Default Methods
        4. Static Methods
        5. Private Methods
        6. Private Static Methods
    - <b>Clean code principal: </b>
        - Default methods should be sort like all other methods.
        - Use private methods to extract shared code of default methods.
        - Use default methods for providing standard implementations for new interface code.
        - Don't use default methods to extend existing interfaces unless it's necessary.
    - <b>Interface vs Abstract Class after Java 9</b>

|               | Interface     | Abstract  |
| ------------- |:-------------:| ---------:|
| Constructor   | No            | Yes       |
| Static Fields | Yes           | Yes       |
| Non-Static Fields   | No            | Yes       |
| Final Fields   | Yes            | Yes       |
| Non-Final Fields   | No            | Yes       |
| Private Fields   | No            | Yes       |
| Protected Fields & Methods   | No            | Yes       |
| Public Fields & Methods   | Yes            | Yes       |
| Abstract Methods   | Yes            | Yes       |
| Static Methods   | Yes            | Yes       |
| Non-Static Methods   | Yes            | Yes       |
| Final Methods   | No            | Yes       |
| Non-Final Methods   | Yes            | Yes       |
| Default Methods   | Yes            | No       |
| Private Methods   | Yes            | Yes       |
| Private Static Methods   | Yes            | Yes       |
    

2. <b>Effectively final in try-with-resource </b>
    - Garbage collector is meant to collect garbage resources. It cleans up the memory by collecting those objects which has null reference. But in our real life, we open so many external resources like DB Connection, File System, Socket, TCP Protocol etc. But GC doesn't collect any external resources.
    - We have finalize() method but not sure when this method is called.
    - Java 7, we have try-with-resource implementation. `try(Resource resource = new Resource()) {}`
    - We can see this try-with-resource is tightly coupled.
    - Java 9 provides implementation where we can pass any Resource class or subclass which is implemented <b>AutoCloseable interface</b>.
    - Restriction for this implementation is <b>Resource class should be final or Effectively final</b>.
    - Java 9, finalize() is deprecated.
    - <b>Clean code principal: </b>
        - Always prefer try-with-resources, don't use try-finally and definitely don't use finalize method to close the instance.
        - Be aware of convinient methods such as `InputStream.transferTo`.

3. <b>No _ in variable name</b>
    - From Java 9, _ is a keyword, it can't be used as an identifier.

4. <b>Stream takeWhile() and dropWhile()</b>
    - takeWhile() and dropWhile() are predicate which validates a condition.
    - `limit(number)` and `takeWhile(predicate)`
    - `skip(number)` and `dropWhile(predicate)`

5. <b>IntStream iterate method</b>
    - iterate has 2 overloaded method:
        - `iterate(seed, predicate, function)`
        - `iterate(seed, function)`

6. <b>Optional - ifPresentOrElse</b>
    - `ifPresentOrElse(consumer, runnable)`
    - consumer function is treated as if condition
    - runnable is treated as else part

7. <b>Optional.stream()</b>
    - optional element can be converted into stream for further stream operation.
