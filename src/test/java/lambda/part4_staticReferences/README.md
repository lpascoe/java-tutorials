# Double Colon Operator `::`

As of java 1.8 you can reference static utility functions and pass them as parameters without specifying the values

Instance and static methods can both be referenced

```java
	UnaryOperator<String> stringOperator = str -> str.toLowerCase();
	//should be replaced with
	UnaryOperator<String> stringOperator = String::toLowerCase;
	stringOperator.apply("Hello World");
```



[Part 4](../part5_goodBadAndUgly/README.md)