package pl.codedesign.patterns.behavioral.command;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Command pattern implementation.
 * 
 * @author B.Denk
 */
public class CommandPattern {

	public static void main(String... args) {
		BasicConfigurator.configure();

		DeviceManager manager = new DeviceManager();
		Device hal9000 = new Device();

		Command activate = new ActivateCommand(hal9000);
		Command reboot = new RebootCommand(hal9000);
		Command indicate = new IndicateCommand(hal9000);

		manager.executeAndBacklog(activate);
		manager.executeAndBacklog(indicate);
		manager.executeAndBacklog(reboot);
		manager.executeAndBacklog(indicate);
		manager.executeAndBacklog(activate);
		manager.executeAndBacklog(indicate);
	}
}

/** Commands invoker. */
class DeviceManager {
	private final List<Command> cmdHistory = new ArrayList<Command>();

	public void executeAndBacklog(Command cmd) {
		cmdHistory.add(cmd);
		cmd.execute();
	}
}

/** Command pattern interface */
interface Command {
	void execute();
}

/** Presentation. */
enum State {
	ONLINE, REBOOTING, ERROR;
}

/** Object that receives commands to run. */
class Device {

	protected static Logger LOG = LogManager.getLogger(Device.class);

	State state;

	public void reboot() {
		LOG.info("Rebooting system NOW!");
		state = State.REBOOTING;
	}

	public void indicateState() {
		LOG.info("Current state: " + state.name());
	}

	public void activate() {
		LOG.info("Engaged");
		state = State.ONLINE;
	}
}

/** Concrete command - rebooting device. */
class RebootCommand implements Command {
	private final Device device;

	public RebootCommand(Device device) {
		this.device = device;
	}

	public void execute() {
		device.reboot();
	}
}

/** Concrete command - indicate device state. */
class IndicateCommand implements Command {
	private final Device device;

	public IndicateCommand(Device device) {
		this.device = device;
	}

	public void execute() {
		device.indicateState();
	}
}

/** Concrete command - activate device. */
class ActivateCommand implements Command {
	private final Device device;

	public ActivateCommand(Device device) {
		this.device = device;
	}

	public void execute() {
		device.activate();
	}
}