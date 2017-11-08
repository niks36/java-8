# Function

Function<T, R> is an in-built functional interface introduced in Java 8 in the java.util.function package. The primary purpose for which Function<T, R> has been created is for mapping scenarios i.e when an object of a type is taken as input and it is converted(or mapped) to another type. Common usage of Function is in streams where-in the map function of a stream accepts an instance of Function to convert the stream of one type to a stream of another type.

There are basically 3 methods
```java

R apply(T t);

Function<V, R> compose(Function<? super V, ? extends T> before);

Function<T, V> andThen(Function<? super R, ? extends V> after) ;


```

Function Descriptor is T -> R. This means an object of type T is input to the lambda and an object of type R is obtained as return value

## apply()

This would convert object of Type T to R.
```java

 Function<Employee,String> stringFunction = e -> e.getName().toUpperCase();

 String name = stringFunction.apply(employee);

```

## andThen(Function<R,V>)

As the name suggest, first apply function convert object of Type T -> R & then apply function converts its to R -> V.
```java
 Function<Employee,String> stringFunction = e -> e.getName().toUpperCase();
 Function<String,Integer> lengthFunction = String::length;
 Function<Employee, Integer> employeeIntegerFunction = stringFunction.andThen(lengthFunction);
 int length = employeeIntegerFunction.apply(employee);

```

## compose(Function<V,T>)

As the name suggest, it applies before. So first compose function convert object of Type V -> T & then apply function converts its to T -> R.
```java
 Function<Employee,String> stringFunction = e -> e.getName().toUpperCase();
 Function<Integer,Employee> lengthFunction = employeeList::get;
 Function<Integer, String> compose = function.compose(lengthFunction);
 String name = compose.apply(1);

```