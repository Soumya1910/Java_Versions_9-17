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
        - Default methods should be short like all other methods.
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
        - Be aware of convenient methods such as `InputStream.transferTo`.
          - `public long transferTo(OutputStream out) throws IOException`
          - Reads all bytes from this input stream and writes the bytes to the given output stream in the order that they are read. On return, this input stream will be at end of stream. This method does not close either stream.
    

3. <b>No _ in variable name</b>
    - From Java 9, _ is a keyword, it can't be used as an identifier.

4. <b>Stream takeWhile() and dropWhile()</b>
    - takeWhile() and dropWhile() are predicate which validates a condition.
    - `limit(number)` and `takeWhile(predicate)`
    - `skip(number)` and `dropWhile(predicate)`
    - `limit(number)`: opens the door and close it forever after certain number
    - `skip(number)`: opens the door forever after certain number
    - In Java 8, there was no scope to validate one condition (Predicate) and do skip or limit operation
    - `intList.stream().takeWhile(e-> e < 50).forEach(System.out::println);`: Stream will be 
      closed when 50 is found.
    - `intList.stream().dropWhile(e-> e < 50).forEach(System.out::println);`: Stream will 
      start considering value when this condition satisfies.

5. <b>IntStream iterate method</b>
    - iterate has 2 overloaded method:
        - `iterate(seed, predicate, function)`
          - `IntStream.iterate(0, e-> e<=15, e-> e+2).forEach(System.out::prinln);`
        - `iterate(seed, function)`
          - `IntStream.iterate(0, e-> e+2).takeWhile(e-> e<=15).forEach(System.out::println);`

6. <b>Optional - ifPresentOrElse</b>
    - `ifPresentOrElse(consumer, runnable)`
    - consumer function is treated as if condition
    - runnable is treated as else part

7. <b>Optional.stream()</b>
    - optional element can be converted into stream for further stream operation.

8. <b>Addition of List.of() method</b>
    - Prior Java 9, we used to create unmodifiable list by using `Collections.unmodifiableList()`. But it has a drawback. We can't modify immutableList but we can add element in original list which reflects in immutableList as well.
    - `List.of()` method generates an Immutable class of size N.
    - Any attempt to modify any `List.of()` method, either directly or through iterator object will throw `UnsupportedOperationException`.
    - `List.of()` method produces <b>ImmutableCollections$List2</b> when there are two elements passed as arguments.
    - `List.of()` method produces <b>ImmutableCollections$List1</b> when there is one elements passed as arguments.
    - `List.of()` method produces <b>ImmutableCollections$List0</b> when there is no elements passed as arguments. 
    - `List.of()` method produces <b>ImmutableCollections$ListN</b> when there are more than 3 elements passed as arguments.

9. <b>Addition of Set.of() method</b>
    - Prior Java 9, we used to create unmodifiable set by using like this: `Set<String> immutableSet = Collections.unmodifiableSet(new HashSet<String>(Arrays.asList("English", "Mathematics", "English")));`. The problem is to create an immutable set, a list should be created first which is an overhead and it's not very efficient.
    - Any attempt to modify `Set.of()` method either directly or through their iterator object will throw `UnsupportedOperationException`.
    - `Set.of()` method throws an error if duplicate elements are passed as argument.
    - `Set.of()` method also produces <b>ImmutableCollections$SetN</b>

10. <b>Addition of Map.of() method</b>
    - `Map.of()` method throws an error if odd number arguments are passed.
    - Any attempt to modify `Map.of()` method either directly or through their iterator object will throw `UnsupportedOperationException`.
    - It doesn't allow null in key values. If null values are added it throws NullPointerException.
    - It doesn't allow duplicate key values. If duplicate key values are added it throws `IllegalArgumentException`.

11. <b> JSHELL </b>
    - How JShell can be executed without having a class/method.
        - Code is parsed and its type is determined (variable declaration, expressions, method, class etc.)
        - Code is wrapped inside synthetic methods and classes. Import statements are used as it's.
        - The wrapped source code is analyzed and compiled by the regular java compiler.
        - The generated byte code is executed in JVM and the result is displayed by the Jshell tool.

    - Jshell can be started by using the following commands:
        - `jshell`

            ![jshell_1.PNG](https://github.com/Soumya1910/Java_Versions_9-17/blob/master/Java9Features/document/images/jshell_1.PNG)

        - `jshell --start default` It's similar like above. It makes several imprts available by default. We can use `/imports` command:

            ![jshell_2.PNG](https://github.com/Soumya1910/Java_Versions_9-17/blob/master/Java9Features/document/images/jshell_2.PNG)

        - `jshell --start PRINTING`: It can also be started with PRINTING option to make the print methods available as top-level methods, allowing us to use methods like `print(), println(), printf()` directly.

            ![jshell_3.PNG](https://github.com/Soumya1910/Java_Versions_9-17/blob/master/Java9Features/document/images/jshell_3.PNG)

        - If both the features of PRINTING and DEFAULT(for imports) are required, we can start jshell like this 
        `jshell --start DEFAULT --start PRINTING`

        - To exit from the Jshell, we can use `/exit` or `Ctrl+D`.

    - <b>Executing Snippets using Jshell</b>: Following snippets can be executed in Jshell
        - expression and statement
        - import statement
        - variable, method, class definition.

            ![jshell_4.PNG](https://github.com/Soumya1910/Java_Versions_9-17/blob/master/Java9Features/document/images/jshell_4.PNG)

            ![jshell_5.PNG](https://github.com/Soumya1910/Java_Versions_9-17/blob/master/Java9Features/document/images/jshell_5.PNG)

        - In jshell, using semicolon(;) is not mandatory except block statement.
        - Auto-complete can be attempted using the Tab key.

    - <b>Useful Commands: </b>
        - `/list :` List all source snippets with their id or name. Use `/list <id or name>` to get a specific snippet.
        - `/drop <id or name> : ` Removes a source of snippet.
        - `/edit <id or name> `
        - `/vars : `Lists all the variables declared in the session.
        - `/methods : `Lists all the methods declared in the session.
        - `/types : ` List all the types declared in the session.
        - `/imports : ` List of all imported items.
        - `open <file_path> : ` Load a source from the given path
        - `/save <file_path> : `Stores the Jshell session into a file.
        - `/reset : `Resets Jshell and its session.
        - `/history : `Display a history of what has been types in the session
        - `/env [--class-path <path>] [--module-path <path>] [--add-modules <modules>] : ` Sets class or module path to use compiled classes or modules.

    - <b>Exception : </b>
        - In Jshell, there is no need to handle checked exceptions. If a snippet throws a checked exception, the stacktrace will be shown and Jshell will continue. Though if a snippet throwing a checked exception is used inside a method, it will have to be handled or declared to be thrown. 







## Java 10 Features

1. <b>Introduce var keyword</b>

    - Whenever we are not defining any specific datatype, we can declare it as var.
    - var is not a Java reserve keyword cz java wants to make to it backward compatible. previously declared variable shouldn't throw any error.
    - When we declare one variable as var and assign some type of value, we cannot assign different type of value in that variable.
    - <b>var limitation</b>: 
        - We cannot assign any null value to var `var x = null;` not allowed.
        - We cannot replace the target type of lambda expression with var type. It throws an error `Lambda Expressions need an explicit target-type.`

        `Consumer<Integer> l = (i) -> {
            System.out.println(i);
        };` --- It's a valid expression

        `var l2 = (i) -> {
            System.out.println(i);
        };` --- It throws error.

        - We can't define class variable as var.

2. <b>Change in Collectors API</b>