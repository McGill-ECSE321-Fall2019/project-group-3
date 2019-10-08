package com.ecse321.group3.tutorME.domain;

public class UserEntity {
	private String firstName;
	private String lastName;
	private Boolean isVerified;
	private String email;
	private String password;
	public UserEntity() {}
	public UserEntity(String firstname, String lastname, Boolean isVerified, String email, String password) {
		super();
		this.firstName = firstname;
		this.lastName = lastname;
		this.isVerified = isVerified;
		this.email = email;
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Boolean getIsVerified() {
		return isVerified;
	}
	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
