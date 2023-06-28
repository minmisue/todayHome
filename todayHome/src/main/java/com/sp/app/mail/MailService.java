package com.sp.app.mail;


import javax.mail.Message;
import javax.mail.MessagingException;

import com.sp.app.domain.mail.Mail;

public interface MailService {
	
	void makeMessage(Message msg, Mail mail) throws MessagingException;
	
	boolean mailSend(Mail mail) throws Exception;
	
}
