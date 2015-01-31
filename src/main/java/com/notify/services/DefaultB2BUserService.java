package com.notify.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.notify.dao.B2BUserDAO;
import com.notify.model.B2BUser;

public class DefaultB2BUserService  implements B2BUserService{

	
	@Autowired
	B2BUserDAO b2bUserDAO;
	
	@Autowired
	NotifyMailService notifyMailService;
	
	public B2BUser getB2BUser(String email)
	{
		return b2bUserDAO.getB2BUser(email);
		
	}
	
	public boolean sendEmailForgottenPassword(B2BUser b2bUser)
	{
		String body ="Dear "+b2bUser.getFirstName() +"," +"Your Password is "+b2bUser.getPassword();
		return notifyMailService.sendmail(b2bUser.getEmail(), "Forgotten Password", body);
	}

	public B2BUserDAO getB2bUserDAO() {
		return b2bUserDAO;
	}

	public void setB2bUserDAO(B2BUserDAO b2bUserDAO) {
		this.b2bUserDAO = b2bUserDAO;
	}

	public NotifyMailService getNotifyMailService() {
		return notifyMailService;
	}

	public void setNotifyMailService(NotifyMailService notifyMailService) {
		this.notifyMailService = notifyMailService;
	}
	
	
	
	
	
	
	
}
