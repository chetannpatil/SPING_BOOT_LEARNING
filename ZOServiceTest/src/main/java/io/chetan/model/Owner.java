package io.chetan.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Owner {


	
	@NotEmpty(message = "firstnmae cant be empty")
	private String firstName;
	
	
	@NotEmpty(message = "phone number neeeded")
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
