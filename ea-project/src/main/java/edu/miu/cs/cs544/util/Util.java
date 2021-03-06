package edu.miu.cs.cs544.util;

import edu.miu.cs.cs544.domain.Appointment;
import edu.miu.cs.cs544.domain.Role;
import edu.miu.cs.cs544.domain.Status;
import edu.miu.cs.cs544.domain.User;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static edu.miu.cs.cs544.util.Database.*;

public class Util {



	public static void main(String[] args) {
		generateAppointmentsForLocation();
	}

	public static void generateAppointmentsForLocation() {
		String location = "Verill Hall";
		LocalDate date = LocalDate.now();
		String d = date.getMonthValue() + "/" + date.getDayOfMonth() + "/" + date.getYear();

		User admin = new User("Admin", "Doe", "admin@gmail.com", "Male", "John Admin", "123");
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into user (id, firstname, lastname, email, gender, username, password) values (?, ?, ?, ?, ?, ?, ?)");

			ps.setString(1, null);
			ps.setString(2, admin.getFirstname());
			ps.setString(3, admin.getLastname());
			ps.setString(4, admin.getEmail());
			ps.setString(5, admin.getGender());
			ps.setString(6, admin.getUsername());
			ps.setString(7, admin.getPassword());

			int i = ps.executeUpdate();
			System.out.println(i + " records");
		} catch (Exception e) {
			System.err.println(e);
		}
		
		int adminid = 0;
		try {
			Connection con = getConnection();
			ResultSet rs = con.createStatement()
					.executeQuery("select id from user where username = '" + admin.getUsername() + "'");
			while (rs.next()) {
				System.out.println("id >>>>>>>>" + rs.getInt(1));
				adminid = rs.getInt(1);
			}

		} catch (Exception e) {
			System.err.println(e);
		}
		
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("insert into userrole (roleid, user_id) values (?, ?)");
			
			ps.setInt(1, Role.ADMIN.getNumVal());
			ps.setInt(2, adminid);
			

			int j = ps.executeUpdate();
			System.out.println(j + " records userrole 1");
		} catch (Exception e) {
			System.err.println(e);
		}

		User checker = new User("Checker", "Doe", "johndoe@gmail.com", "Male", "John", "123");
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into user (id, firstname, lastname, email, gender, username, password) values (?, ?, ?, ?, ?, ?, ?)");

			ps.setString(1, null);
			ps.setString(2, checker.getFirstname());
			ps.setString(3, checker.getLastname());
			ps.setString(4, checker.getEmail());
			ps.setString(5, checker.getGender());
			ps.setString(6, checker.getUsername());
			ps.setString(7, checker.getPassword());
			

			int i = ps.executeUpdate();
			System.out.println(i + " records");
		} catch (Exception e) {
			System.err.println(e);
		}

		System.out.println(checker.getUsername());
		int checkerid = 0;
		try {
			Connection con = getConnection();
			ResultSet rs = con.createStatement()
					.executeQuery("select id from user where username = '" + checker.getUsername() + "'");
			while (rs.next()) {
				System.out.println("id >>>>>>>>" + rs.getInt(1));
				checkerid = rs.getInt(1);
			}

		} catch (Exception e) {
			System.err.println(e);
		}
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("insert into userrole (roleid, user_id) values (?, ?)");
			
			ps.setInt(1, Role.CHECKER.getNumVal());
			ps.setInt(2, checkerid);
			

			int j = ps.executeUpdate();
			System.out.println(j + " records userrole 2");
		} catch (Exception e) {
			System.err.println(e);
		}

		List<String> starts = null;
		try {
			starts = generateAppointmentStartTimes();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		for (String s : starts) {
			User user = new User("User", "Doe", "johndoe@gmail.com", "Male", "John" + s, "123");

			try {
				Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(
						"insert into user (id, firstname, lastname, email, gender, username, password) values (?, ?, ?, ?, ?, ?, ?)");
				ps.setString(1, null);
				ps.setString(2, user.getFirstname());
				ps.setString(3, user.getLastname());
				ps.setString(4, user.getEmail());
				ps.setString(5, user.getGender());
				ps.setString(6, user.getUsername());
				ps.setString(7, user.getPassword());

				int i = ps.executeUpdate();
				System.out.println(i + " records user 1");
			} catch (Exception e) {
				System.err.println(e);
			}

			int userid = 0;
			try {
				Connection con = getConnection();
				ResultSet rs = con.createStatement()
						.executeQuery("select id from user where username = '" + user.getUsername() + "'");
				while (rs.next()) {
					System.out.println("id >>>>>>>>" + rs.getInt(1));
					userid = rs.getInt(1);
				}
			} catch (Exception e) {
				System.err.println(e);
			}
			
			try {
				Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement("insert into userrole (roleid, user_id) values (?, ?)");
				ps.setInt(1, Role.STUDENT.getNumVal());
				ps.setInt(2, userid);
				

				int j = ps.executeUpdate();
				System.out.println(j + " records userrole 1");
			} catch (Exception e) {
				System.err.println(e);
			}

			Appointment appointment = new Appointment(d, s, location);

			System.out.println("------------------ " + checkerid);
			try {
				Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(
						"insert into appointment (id, date, location, time, provider_id) values (?, ?, ?, ?, ?)");
				ps.setString(1, null);
				ps.setString(2, d);
				ps.setString(3, location);
				ps.setString(4, s);
				ps.setInt(5, checkerid);

				int i = ps.executeUpdate();
				System.out.println(i + " records appointment");
			} catch (Exception e) {
				System.err.println(e);
			}

			int appointmentid = 0;
			try {
				Connection con = getConnection();
				ResultSet rs = con.createStatement()
						.executeQuery("select id from appointment order by date desc LIMIT 1");
				while (rs.next()) {
					System.out.println("id >>>>>>>>" + rs.getInt(1));
					appointmentid = rs.getInt(1);
				}
			} catch (Exception e) {
				System.err.println(e);
			}

			try {
				Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(
						"insert into reservation (id, status, date, time, consumer_id, appointment_id) values (?, ?, ?, ?, ?, ?)");
				ps.setString(1, null);
				ps.setInt(2, Status.PENDING.getNumVal());
				ps.setString(3, LocalDate.now().toString());
				ps.setString(4, LocalTime.now().toString());
				ps.setInt(5, userid);
				ps.setInt(6, appointmentid);

				int i = ps.executeUpdate();
				System.out.println(i + " records reservation");
			} catch (Exception e) {
				System.err.println(e);
			}
		}
	}

}
