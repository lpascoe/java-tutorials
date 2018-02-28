package lambda.part5_goodBadAndUgly;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public class BadExamples {
	public void unclearPurpose() {
		Predicate<String> validateInput = s -> Pattern
				.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$").asPredicate().test(s);

		validateInput.test("Is this okay");
		validateInput.test("email@email.com");

	}

	public void afterEmailRefactor() {
		String emailRegex = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
		Predicate<String> emailValidator = s -> Pattern.compile(emailRegex).asPredicate().test(s);

	}

	public void singleParamSingleLineReturn() {
		Predicate<String> bad = (input) -> {
			return input != null;
		};

		Predicate<String> good = input -> input != null;
	}

	public void nestedLambda() {
		Predicate<String> bad = (input) -> {
			return input != null;
		};
	}
}
