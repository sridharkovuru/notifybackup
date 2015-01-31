package com.notify.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

public class ForgotPwd {

	@NotNull
    @Email
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
