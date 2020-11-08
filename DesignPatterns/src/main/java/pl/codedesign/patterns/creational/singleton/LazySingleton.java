package pl.codedesign.patterns.creational.singleton;

public class LazySingleton {
	
	private static LazySingleton instance = null;
	
	private LazySingleton() {}
	
	public static LazySingleton getInstance() {
		if(instance == null) {
			instance = new LazySingleton();
			System.out.println("created singleton, lazy method - " + instance);
		}
		
		System.out.println("returning instance - " + instance);
		return instance;
	}

}
