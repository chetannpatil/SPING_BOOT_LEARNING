package io.chetan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Owner {

	@Id
	@GeneratedValue
	private long pgOwnerId;
	
	@NotEmpty(message = "name nedded")
	private String firstName;
	
	@NotEmpty(message = "ph no neeeded")
	private String phoneNumber ;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	

}
