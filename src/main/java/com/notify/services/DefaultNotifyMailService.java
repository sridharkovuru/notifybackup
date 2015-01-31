package com.notify.services;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;

public class DefaultNotifyMailService implements NotifyMailService {

	@Autowired
	private JavaMailSender mailSender;
	private Logger log = Logger.getLogger(DefaultNotifyMailService.class);

	public boolean sendmail(final String to,final String subject,final String body) {
		boolean success = true;
		try {
			
		//	mailSender.send(simpleMailMessage);
	        MimeMessagePreparator messagePreparator = new MimeMessagePreparator() {  
	              
                public void prepare(MimeMessage mimeMessage) throws Exception {  
                   mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress(to));  
                   mimeMessage.setFrom(new InternetAddress("testnotifymail@gmail.com"));  
                   mimeMessage.setSubject(subject);  
                   mimeMessage.setText(body);  
                }  
        };  
        mailSender.send(messagePreparator);  
			
		} catch (Exception e) {
			success = false;
			log.debug("Error While Sending email " + e.getMessage());
		}
		return success;
	}

}
