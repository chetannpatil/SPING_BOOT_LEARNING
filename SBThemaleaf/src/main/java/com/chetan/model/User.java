package com.chetan.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User 
{
	
	@NotNull
	@Size(min = 3,max = 10)
	private String userId;
	
	@NotNull
	@Size(min = 5,max = 20)
	private String userName ;
	
	@NotNull
	private String gender ;
	
	private String profile ;
	
	private boolean married ;

	public User(@NotNull @Size(min = 3, max = 10) String userId, @NotNull @Size(min = 5, max = 20) String userName,
			@NotNull String gender, String profile, boolean married) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.gender = gender;
		this.profile = profile;
		this.married = married;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", gender=" + gender + ", profile=" + profile
				+ ", married=" + married + "]";
	}
	
	

}
