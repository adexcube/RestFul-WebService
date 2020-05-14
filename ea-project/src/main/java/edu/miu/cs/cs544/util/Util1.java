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

public class Util1 {

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
    public static SimpleDateFormat _12HourSDF = new SimpleDateFormat("hh:mm a");
    public static SimpleDateFormat _24HourSDF = new SimpleDateFormat("HH:mm");

    public static void main(String [] args) {
        generateAppointmentsForLocation();
    }





    public static void generateAppointmentsForLocation() {
        String location = "Verill Hall";
        LocalDate date = LocalDate.now();
        String d = date.getMonthValue() + "/" + date.getDayOfMonth() + "/" + date.getYear();
//        List<UserRole> roles = new ArrayList<>();
//        roles.add(new UserRole("Checker"));


        User checker = new User("Checker", "Doe", "johndoe@gmail.com", "Male", "John", "123");
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("insert into user (id, firstname, lastname, email, gender, username, password) values (?, ?, ?, ?, ?, ?, ?)");

            ps.setString(1, null);
            ps.setString(2, checker.getFirstname());
            ps.setString(3, checker.getLastname());
            ps.setString(4, checker.getEmail());
            ps.setString(5, checker.getGender());
            ps.setString(6, checker.getUsername());
            ps.setString(7, checker.getPassword());

            int i = ps.executeUpdate();
            System.out.println(i + " records");
        } catch (Exception e){
            System.err.println(e);
        }

//        int checkerid = jdbcTemplate.queryForObject("SELECT id FROM user WHERE username = ?", new Object[]{checker.getUsername()}, Integer.class);


        System.out.println(checker.getUsername());
        int checkerid = 0;
        try {
            Connection con = getConnection();
            ResultSet rs = con.createStatement().executeQuery("select id from user where username = '" + checker.getUsername() + "'");
            while (rs.next()) {
                System.out.println("id >>>>>>>>" + rs.getInt(1));
                checkerid = rs.getInt(1);}

//            checkerid = rs.getInt(1);
        } catch (Exception e){
            System.err.println(e);
        }




        try {
//            insert into userrole (roleId, userId) values (?, ?)", Role.STUDENT.getNumVal(), checkerid
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("insert into userrole (roleId, userId) values ( ?, ?)");
//            ps.setInt(1, 0);
            ps.setInt(1, Role.CHECKER.getNumVal());
            ps.setInt(2, checkerid);
            System.out.println(checkerid);
            int i = ps.executeUpdate();
            System.out.println(i + " records userrole 1");
        } catch (Exception e){
            System.err.println(e);
        }

        List<String> starts = null;
        try {
            starts = generateAppointmentStartTimes();
        } catch (ParseException e) {
            e.printStackTrace();
        }



//        jdbcTemplate.update("insert into user (firstname, lastname, email, gender, username, password) values (?, ?, ?, ?, ?, ?)",
//                checker.getFirstname(), checker.getLastname(), checker.getEmail(), checker.getGender(), checker.getUsername(), checker.getPassword());
//        int checkerid = jdbcTemplate.queryForObject("SELECT id FROM user WHERE username = ?", new Object[]{checker.getUsername()}, Integer.class);
//        jdbcTemplate.update("insert into userrole (roleId, userId) values (?, ?)", Role.STUDENT.getNumVal(), checkerid);



        for (String s : starts) {
            User user = new User("User", "Doe", "johndoe@gmail.com", "Male", "John"+s, "123");


            try {
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("insert into user (id, firstname, lastname, email, gender, username, password) values (?, ?, ?, ?, ?, ?, ?)");
                ps.setString(1, null);
                ps.setString(2, user.getFirstname());
                ps.setString(3, user.getLastname());
                ps.setString(4, user.getEmail());
                ps.setString(5, user.getGender());
                ps.setString(6, user.getUsername());
                ps.setString(7, user.getPassword());

                int i = ps.executeUpdate();
                System.out.println(i + " records user 1");
            } catch (Exception e){
                System.err.println(e);
            }

            int userid = 0;
            try {
                Connection con = getConnection();
                System.out.println("=============");
                System.out.println(user.getUsername());
                ResultSet rs = con.createStatement().executeQuery("select * from user");
                userid = rs.getInt(1);
                System.out.println(userid);
                while (rs.next()) {
                    System.out.println("---");

                    if(rs.getString(3).equals(user.getUsername())) {
                        System.out.println(rs.getString(3));
                        System.out.println(user.getUsername());
                        userid = rs.getInt(1);
                    }
                }



                System.out.println("========~22=====");
                System.out.println(userid);
            } catch (Exception e){
                System.err.println(e);
            }

            try {
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("insert into userrole (id, roleId, userId) values (?, ?, ?)");
                ps.setString(1, null);
                ps.setInt(2, Role.STUDENT.getNumVal());
                ps.setInt(3, userid);

                int i = ps.executeUpdate();
                System.out.println(i + " records userrole 2");
            } catch (Exception e){
                System.err.println(e);
            }




//            jdbcTemplate.update("insert into user (firstname, lastname, email, gender, username, password) values (?, ?, ?, ?, ?, ?)",
//                    user.getFirstname(), user.getLastname(), user.getEmail(), user.getGender(), user.getUsername(), user.getPassword());

//            int id = jdbcTemplate.queryForObject("SELECT id FROM user WHERE username = ?", new Object[]{user.getUsername()}, Integer.class);

//            jdbcTemplate.update("insert into userrole (roleId, userId) values (?, ?)", Role.STUDENT.getNumVal(), userid);

//            System.out.println(appointment.toString());
            Appointment appointment = new Appointment(d, s, location);
            appointment.setProvider(checker);

            System.out.println("------------------ "+checkerid);
            try {
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("insert into appointment (id, date, location, time, provider_id) values (?, ?, ?, ?, ?)");
                ps.setString(1, null);
                ps.setString(2, d);
                ps.setString(3, location);
                ps.setString(4, s);
                ps.setInt(5, checkerid);

                int i = ps.executeUpdate();
                System.out.println(i + " records appointment");
            } catch (Exception e){
                System.err.println(e);
            }


            try {
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("insert into reservation (id, status, date, time, consumer, appointment) values (?, ?, ?, ?, ?, ?)");
                ps.setString(1, null);
                ps.setObject(2, Status.PENDING);
                ps.setString(3, LocalDate.now().toString());
                ps.setString(4, LocalTime.now().toString());
                ps.setObject(5, user);
                ps.setObject(6, appointment);

                int i = ps.executeUpdate();
                System.out.println(i + " records reservation");
            } catch (Exception e){
                System.err.println(e);
            }

//            jdbcTemplate.update("insert into appointment (date, location, time, provider_id) values (?,?,?,?)",
//                    d, location, s, checkerid);
//            createAppointment(appointment);

//            int id = jdbcTemplate.queryForObject("SELECT * FROM appointment WHERE username = ?", new Object[]{user.getUsername()}, Integer.class);

//            jdbcTemplate.update("insert into reservation (status, date, time, consumer, appointment) value (?,?,?,?)",
//                    Status.PENDING, LocalDate.now().toString(), LocalTime.now().toString(), user, appointment);
//            appointmentRepository.save(appointment);
        }
    }


    public static List<String> generateAppointmentStartTimes() throws ParseException {
        List<String> t = new ArrayList<>();
        LocalTime starttime = LocalTime.of(8, 30);
        for(int i = 1 ; i <= 15; i++) {
            starttime = starttime.plusMinutes(30);
            Date _24HourDt = _24HourSDF.parse(String.valueOf(starttime));
            t.add(_12HourSDF.format(_24HourDt));
        }
        return t;
    }

}
