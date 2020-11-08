package pl.codedesign.patterns.behavioral.specyfication;

import pl.codedesign.patterns.behavioral.specyfication.model.Task;

import java.util.Date;

public class ExtantSpecyfication implements Specyfication {

	@Override
	public boolean isSatisfiedBy(Task task) {
		Date now = new Date();
		return now.before(task.getExpiration());
	}	
}