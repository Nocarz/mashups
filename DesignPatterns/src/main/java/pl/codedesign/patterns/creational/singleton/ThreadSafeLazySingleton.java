package pl.codedesign.patterns.creational.singleton;

public class ThreadSafeLazySingleton {
	
	private static volatile ThreadSafeLazySingleton instance = null;
	
	private ThreadSafeLazySingleton() {
		if(instance != null) {
			throw new RuntimeException("Reflection protection. Use getInstance method");
		}
	}
	
	public static ThreadSafeLazySingleton getInstance() {
		if(instance == null) {
			synchronized(ThreadSafeLazySingleton.class) {
				if(instance == null) {
					instance = new ThreadSafeLazySingleton();
					System.out.println("created singleton, lazy method - " + instance);
				}
			}						
		}
		
		System.out.println("returning instance - " + instance);
		return instance;
	}

}
