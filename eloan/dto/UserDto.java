package com.iiht.training.eloan.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto {
	
	private Long id;
	
	@NotNull(message="First Name is mandatory")
	@NotBlank(message="First Name cannot be null")
	@Size(min=4,max=50, message="First Name must be 3 to 100 chars in length")
	private String firstName;
	
	@NotNull(message="Last Name is mandatory")
	@NotBlank(message="Last Name cannot be null")
	@Size(min=4,max=50, message="Last Name must be 3 to 100 chars in length")
	private String lastName;
	
	@Email
	@NotNull(message="Email is mandatory")
	@NotBlank(message="Email cannot be null")
	@Size(min=4,max=50, message="Email must be 3 to 100 chars in length")
	private String email;
	
	@NotNull(message="Mobile number is mandate")
	@NotBlank(message="Mobile number is mandate")
	@Pattern(regexp = "[1-9][0-9]{9}",message = "Mobile number must be exactly ten digits")
	private String mobile;
	
	private String role;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
}
