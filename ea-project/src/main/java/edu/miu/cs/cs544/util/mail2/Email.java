package edu.miu.cs.cs544.util.mail2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class Email {

	@Autowired
	private JavaMailSender javaMailSender;

	public enum STATUS {
		PENDING, APPROVED, DECLINE
	}

	public void setMailSender(JavaMailSender javaMailSender) {

		this.javaMailSender = javaMailSender;
	}

	public static Connection getConnection() {
		Connection con = null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cs544", "ea", "ea123");

		} catch (Exception e) {

			System.out.println(e);
		}

		return con;
	}

	public void notificationAppointmentStatus() throws SQLException {

		Connection connection = null;
		Statement insertStmt = null;
		Statement selectStmt = null;

		System.out.println("Table contains ows");

		try {

			System.out.println("inside try ");

			StringBuffer sb = new StringBuffer();
			Connection con = getConnection();
			selectStmt = con.createStatement();
			ResultSet rs = selectStmt.executeQuery("SELECT u.firstname, u.lastname,u.email,r.dateAndTime "
					+ "FROM reservation r JOIN user u " + "on r.consumer_id=u.id and r.status=2");

			while (rs.next()) {

				System.out.println("Email processing .... ");

				String firstname = rs.getString(1);
				String lastname = rs.getString(2);
				String email = rs.getString(3);
				String dateAndTime = rs.getString(4);

				String from = "birg20@gmail.com";
				String to = email;
				String subject = "your Appointment Approved";
				String body = " Dear " + firstname + " " + lastname + ",";
				body += " your Appointment  on " + dateAndTime + " is Approved";

				System.out.println("from:  " + from);
				System.out.println("to:  " + to);
				System.out.println("subject: " + subject);
				System.out.println("body:  " + body);

				sendEmail(from, to, subject, body);

				SimpleMailMessage msg = new SimpleMailMessage();
				msg.setFrom("birg20@gmail.com");
				msg.setTo("birg2000@gmail.com");
				msg.setSubject("Testing from Spring Boot");
				msg.setText("Hello World \n Spring Boot Email");

				// javaMailSender.send(msg);

				// javaMailSender.send(simpleMailMessage);
				System.out.println("Email sent to " + email);
			}

		} catch (Exception e) {

			// e.printStackTrace();
		}
	}

	public void appointmentReminder() throws SQLException {

		Connection connection = null;
		Statement insertStmt = null;
		Statement selectStmt = null;

		try {

			StringBuffer sb = new StringBuffer();
			Connection con = getConnection();
			selectStmt = con.createStatement();
			ResultSet rs = selectStmt.executeQuery(
					"SELECT u.firstname, u.lastname, u.email FROM reservation r JOIN user u on r.consumer_id=u.id and r.status=2");

			System.out.println("Table contains " + rs.getInt("count(*)") + " rows");

			while (rs.next()) {

				System.out.println("Email processing .... ");

				sb.append("ID: " + rs.getString(1));
				sb.append("From: " + rs.getString(2));
				sb.append("To : " + rs.getString(3));
				sb.append("Subject: " + rs.getString(4));
				sb.append("Body: " + rs.getString(5));
				sb.append("Date : " + rs.getString(6));
				sb.append("status : " + rs.getString(7));

				System.out.println(sb.toString());
			}

		} catch (Exception e) {

			// e.printStackTrace();
		}
	}

	public void sendEmail(String from, String to, String subject, String body) {

		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

		simpleMailMessage.setFrom(from);
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(body);

		javaMailSender.send(simpleMailMessage);
	}

	public void sendEmail() {

		SimpleMailMessage msg = new SimpleMailMessage();

		msg.setFrom("birg20@gmail.com");
		msg.setTo("birg2000@gmail.com", "birg20@gmail.com");
		msg.setSubject("Testing from Spring Boot");
		msg.setText("Hello World \n Spring Boot Email");

		javaMailSender.send(msg);

	}
}
