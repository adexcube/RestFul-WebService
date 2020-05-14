package edu.miu.cs.cs544.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Database {


    public static SimpleDateFormat _12HourSDF = new SimpleDateFormat("hh:mm a");
    public static SimpleDateFormat _24HourSDF = new SimpleDateFormat("HH:mm");
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

    public static List<String> generateAppointmentStartTimes() throws ParseException {
        List<String> t = new ArrayList<>();
        LocalTime starttime = LocalTime.of(8, 30);
        for (int i = 1; i <= 15; i++) {
            starttime = starttime.plusMinutes(30);
            Date _24HourDt = _24HourSDF.parse(String.valueOf(starttime));
            t.add(_12HourSDF.format(_24HourDt));
        }
        return t;
    }

}
