# Lambdas

## basics

Lambdas implement a functional interface

It has many functional similarities to Anonymous Inner Classes

```java
	private interface AnonymousInnerFunction {
		String getGreeting();
	}
```
it's used by createing a new instance with an override for the method.

```java

	AnonymousInnerFunction anonGreeting = new AnonymousInnerFunction() {
			@Override
			public String getGreeting() {
				return "Hello World";
			}
		};
			
``` 



The most basic lambda `() -> {}`


##Parameters


```java
// parameters are specified in the parentheses  
 ()
//eg

//no parameters
() -> {}

// a single parameter
(String string) -> {};

// multiple parameters
(String str, int i) -> {};
```