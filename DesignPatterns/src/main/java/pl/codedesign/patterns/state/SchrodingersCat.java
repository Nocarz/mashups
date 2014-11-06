package pl.codedesign.patterns.state;

import java.util.Random;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Class using state pattern to maintain its condition.
 * 
 * @author B.Denk
 */
public class SchrodingersCat {

	private static Logger LOG = LogManager.getLogger(SchrodingersCat.class);

	IState catState;

	public SchrodingersCat() {
		catState = new UnknownState(StateName.UNKNOWN);
	}

	public void checkState() {
		catState = catState.checkState();
	}

	public String getStateName() {
		return catState.getStateName();
	}

	public static void main(String... args) {
		BasicConfigurator.configure();

		SchrodingersCat cat = new SchrodingersCat();
		cat.checkState();

		LOG.info("Schrodingers cat is " + cat.getStateName());
	}
}

/** State enumeration, for the sake of presentation */
enum StateName {
	UNKNOWN, ALIVE, DEAD;
}

/** State pattern interface */
interface IState {
	IState checkState();

	String getStateName();
}

/** Basic state change and management. */
class UnknownState implements IState {
	StateName state;

	public UnknownState(StateName state) {
		this.state = state;
	}

	public IState checkState() {
		Random generator = new Random();
		int rand = generator.nextInt();

		// Designate if it's dead or alive
		if (rand % 2 == 0) {
			return new Alive();
		} else {
			return new Dead();
		}
	}

	public String getStateName() {
		return this.state.name();
	}
}

/** Semi-final state */
class Alive extends UnknownState {
	public Alive() {
		super(StateName.ALIVE);
	}

	@Override
	public IState checkState() {
		return this;
	}
}

/** Terminal object state (obviously...) */
class Dead extends UnknownState {
	public Dead() {
		super(StateName.DEAD);
	}

	@Override
	public IState checkState() {
		return this;
	}
}