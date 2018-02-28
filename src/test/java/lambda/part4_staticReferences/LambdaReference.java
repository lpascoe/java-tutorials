package lambda.part4_staticReferences;

import java.util.function.UnaryOperator;

import org.junit.Test;

public class LambdaReference {
	UnaryOperator<String> stringOperator;

	@Test
	public void removeVowelTest() {
		String helloWorld = "Hello World";

		// built in utility methods
		stringOperator = String::toLowerCase;
		System.out.println(stringOperator.apply(helloWorld));

		// our own static utility methods
		stringOperator = StringManipulatorUtils::removeVowels;

		System.out.println(stringOperator.apply(helloWorld));

		//can also be referenced as a lambda itself
		stringOperator = StringManipulatorUtils.removeConsonants;
		System.out.println(stringOperator.apply(helloWorld));

		//even instance class methods can be used
		StringDuplicator strDuper = new StringDuplicator(10);
		stringOperator = strDuper::duplicateString;
		System.out.println("duplicated String:" + stringOperator.apply(helloWorld));
	}

}

class StringDuplicator {

	int dupNum;

	StringDuplicator(int duplicationNumber) {
		dupNum = duplicationNumber;
	}

	public String duplicateString(String target) {

		if (target == null) {
			return target;
		}

		StringBuilder strBuilder = new StringBuilder();
		for (int i = 0; i < dupNum; i++) {
			strBuilder.append(target);
		}
		return strBuilder.toString();
	}
}

final class StringManipulatorUtils {
	public static String removeVowels(String str) {
		return str != null ? str.replaceAll("[aeiouAEIOU]", "") : "";
	}

	public static UnaryOperator<String> removeConsonants = (
			String str) -> str != null ? str.replaceAll("[bcdfghjklmnpqrstvwxzBCDFGHJKLMNPQRSTVWXZ]", "") : "";

}