package lambda.part2_moreAdvanced;

import org.junit.Test;

public class MoreDifferences {
	protected String outerField = "I'm a class field";
	protected int fieldCounter = 0;

	private interface AnonymousInnerFunction {
		String getGreeting();
	}

	//Anonymous inner classes can use outer variables
	@Test
	public void useOuterVariableAnon() {

		String outerLocal = "I'm a local variable";
		AnonymousInnerFunction anonGreeting = new AnonymousInnerFunction() {
			@Override
			public String getGreeting() {
				//name already taken. NO COMPILER ERRROR, only warning!
				String outerLocal = "inner variable";

				return outerField + " " + outerLocal;
			}
		};
		System.out.println(anonGreeting.getGreeting());
	}

	//Lambda's can use outer variables
	@Test
	public void useOuterVariableLambda() {

		String outerLocal = "I'm a local variable";
		AnonymousInnerFunction anonGreeting = () -> {

			//name already taken, NOT ALLOWED, compiler error!
			//String outerLocal = "";
			//name is taken, but its outside of the scope of this method
			String outerField = "overridden field";

			String combined = outerField + " " + outerLocal;
			return combined;
		};
		System.out.println(anonGreeting.getGreeting());
	}

	//Anonymous inner classes can contain state
	@Test
	public void statefulAnonymousClass() {

		AnonymousInnerFunction anonGreeting = new AnonymousInnerFunction() {
			int counter = 0;

			@Override
			public String getGreeting() {
				return "Greeting number" + counter++;
			}
		};

		System.out.println(anonGreeting.getGreeting());
		System.out.println(anonGreeting.getGreeting());
		System.out.println(anonGreeting.getGreeting());
		System.out.println(anonGreeting.getGreeting());
		System.out.println(anonGreeting.getGreeting());
	}

	//Referenced variables are effectively final, compilation error
	@Test
	public void localVariableCounterLambda() {

		int counter = 0;
		//Compiler error, counter is effectively final
		//AnonymousInnerFunction anonGreeting = () -> "Greeting number" + counter++;

	}

	//Referenced variables are effectively final
	@Test
	public void fieldVariableCounterLambda() {

		//Completely fine
		AnonymousInnerFunction anonGreeting = () -> "Greeting number" + fieldCounter++;
		System.out.println(anonGreeting.getGreeting());
		System.out.println(anonGreeting.getGreeting());
		System.out.println(anonGreeting.getGreeting());
		System.out.println(anonGreeting.getGreeting());
		System.out.println(anonGreeting.getGreeting());

	}

}
