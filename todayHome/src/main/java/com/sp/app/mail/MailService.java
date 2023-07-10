package com.sp.app.mail;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import com.sp.app.domain.mail.Mail;

public interface MailService {
	
	void makeMessage(Message msg, Mail mail) throws MessagingException;
	
	boolean mailSend(Mail mail) throws Exception;
	
	String resetPwd(HttpSession session) throws Exception;
	
}
