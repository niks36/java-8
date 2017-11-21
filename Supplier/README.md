# Supplier Function

Supplier is build in functional interface. It is used when there is no input but an output is expected.

### Functional Descriptor
Functional Descriptor for supplier function is () -> T.
There is not input but it returns output of type T.

#### java.util.function.Supplier source code
```java
@FunctionalInterface
public interface Supplier<T> {
    /**
     * Gets a result.
     * @return a result
     */
    T get();
}
```

#### Methods

get() is a primary abstract method of Supplier Functional Interface.


#### get()
With Lambda expression
```java
 Supplier<String> supplier = () -> "Supplier";
 System.out.println(supplier.get());
```

With method reference to a static method
```java
  Supplier<Calendar> calendarSupplier = Calendar::getInstance;
  System.out.println(calendarSupplier.get().getTime());
```

With method reference to default constructor
```java
 Supplier<Date> dateSupplier = Date::new;
 System.out.println(dateSupplier.get().getTime());
```
