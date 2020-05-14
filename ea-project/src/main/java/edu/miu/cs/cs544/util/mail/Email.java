package edu.miu.cs.cs544.util.mail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class Email {

	@Autowired
	private JavaMailSender javaMailSender;

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

	public static void notificationAppointmentStatus() throws SQLException {

		Connection connection = null;
		Statement insertStmt = null;
		Statement selectStmt = null;

		try {

			StringBuffer sb = new StringBuffer();
			Connection con = getConnection();
			selectStmt = con.createStatement();
			ResultSet rs = selectStmt.executeQuery("SELECT * FROM email  where email_status='pending'");

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
				// System.out.println(sb.toString());
			}

		} catch (Exception e) {

			// e.printStackTrace();
		}
	}

	public static void appointmentReminder() throws SQLException {

		Connection connection = null;
		Statement insertStmt = null;
		Statement selectStmt = null;

		try {

			StringBuffer sb = new StringBuffer();
			Connection con = getConnection();
			selectStmt = con.createStatement();
			ResultSet rs = selectStmt.executeQuery("SELECT * FROM email  where email_status='pending'");

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
				// System.out.println(sb.toString());
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

		// insert into db then use cron to send Asyn. way
		try {

			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into email(email_id,email_from,email_to,email_subject,email_body,email_date,email_status) values(?,?,?,?,?,?,?)");

			Date date = Calendar.getInstance().getTime();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
			String strDate = dateFormat.format(date);

			ps.setString(1, null);
			ps.setString(2, from);
			ps.setString(3, to);
			ps.setString(4, subject);
			ps.setString(5, body);
			ps.setString(6, strDate);
			ps.setString(7, "pending");

			int i = ps.executeUpdate();
			System.out.println(i + " records inserted");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

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
