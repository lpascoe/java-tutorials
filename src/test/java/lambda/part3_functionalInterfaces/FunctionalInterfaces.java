package lambda.part3_functionalInterfaces;

import java.util.function.Supplier;

import org.junit.Test;

public class FunctionalInterfaces {

	@Test
	public void supplierTest() {
		Supplier<String> greeting = () -> "hello World";
		System.out.println(greeting.get());
	}

}
