package pl.codedesign.patterns.behavioral.specyfication.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;

public class Task {
	
	public static Task of(String name, TaskType type, Status status, Date expiration, int version) {
		return new Task(name, type, status, expiration, version);
	}
		
	public Task(String name, TaskType type, Status status, Date expiration, int version) {
		this.name = name;
		this.type = type;
		this.status = status;
		this.expiration = expiration;
		this.version = version;
	}

	private String name;
	
	private TaskType type;
	
	private Status status;
	
	private Date expiration;
	
	private int version;

	public String getName() {
		return name;
	}

	public TaskType getType() {
		return type;
	}

	public Status getStatus() {
		return status;
	}

	public Date getExpiration() {
		return expiration;
	}

	public int getVersion() {
		return version;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(TaskType type) {
		this.type = type;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(name)
				.append(type)
				.append(status)
				.append(expiration)
				.append(version)
				.build();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj == null) {
			return false;
		}
		
		if (getClass() != obj.getClass()) {
			return false;
		}
		
		Task other = (Task) obj;
		
		return new EqualsBuilder()
				.append(name, other.name)
				.append(type, other.type)
				.append(status, other.status)
				.append(expiration, other.expiration)
				.append(version, other.version)
				.isEquals();
	}
}
