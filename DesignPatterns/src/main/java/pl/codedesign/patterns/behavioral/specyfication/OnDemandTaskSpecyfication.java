package pl.codedesign.patterns.behavioral.specyfication;

import pl.codedesign.patterns.behavioral.specyfication.model.Task;
import pl.codedesign.patterns.behavioral.specyfication.model.TaskType;

public class OnDemandTaskSpecyfication implements Specyfication {

	@Override
	public boolean isSatisfiedBy(Task task) {
		return TaskType.ON_DEMAND.equals(task.getType());
	}
}