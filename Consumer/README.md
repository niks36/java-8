# Consumer Function

Consumer is used when some operation needs to be performed on the object without returning the object.

#### Consumer Function Descriptor
Consumer Function Descriptor is  T -> ().


#### Consumer Interface

```java

@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
    default Consumer<T> andThen(Consumer<? super T> after) {
        Objects.requireNonNull(after);
        return (T t) -> { accept(t); after.accept(t); };
    }
}
```

#### Methods

accept() method is primary method for Consumer. it takes input T & returns no value.

andThen() is default method,  when applied on a Consumer interface, takes as input another instance of Consumer interface and returns as a result a new consumer interface which represents aggregation of both of the operations defined in the two Consumer interfaces.


#### accept()
```java

 List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
 Consumer<Integer> consumer = i -> System.out.println(i+ " x10 is = "+(i*10));
 list.forEach(consumer);
```

**Output**
```
1 x10 is = 10
2 x10 is = 20
3 x10 is = 30
4 x10 is = 40
5 x10 is = 50
6 x10 is = 60
7 x10 is = 70
8 x10 is = 80
9 x10 is = 90
10 x10 is = 100
```


#### andThen()
```java
list.forEach(consumer.andThen(integer -> System.out.println("do something...")));
```

**Output**
```
1 x10 is = 10
do something...
2 x10 is = 20
do something...
3 x10 is = 30
do something...
4 x10 is = 40
do something...
```