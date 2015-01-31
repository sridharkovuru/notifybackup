package com.notify.services;

import com.notify.model.B2BUser;

public interface B2BUserService {

	 B2BUser getB2BUser(String email);
	 boolean sendEmailForgottenPassword(B2BUser b2bUser);
}
