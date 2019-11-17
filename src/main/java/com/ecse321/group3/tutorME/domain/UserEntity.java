package com.ecse321.group3.tutorME.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public abstract class UserEntity {

	@Id
    @NotNull
	private String email;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	private Boolean isVerified;

	@Column
	private String password;

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

	public Boolean getVerified() {
		return isVerified;
	}

	public void setVerified(Boolean verified) {
		isVerified = verified;
	}
}
