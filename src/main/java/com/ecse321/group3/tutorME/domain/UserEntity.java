package com.ecse321.group3.tutorME.domain;

import javax.persistence.*;

@Entity
@Table(name = "userentity")
public class UserEntity {

	@Id
	private String email;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	private Boolean isVerified;

	@Column
	private String password;

	@OneToOne
	private UserRole userRole;

	public UserEntity() {}

	public UserEntity(String email, String firstName, String lastName, Boolean isVerified, String password, UserRole userRole) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isVerified = isVerified;
		this.password = password;
		this.userRole = userRole;
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

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
}
