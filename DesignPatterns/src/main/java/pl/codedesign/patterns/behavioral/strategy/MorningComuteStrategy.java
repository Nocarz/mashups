package pl.codedesign.patterns.behavioral.strategy;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;

/**
 * Implementation of Strategy design pattern examplified by every day traveling
 * to work.
 * 
 * @author B.Denk
 */
public class MorningComuteStrategy {

	Context context;

	/**
	 * Some say this is the longest sensless java declaration one can code.
	 */
	public static void main(String... args) {
		DateTime workStart = new DateTime(2014, 11, 5, 8, 00, 0, 0);
		DateTime leaveHome = new DateTime(2014, 11, 5, 6, 44, 58, 0);

		new MorningComuteStrategy(leaveHome, workStart);
	}

	MorningComuteStrategy(DateTime leaveHome, DateTime workStart) {
		context = new Context(new BusCommute());
		context.commute(leaveHome, workStart);

		context = new Context(new CarCommute());
		context.commute(leaveHome, workStart);
	}
}

/**
 * -------
 * IMHO this should do some logic, strategy choice or facade stuff, but lets
 * keep the baseline.
 * -------
 */
class Context {
	private final Strategy strategy;

	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	public void commute(DateTime departureTime, DateTime arrivalTime) {
		strategy.execute(departureTime, arrivalTime);
	}
}

/** ------- Pattern interface. What else could it be? ------- */
interface Strategy {
	void execute(DateTime departureTime, DateTime arrivalTime);
}

/** ------- Presentation. ---------- */
enum CommuteWay {
	CAR, BUS;
}

/** ------- Strategy #1: commute by car ------- */
class CarCommute extends AbstractCommute implements Strategy {

	public CarCommute() {
		super(CommuteWay.CAR);
	}

	/** Time in minutes needed to get to work by car. */
	private final int carTravelTime = 45;

	public void execute(DateTime departureTime, DateTime arrivalTime) {
		DateTime myWorkArrival = departureTime.plusMinutes(carTravelTime);

		commuteResult(myWorkArrival, arrivalTime);
	}
}

/** ------- Strategy #2: commute by bus ------- */
class BusCommute extends AbstractCommute implements Strategy {

	public BusCommute() {
		super(CommuteWay.BUS);
	}

	/** DateTime bus stop departures, sorted descending. */
	List<DateTime> busDepartures = Arrays.asList(
			new DateTime(2014, 11, 5, 7, 40, 0, 0),
			new DateTime(2014, 11, 5, 7, 20, 0, 0),
			new DateTime(2014, 11, 5, 7, 00, 0, 0),
			new DateTime(2014, 11, 5, 6, 40, 0, 0),
			new DateTime(2014, 11, 5, 6, 20, 0, 0)
			);

	private final int busStationTimeDistance = 15;

	private final int busTravelTime = 40;

	public void execute(DateTime leaveHome, DateTime workStart) {
		DateTime myBusStationArrival = leaveHome.plusMinutes(busStationTimeDistance);
		DateTime nextBus = null;

		// simple selection of next best bus departure
		for (DateTime departure : busDepartures) {
			if (nextBus == null || myBusStationArrival.isBefore(departure)) {
				nextBus = departure;
			}
		}

		DateTime myWorkArrival = nextBus.plusMinutes(busTravelTime);

		commuteResult(myWorkArrival, workStart);
	}
}

/** ------- Optional class, sorts out some declaration and enforces DRY ------- */
class AbstractCommute {
	protected static Logger LOG = LogManager.getLogger(AbstractCommute.class);

	protected CommuteWay way;

	public AbstractCommute(CommuteWay way) {
		this.way = way;
	}

	public void commuteResult(DateTime myWorkArrival, DateTime workStart) {
		LOG.info("--- COMMUTE RESULT: ---");

		if (myWorkArrival.isAfter(workStart)) {
			LOG.info(way.name() + ": You're " + (myWorkArrival.getMinuteOfHour() - workStart.getMinuteOfHour())
					+ " minutes late!");
		} else {
			LOG.info(way.name() + ": You're on time, good job!");
		}
	}
}