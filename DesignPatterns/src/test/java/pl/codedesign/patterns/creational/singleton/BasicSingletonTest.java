package pl.codedesign.patterns.creational.singleton;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import pl.codedesign.patterns.creational.singleton.BasicSingleton;

class BasicSingletonTest {

	@Test
	void testApp() {
		Integer exprected = 1;

		BasicSingleton.getInstance();
		BasicSingleton.getInstance();

		assertThat(exprected).isEqualTo(BasicSingleton.getInstance().getCounter());
		assertThat(exprected++).isEqualTo(BasicSingleton.getInstance().increment());
	}
}
