
# Nitty gritty Compilation

## Anonymous Class Compilation

When compiled, they are compiled to a class, and thus have to be loaded and verified at startup

for example `AnonymousInnerClass$1.class`

## Lambda Compilation

When compiled:
* Lambdas are stored as a private static method inside of the containing class
* `InvokeDynamic`, as of java 7, can bind symbols to dynamic language at runtime
* `lambdafactory` is used to generate a call to the lambda method

```java

public class CapturingLambda {     
    public static void main(String[] args) 
    {         
        String effectivelyFinal = "effectivelyFinal";         
        Runnable capturingLambda = () -> System.out.println("capturingLambda " + effectivelyFinal);         
        capturingLambda.run();     } 
}
  
```

compiles to
 
```java

import java.io.PrintStream; 
import java.lang.invoke.LambdaMetafactory; 
public class CapturingLambda {     
    public static void main(String[] args) {        
        String effectivelyFinal = "effectivelyFinal";         
        Runnable capturingLambda = 
          (Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, 
                                                  lambda$0(java.lang.String ), 
                                                  ()V)((String)effectivelyFinal); 
          capturingLambda.run();     
    }     
    private static /* synthetic */ void lambda$0(String string) {         
        System.out.println("capturingLambda " + string);     
    } 
}

```

The syntax of lambda is just syntactic sugar sprinkled over top of a plain old method bound at runtime



Examples pulled from [Martin Farrell of D-Zone](https://dzone.com/articles/how-lambdas-and-anonymous-inner-classesaic-work), go there for more details.

## Capturing state

Lambdas by design are stateless.
Values can be passed in through parameters, or reference outer variables or methods, but they cannot contain fields or any persistent variables.

Anonymous Classes can contain all of the state it wants

This makes sense because the compiler only creates a private static method, it is shared code that uses the lambda, for every instance of the parent class

## Capturing Lambda vs Non-capturing Lambdas

Lambdas fall into these two categories: Capturing and Non-capturing lambda. It simply means, does the lambda use variables or fields outside of the lambda.

In the example above, the compiled `private static /* synthetic */ void lambda$0(String string)`, has an extra parameter `string` that was implicitly added because it is being passed in from outside the lambda 

All local variables referenced outside of the lambda are effectively final

The following example will result in a compiler error

```java
	//Referenced variables are effectively final
	@Test
	public void passingStateIntoLambda() {

		int counter = 0;
		//Compiler error, counter is effectively final
		AnonymousInnerFunction anonGreeting = () -> "Greeting number" + counter++;

	}
```

This is because local variables are 'copied' at runtime, so when executed, the original local variable and the instance in the lambda are two different objects in memory, making them effectively final.

however class fields are completely mutable

```java

	protected int fieldCounter = 0;
	
	public void fieldVariableCounterLambda() {

		//Completely fine
		AnonymousInnerFunction anonGreeting = () -> "Greeting number" + fieldCounter++;
		System.out.println(anonGreeting.getGreeting());

	}
	
```


## Variable overrides

Unlike Anonymous classes, lambdas cannot declare a variable with the same name as an outer local variable, field names overrides are allowed

The following example will result in a compilation error

```java

	protected String outerField = "I'm a class field";
	public void useOuterVariableLambda() {

		String outerLocal = "I'm a local variable";
		AnonymousInnerFunction anonGreeting = () -> {

			//name already taken, NOT ALLOWED, compiler error!
			String outerLocal = "overridden local variable";
			
			String combined = outerField + " " + outerLocal;
			return combined;
		};
		System.out.println(anonGreeting.getGreeting());
	}
```

Class fields on the other hand can be overridden, the compiler will give a warning, it is not recommended, but it is allowed.

```java
	
	protected String outerField = "I'm a class field";
	
	public void useOuterVariableLambda() {

		String outerLocal = "I'm a local variable";
		AnonymousInnerFunction anonGreeting = () -> {

			//name is taken, but its outside of the scope of this method
			String outerField = "overridden field";

			String combined = outerField + " " + outerLocal;
			return combined;
		};
		System.out.println(anonGreeting.getGreeting());
	}
```

[Part 3](../part3_functionalInterfaces/README.md)