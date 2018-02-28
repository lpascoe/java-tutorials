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

Java provides a few dozen interfaces to implement against, the complete list is found here [Here](https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html). These would cover 90% of your interface requirements.

General Verbiage of the built in Functional Interfaces

| Name | Parameters | Returns |Uses/Examples|
|------|------------|---------|----|
|`Consumer`|1...* any type|N/A|Setters, Event Handlers|
|`Predicate`|0...*|`boolean`|Streams, Filters|
|`Function`|1...* any type|any type|general purpose|
|`Operator`|2...* of type `T`|`T`|input manipulation `String::concat`|
|`Unary`|1 type `T`|`T`|`String::reverse`|
|`Binary`|2 type `T`|`T`|`String::concat`|

If writing your own functional interface follow the standard verbiage for readability 
 

[Part 4](../part4_staticReferences/README.md)