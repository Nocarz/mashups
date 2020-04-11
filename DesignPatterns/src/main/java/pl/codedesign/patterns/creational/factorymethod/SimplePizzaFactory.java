package pl.codedesign.patterns.creational.factorymethod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Implementation of Factory Method design pattern.
 * 
 * @author B.Denk
 */
public class SimplePizzaFactory {

	protected static Logger LOG = LogManager.getLogger(SimplePizzaFactory.class);

	/** Optional presentation matter. */
	enum PizzaType {
		SPINACHI, ROMA;
	}

	/** Product interface */
	interface Pizza {
		String getName();

		PizzaType getType();
	}

	/** Concrete product #1 */
	class SpinachPizza implements Pizza {
		public String getName() {
			return "Spinacchi";
		}

		public PizzaType getType() {
			return PizzaType.SPINACHI;
		}
	}

	/** Concrete product #2 */
	class RomaPizza implements Pizza {
		public String getName() {
			return "Roma";
		}

		public PizzaType getType() {
			return PizzaType.ROMA;
		}
	}

	/** Creator interface */
	interface PizzaFactory {
		Pizza create(PizzaType type);
	}

	/** Concrete factory */
	class BatmanPizzaFactory implements PizzaFactory {
		public Pizza create(PizzaType type) {
			Pizza pizza = null;

			switch (type) {
			case ROMA: {
				pizza = new RomaPizza();
				break;
			}
			case SPINACHI: {
				pizza = new SpinachPizza();
				break;
			}
			}
			return pizza;
		}
	}

	/** Factory usage */
	public SimplePizzaFactory() {
		PizzaFactory factory = new BatmanPizzaFactory();

		Pizza roma = factory.create(PizzaType.ROMA);
		LOG.info("Created pizza: " + roma.getName() + " of type : " + roma.getType().name());

		Pizza spinachi = factory.create(PizzaType.SPINACHI);
		LOG.info("Created pizza: " + spinachi.getName() + " of type : " + spinachi.getType().name());
	}

	public static void main(String... args) {
		new SimplePizzaFactory();
	}
}
