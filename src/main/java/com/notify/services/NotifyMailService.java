package com.notify.services;

public interface NotifyMailService {

	public boolean sendmail(String to,String Subject,String body);
}
