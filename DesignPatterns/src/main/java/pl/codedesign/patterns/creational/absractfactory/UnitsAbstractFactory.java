package pl.codedesign.patterns.creational.absractfactory;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class UnitsAbstractFactory {
	public static void main(String... args) {
		BasicConfigurator.configure();

		AbstractFactory navyFactory = FactoryProducer.getFactory(Type.NAVY);
		AbstractFactory aerialFactory = FactoryProducer.getFactory(Type.AERIAL);
		AbstractFactory landFactory = FactoryProducer.getFactory(Type.LAND);

		Aerial f16 = aerialFactory.getAreialUnit(F16.class);
		f16.launch();

		Land abbrams = landFactory.getLandUnit(Abbrams.class);
		abbrams.rollout();

		Navy nimitz = navyFactory.getNavyUnit(Nimitz.class);
		nimitz.splashdown();

	}
}

enum Type {
	NAVY, LAND, AERIAL
}

abstract class AbstractUnit {
	protected static Logger LOG = LogManager.getLogger(AbstractUnit.class);

	Type type;

	AbstractUnit(Type type) {
		this.type = type;
	}
}

interface Navy {
	void splashdown();
}

interface Land {
	void rollout();
}

interface Aerial {
	void launch();
}

class F16 extends AbstractUnit implements Aerial {
	public F16() {
		super(Type.AERIAL);
	}

	public void launch() {
		LOG.info(this.type.name() + " " + this.getClass().getSimpleName() + " - lanuched!");
	}
}

class Abbrams extends AbstractUnit implements Land {
	public Abbrams() {
		super(Type.LAND);
	}

	public void rollout() {
		LOG.info(this.type.name() + " " + this.getClass().getSimpleName() + " - rollout!");
	}
}

class Nimitz extends AbstractUnit implements Navy {
	public Nimitz() {
		super(Type.NAVY);
	}

	public void splashdown() {
		LOG.info(this.type.name() + " " + this.getClass().getSimpleName() + " - splasheddown!");
	}
}

abstract class AbstractFactory {
	abstract Navy getNavyUnit(Class<? extends Navy> clazz);

	abstract Land getLandUnit(Class<? extends Land> clazz);

	abstract Aerial getAreialUnit(Class<? extends Aerial> clazz);
}

class NavyFactory extends AbstractFactory {

	@Override
	public Navy getNavyUnit(Class<? extends Navy> clazz) {
		if (clazz == null) {
			return null;
		}
		if (clazz.equals(Nimitz.class)) {
			return new Nimitz();
		}
		return null;
	}

	@Override
	Land getLandUnit(Class<? extends Land> clazz) {
		return null;
	}

	@Override
	Aerial getAreialUnit(Class<? extends Aerial> clazz) {
		return null;
	}
}

class AerialFactory extends AbstractFactory {

	@Override
	public Navy getNavyUnit(Class<? extends Navy> clazz) {
		return null;
	}

	@Override
	Land getLandUnit(Class<? extends Land> clazz) {
		return null;
	}

	@Override
	Aerial getAreialUnit(Class<? extends Aerial> clazz) {
		if (clazz == null) {
			return null;
		}
		if (clazz.equals(F16.class)) {
			return new F16();
		}
		return null;
	}
}

class LandFactory extends AbstractFactory {

	@Override
	public Navy getNavyUnit(Class<? extends Navy> clazz) {
		return null;
	}

	@Override
	Land getLandUnit(Class<? extends Land> clazz) {
		if (clazz == null) {
			return null;
		}
		if (clazz.equals(Abbrams.class)) {
			return new Abbrams();
		}
		return null;
	}

	@Override
	Aerial getAreialUnit(Class<? extends Aerial> clazz) {
		return null;
	}
}

class FactoryProducer {
	public static AbstractFactory getFactory(Type type) {
		if (type == Type.AERIAL) {
			return new AerialFactory();
		} else if (type == Type.NAVY) {
			return new NavyFactory();
		} else if (type == Type.LAND) {
			return new LandFactory();
		}
		return null;
	}
}