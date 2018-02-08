package lambda.part1_basics;

import org.junit.Test;

public class Syntax {

	//3 parts of a lambda
	@Test
	public void basicSyntax() {
		//() are for parameters
		// -> signifies lambda
		// {} executed code
		Runnable smallestLambda = () -> {};

		//running it!
		smallestLambda.run();
		//nothing interesting will happen
	}

	@Test
	public void runningBasicLambda() {
		Runnable basicGreeting = () -> {
			System.out.println("hello world!");
		};
		basicGreeting.run();
		//check the console
	}

	private interface RunnableWithParam {
		void printMe(String print);
	}

	//an interface is required to create lambdas with parameters or return values
	@Test
	public void runningBasicLambdaWithParams() {

		RunnableWithParam customGreeting = (String printMe) -> {
			System.out.println(printMe);
		};
		customGreeting.printMe("hello world! I got this from a lambda!");
	}

	private interface Greeting {
		String getGreeting();
	}

	// sometimes you want to return information
	@Test
	public void runningBasicLambdaWithReturn() {

		Greeting englishGreeting = () -> {
			return "hello world";
		};
		System.out.println(englishGreeting.getGreeting());

		//lets try spanish
		Greeting spanishGreeting = () -> {
			return "Hola Mundo";
		};
		System.out.println(spanishGreeting.getGreeting());
	}

}
