package pl.codedesign.patterns.creational.singleton;

public class SimpleSingletonDemo {

	public static void main(String[] args) {
		SimpleSingleton instance = SimpleSingleton.getInstance();
		
		System.out.println(instance);
		
		SimpleSingleton otherInstance = SimpleSingleton.getInstance();
		
		System.out.println(otherInstance);
		
		
	}
	
}
