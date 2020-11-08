package pl.codedesign.patterns.creational.singleton;

public class LazySingletonDemo {

	public static void main(String[] args) {
		LazySingleton instance = LazySingleton.getInstance();
		
		System.out.println(instance + "\n");
		
		LazySingleton otherInstance = LazySingleton.getInstance();
		
		System.out.println(otherInstance);
	}
	
}
