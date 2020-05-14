/*
 * By Birhane Geber
 * Since : May 2020
 * 
 *  Description: Cron based Scheduler for reserveration email sending and remainder notification 
 *  from database table 
 * */

package edu.miu.cs.cs544.util.mail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CronJob {

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String from;

	public enum STATUS {
		PENDING, APPROVED, DECLINE, HANDLED
	}

	public void setMailSender(JavaMailSender javaMailSender) {

		this.javaMailSender = javaMailSender;
	}

	public JavaMailSender getJavaMailSender() {
		return javaMailSender;
	}

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	/**
	 * trigger every 10 seconds for email response for accept/reject reservation
	 */

	@Scheduled(cron = "0/10 * * * * *")
	public void emailAppointmentStatus() {

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

				String to = email;
				String subject = "your Appointment Approved";
				String body = " Dear " + firstname + " " + lastname + ",";
				body += " your Appointment  on " + dateAndTime + " is Approved";

				SimpleMailMessage emailMessage = new SimpleMailMessage();

				emailMessage.setFrom(from);
				emailMessage.setTo(to);
				emailMessage.setSubject(subject);
				emailMessage.setText(body);

				javaMailSender.send(emailMessage);

			}

		} catch (Exception e) {
			// TODO: handle exception

			e.getStackTrace();
		}
	}

	/**
	 * trigger at 10 AM every Monday-Friday
	 * 
	 * @Scheduled(cron = "15 * * * * * MON-FRI") //for testing
	 */

	// @Scheduled(cron = "0 0 10 ? * MON-FRI")
	public void emailRemainder() {

		try {
			Email email = new Email();
			email.appointmentReminder();
			System.out.println("Email.appointmentReminder():  run every Day at 10:00 AM to Remaind Students ");

		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}

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

}