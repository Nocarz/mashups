package pl.codedesign.patterns.creational.singleton;

/**
 * Yet another singleton template.
 * 
 * @author B.Denk
 */
public class BasicSingleton {

	private static BasicSingleton instance;

	protected Integer counter = 0;

	private BasicSingleton() {

	}

	public static BasicSingleton getInstance() {
		if (instance == null) {
			synchronized (BasicSingleton.class) {
				if (instance == null) {
					instance = new BasicSingleton();
					instance.increment();
				}
			}
		}

		return instance;
	}

	public Integer increment() {
		return counter++;
	}

	public Integer getCounter() {
		return counter;
	}

}
