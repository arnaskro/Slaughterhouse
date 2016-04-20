package services;

public class Test {

	public void greeting() {
		System.out.println("{greeting} Test");
	}

	public String greetingWithName(String name) {
		System.out.println("{greetingWithName} Hello, " + name + "!");
		return "Hello, " + name + "!";
	}
	
}

