package pl.codedesign.patterns.behavioral.specyfication;

import pl.codedesign.patterns.behavioral.specyfication.model.Status;
import pl.codedesign.patterns.behavioral.specyfication.model.Task;

public class NotStartedSpecyfication implements Specyfication {

	@Override
	public boolean isSatisfiedBy(Task task) {
		return Status.NOT_STARTED.equals(task.getStatus());
	}
}