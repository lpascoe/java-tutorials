# Functional Intefaces

With Anonymous Classes you provide your own interfaces to bind to.

As of Java 1.8, java provides a suite of functional interfaces.

in our previous examples

```java
	private interface AnonymousInnerFunction {
		String getGreeting();
	}
```

Java provides a generic interface `java.util.function.Supplier<T>`, which takes no parameters, and 'supplies' a value of type `T`

Originally the example 

```java
	AnonymousInnerFunction func = () -> "Hello World";
	System.out.println(func.getGreeting());
```

Would be replaced by

```java
	Supplier<String> greeting = () -> "hello World";
	System.out.println(greeting.get());
```

Java provides a few dozen interfaces to implement against, the complete list is found here [Here](https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html). These would cover 90% of your interface requirements. Think twice before creating your own functional interface, it may be an indicator to do a refactor.

General Verbiage of the built in Functional Interfaces

| Name | Parameters | Returns |
|------|------------|---------|
|`Consumer`|N/A|N/A|


* `Consumer` always takes at least a value and always returns nothing
* `Predicate` always returns a `boolean` value
* `Function` takes at least one value and returns 

Most notable functional interfaces, in my opinion, include

* `Consumer<T>` takes type `T` and returns nothing. 

BiConsumer<T,U>
BiFunction<T,U,R>
BiPredicate<T,U>

Function<T,R>
Predicate<T>
Supplier<T>
UnaryOperator<T>
 

[Part 1](part1_basics/README.md)