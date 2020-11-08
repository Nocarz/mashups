package pl.codedesign.patterns.behavioral.specyfication;

import pl.codedesign.patterns.behavioral.specyfication.model.Status;
import pl.codedesign.patterns.behavioral.specyfication.model.Task;
import pl.codedesign.patterns.behavioral.specyfication.model.TaskType;

import java.util.Date;

public class SpecyficationDemo {

	public static void main(String[] args) {		
		Task task = Task.of("alpha", TaskType.ON_DEMAND, Status.NOT_STARTED, new Date(), 1);		
		
		boolean isValid = new NotStartedSpecyfication()
				.and(new OnDemandTaskSpecyfication())
				.and(new ExtantSpecyfication())
			.isSatisfiedBy(task);
		
		System.out.println(task.getName() + " is" + ((!isValid) ? " NOT " : " ") + "valid");
	}	
}
