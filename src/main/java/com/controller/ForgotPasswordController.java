package com.controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

@WebServlet("/ForgotPasswordController")
public class ForgotPasswordController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		System.out.println("email =>" + email);
		UserDao userDao = new UserDao();

		UserBean user = userDao.getUserByEmail(email);

		if (user == null) {
			// invalid email
			request.setAttribute("error", "Invalid Email");
			request.getRequestDispatcher("ForgotPassword.jsp").forward(request, response);

		} else {
			// user found with email
			// now generate otp

			StringBuffer sb = new StringBuffer();

			for (int i = 1; i <= 6; i++) {
				int x = (int) (Math.random() * 9);
				sb.append(x);// 264059
			}
			String otp = sb.toString();// string buffer string
			System.out.println("OTP =>" + otp);

			// send mail

			// SMTP server information
			String host = "smtp.gmail.com";
			String port = "587";

			// Set properties for the SMTP server
			Properties properties = new Properties();
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.host", host);
			properties.put("mail.smtp.port", port);

			// Get the default Session object.
			Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("tejasshah2k19@gmail.com", "hygklhaurwdvavpx");
				}
			});

			try {
				// Create a default MimeMessage object.
				Message message = new MimeMessage(session);

				// Set From: header field
				message.setFrom(new InternetAddress("tejasshah2k19@gmail.com"));

				// Set To: header field
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));

				// Set Subject: header field
				message.setSubject("OTP For Update Password");

				// Set the actual message
				message.setText(otp);

				// Send message
				Transport.send(message);

				System.out.println("Sent message successfully...");

				
				//db otp set -> 
				//db query => column -> otp 
				//-> update users set otp = ? where email = ? 
				//dao 
				userDao.updateOtp(otp,email);
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}

			request.getRequestDispatcher("UpdatePassword.jsp").forward(request, response);

		}
	}

}
