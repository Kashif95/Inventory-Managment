/**
 * 
 */
package com.sellar.managment.fms.sms;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author rakumari
 *
 */
public class SendEmail {
	

		public static void main(String[] args) {

			final String username = "prasadfertilizernokha@gmail.com";
			final String password = "jaimatadi3";

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
					InternetAddress.parse("rakhime3@gmail.com"));
				message.setSubject("Account Creation Notification");
				message.setText("Dear " +  "ddasd" +","
					+ "\n\n Your account has been created on Prasad Fertilizer. Your username is " + "aasda" +" and password is " + "sadas"+ ". Please click on this url http://pf-rakhitest.rhcloud.com/inventory/login to login." +
					"\n\n Regards,"
					+"\n\n Admin"
					 +"\n\n Prasad Fertilzer");


				Transport.send(message);

				System.out.println("Done");

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		}

}
