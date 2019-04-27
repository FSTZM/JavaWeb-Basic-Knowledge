package com.itheima.product.util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendJMail {
	
		public static boolean sendMail(String email, String emailMsg) {
		
		String from = "dianemax@163.com";        
		String to = email; 									
		final String username = "dianemax@163.com";  	
		final String password = "suyuqin1995128";   				


		
		Properties props = System.getProperties();

		
		props.setProperty("mail.smtp.host", "smtp.163.com"); 
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.transport.protocol", "smtp");

		Session session = Session.getInstance(props);

		session.setDebug(true);
		try {
			//Message
			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress(from));

			message.setSubject("激活邮件");
			//message.setText("Welcome to JavaMail World!");
			message.setContent((emailMsg),"text/html;charset=utf-8");
			Transport transport=session.getTransport();
			transport.connect("smtp.163.com",25, username, password);
			transport.sendMessage(message,new Address[]{new InternetAddress(to)});
			transport.close();
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
