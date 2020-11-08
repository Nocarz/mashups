package pl.codedesign.patterns.creational.singleton;

public class ThreadSafeLazySingletonDemo {

	public static void main(String[] args) {
		ThreadSafeLazySingleton instance = ThreadSafeLazySingleton.getInstance();
		
		System.out.println(instance + "\n");
		
		ThreadSafeLazySingleton otherInstance = ThreadSafeLazySingleton.getInstance();
		
		System.out.println(otherInstance);
	}
	
}
