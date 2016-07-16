/**
 * 
 */
package com.sellar.managment.fms.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import com.sellar.managment.fms.FMSCustomException;
import com.sellar.managment.fms.user.domain.UserDetails;


/**
 * @author rakumari
 *
 */
@Service
public class EmailService {
	
	final static String username = "prasadfertilizernokha@gmail.com";
	final static String password = "jaimatadi3";

	public void SendEmail(String emailSubject,String emailMessage,String recepintEmailAdd){
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props,
				  new javax.mail.Authenticator() {
					protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
						return new javax.mail.PasswordAuthentication(username, password);
					}
				  });

				try {

					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress("prasadfertilizernokha@gmail.com"));
					message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(recepintEmailAdd));
					message.setSubject(emailSubject);
					message.setText(emailMessage);
					Transport.send(message);
				} catch (MessagingException e) {
					throw new FMSCustomException("error in sending sms" + e.getMessage());
				}
	}

}
