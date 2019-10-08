package com.ecse321.group3.tutorME.domain;

public class UserEntity {
	private String firstname;
	private String lastname;
	private Boolean isVerified;
	private String email;
	private String password;
	public UserEntity() {}
	public UserEntity(String firstname, String lastname, Boolean isVerified, String email, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.isVerified = isVerified;
		this.email = email;
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
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
