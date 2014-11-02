package pl.codedesign.patterns.singleton;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BasicSingletonTest {

	@Test
	public void testApp() {
		Integer exprected = 1;

		BasicSingleton.getInstance();
		BasicSingleton.getInstance();

		assertEquals(exprected, BasicSingleton.getInstance().getCounter());
		assertEquals(exprected++, BasicSingleton.getInstance().increment());
	}
}
