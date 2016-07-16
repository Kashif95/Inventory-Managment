package com.seller.managment.fms.order;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;
 
public class sendSMS {
	
	@Test
	public void sendSms() {
		try {
			// Construct data
			String user = "username=" + "rakhime3@gmail.com";
			String hash = "&hash=" + "Jaimatadi3";
			String message = "&message=" + "Hi,Test Message";
			String sender = "&sender=" + "TXTLCL";
			String numbers = "&numbers=" + "9620078944";
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("http://api.textlocal.in/send/?").openConnection();
			String data = user + hash + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			
			System.out.println(stringBuffer.toString());
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			
		}
	}
}
