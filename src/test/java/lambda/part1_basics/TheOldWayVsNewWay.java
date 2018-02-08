package lambda.part1_basics;

import org.junit.Test;

public class TheOldWayVsNewWay {
	
	private interface AnonymousInnerFunction {
		String getGreeting();
	}

	//Pre Java 8
	@Test
	public void anonymousInnerFunction() {
		AnonymousInnerFunction anonGreeting = new AnonymousInnerFunction() {
			@Override
			public String getGreeting() {
				return "Hello World";
			}
		};
		System.out.println(anonGreeting.getGreeting());
	}

	@Test
	public void sameThingWithLambdas() {
		//from six lines to 1.
		AnonymousInnerFunction func = () -> "Hello World";
		System.out.println(func.getGreeting());
	}

	
	
	// an interface that takes a single string and prints a greeting
	private interface AnonymousInnerFunctionWithParam {
		void printGreeting(String greeting);
	}

	//Pre Java 8
	@Test
	public void anonymousPrintGreeting() {
		AnonymousInnerFunctionWithParam anonGreeting = new AnonymousInnerFunctionWithParam() {
			@Override
			public void printGreeting(String greeting) {
				System.out.println("Hello World");
			}
		};
		anonGreeting.printGreeting("Hellow Anon Inner function");
	}

	@Test
	public void sameGreetingThingWithLambdas() {
		//from six lines to 1.
		AnonymousInnerFunctionWithParam func = (String greeting) -> System.out.println(greeting);
		func.printGreeting("Hello Lambda");
	}

}
