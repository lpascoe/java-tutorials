# The Good, The Bad, and The Ugly (Tricks and Tips)

Like with any other useful tool, it can be used improperly. Below are some general practices to make sure everyones experience with lambdas is as good as yours 


## Lambdas should be self explanatory

If a lambda performs more than one function, then the lambda should be split up


If the lambda's function is not clear at first glance, or requires a comment, it is an indication it should be factored out into a function

```java
//this predicate will test if the input is an email 
Predicate<String> validateInput = s -> Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$").asPredicate().test(s);
```

should be refactored to..

```java
String emailRegex = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
	Predicate<String> emailValidator = s -> Pattern.compile(emailRegex).asPredicate().test(s);
```

## Lambdas should be small

The ideal amount of lines in a lambda is 1. Even 2 or 3 lines may be okay, but any more than 3 lines may require a method extract. As long as the lambda is clear, use you're own judgement.

## Omit brackets and parentheses whenever possible

Lambdas with single params, and a single statement, get a terseness bonus

brackets, parentheses, and return become optional.

```java
(input) -> {
			return input != null;
		};
```

can be turned into,

```java
input -> input != null;
```

## Prefer method reference over lambda reference

use the `::` notation wherever is reasonable

```java
	UnaryOperator<String> stringOperator = str -> str.toLowerCase();
	//should be replaced with
	UnaryOperator<String> stringOperator = String::toLowerCase;
	stringOperator.apply("Hello World");
```

## Don't nest lambdas

They're very hard to read, and should be a big red flag for a refactor.

## Effectively Final.....
 
 Just because the reference is final, doesn't mean that the state is final

the below example is completely legal from the compilers perspective

```java
int[] total = new int[1];
Runnable r = () -> total[0]++;
```
Mutating state outside of the lambda should be avoided, it can cause headaches in the future.



