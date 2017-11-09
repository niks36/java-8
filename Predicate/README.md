# Predicate

Predicate is a new functional interface defined in java.util.function package which can be used in all the contexts where an object needs to be evaluated for a given test condition and a boolean value needs to be returned based on whether the condition was successfully met or not.

## Methods
```java
     boolean test(T var1);

     default Predicate<T> and(Predicate<? super T> var1);

     default Predicate<T> negate();

     default Predicate<T> or(Predicate<? super T> var1);
```

### test()
Returns true if the input argument matches the predicate(the test condition), otherwise returns false
```java
    Predicate<Integer> predicate = i -> i > 5;

    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    list.stream().filter(predicate).collect(Collectors.toList())
```

**Output**
```
    6 7 8 9 10
```

### and(Predicate<T> p)
It does logical AND of the predicate on which it is called with another predicate.

```java
    Predicate<Integer> predicate = i -> i > 5;
    Predicate<Integer> and = predicate.and(i -> i > 8);
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    list.stream().filter(and).collect(Collectors.toList())
```

**Output**
```
   9 10
```

### or(Predicate<T> p)
It does logical OR of the predicate on which it is called with another predicate.
```java
    Predicate<Integer> predicate = i -> i > 5;
    Predicate<Integer> or = predicate.or(i -> i > 3);
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    list.stream().filter(or).collect(Collectors.toList())
```

**Output**
```
   4 5 6 7 8 9 10
```

### negate()
It does boolean negation of the predicate on which it is invoked.
```java
    Predicate<Integer> predicate = i -> i > 5;
    Predicate<Integer> negate = predicate.negate();
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    list.stream().filter(negate).collect(Collectors.toList())
```

**Output**
```
   1 2 3 4 5
```

## Acknowledgments
1. https://www.javabrahman.com/java-8/java-8-java-util-function-predicate-tutorial-with-examples/