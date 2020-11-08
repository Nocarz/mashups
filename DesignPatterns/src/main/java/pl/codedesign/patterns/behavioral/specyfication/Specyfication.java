package pl.codedesign.patterns.behavioral.specyfication;

import pl.codedesign.patterns.behavioral.specyfication.model.Task;

public interface Specyfication {

	boolean isSatisfiedBy(Task task);
	
	default Specyfication and(Specyfication other) {
		return task -> {
			boolean satisfies = this.isSatisfiedBy(task);
			return satisfies ? other.isSatisfiedBy(task) : satisfies;
		};
	}
}
