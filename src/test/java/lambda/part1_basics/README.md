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
() -> {};

// a single parameter
(String str) -> {};

// multiple parameters
(String str, int i) -> {};
```

Return Values

The return statement can be implicit based on its context

```
() -> "implicit string";
```

Or they can be explicit

```java
() -> {return "implicit string";};
```


They can be assigned to variables

```java
private interface AnonymousInnerFunction {
		String getGreeting();
}

//using anonymous inner classes
AnonymousInnerFunction anonGreeting = new AnonymousInnerFunction() {
	@Override
	public String getGreeting() {
		return "Hello World";
	}
};
System.out.println(anonGreeting.getGreeting());

// using lambdas
AnonymousInnerFunction lambdaGreeting = () -> "Hello World";
System.out.println(func.getGreeting());
```

[Part 2](../part2_moreAdvanced/README.md)