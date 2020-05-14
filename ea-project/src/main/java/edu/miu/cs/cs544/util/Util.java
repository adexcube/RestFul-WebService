//package edu.miu.cs.cs544.util;
//
//
//import edu.miu.cs.cs544.domain.*;
//import edu.miu.cs.cs544.repository.AppointmentRepository;
//import edu.miu.cs.cs544.repository.ReservationRepository;
//import edu.miu.cs.cs544.service.AppointmentService;
//import edu.miu.cs.cs544.service.ReservationService;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.annotation.PostConstruct;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Query;
//import javax.sql.DataSource;
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.time.temporal.TemporalAmount;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Locale;
//
//@Component
//public class Util {
////
////
//////    public Util() {
//////        generateAppointmentsForLocation();
//////    }
////
////    public Util() {}
////
////    public SimpleDateFormat _12HourSDF = new SimpleDateFormat("hh:mm a");
////    public SimpleDateFormat _24HourSDF = new SimpleDateFormat("HH:mm");
////
////
////    //Schedule task at 12AM for the next day
//////    @Scheduled(cron = "0 0 0 * * ?")
////    @PostConstruct
////    public void generateAppointmentsForLocation() {
////        List<Appointment> appointmentsOfTheDay = new ArrayList<>();
////        String location = "Verill Hall";
////        LocalDate date = LocalDate.now();
////        String d = date.getMonthValue() + "/" + date.getDayOfMonth() + "/" + date.getYear();
////        User checker = new User("Checker", "Doe", "johndoe@gmail.com", "Male", "John", "123");
////
////        List<String> starts = null;
////        try {
////            starts = generateAppointmentStartTimes();
////        } catch (ParseException e) {
////            e.printStackTrace();
////        }
////        for (String s : starts) {
////            User user = new User("User-"+s, "Doe", "johndoe@gmail.com", "Male", "John", "123");
////            Appointment appointment = new Appointment(d, s, location);
////            appointment.setProvider(checker);
////            System.out.println(appointment.toString());
//////            appointmentRepository.save(appointment);
////            Reservation reservation = new Reservation(Status.ACCEPTED, new Date().toString(), user, appointment);
//////            reservationRepository.save(reservation);
//////            appointmentRepository.save(appointment);
////        }
////    }
////
////
////    public List<String> generateAppointmentStartTimes() throws ParseException {
////        List<String> t = new ArrayList<>();
////        LocalTime starttime = LocalTime.of(8, 30);
////        for(int i = 1 ; i <= 15; i++) {
////            starttime = starttime.plusMinutes(30);
////            Date _24HourDt = _24HourSDF.parse(String.valueOf(starttime));
////            t.add(_12HourSDF.format(_24HourDt));
////        }
////        return t;
////    }
//
////    private static final StandardServiceRegistry serviceRegistry;
//
//
//    @Autowired
//    private DataSource dataSource;
//
//
//    private JdbcTemplate jdbcTemplate;
//
//    public SimpleDateFormat _12HourSDF = new SimpleDateFormat("hh:mm a");
//    public SimpleDateFormat _24HourSDF = new SimpleDateFormat("HH:mm");
//
//    public void setDataSource(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//
//    public void setJdbcTemplate(DataSource dataSource) {
//        this.jdbcTemplate = new JdbcTemplate(dataSource);
//    }
//
//    public Util() {
//        System.out.println("----------------");
//        setJdbcTemplate(dataSource);
//    }
//    //Schedule task at 12AM for the next day
////    @Scheduled(cron = "0 0 0 * * ?")
////	@PostConstruct
//    public void generateAppointmentsForLocation() {
//        String location = "Verill Hall";
//        LocalDate date = LocalDate.now();
//        String d = date.getMonthValue() + "/" + date.getDayOfMonth() + "/" + date.getYear();
////        List<UserRole> roles = new ArrayList<>();
////        roles.add(new UserRole("Checker"));
//        User checker = new User("Checker", "Doe", "johndoe@gmail.com", "Male", "John", "123");
//        jdbcTemplate.update("insert into user (firstname, lastname, email, gender, username, password) values (?, ?, ?, ?, ?, ?)",
//                checker.getFirstname(), checker.getLastname(), checker.getEmail(), checker.getGender(), checker.getUsername(), checker.getPassword());
//        int checkerid = jdbcTemplate.queryForObject("SELECT id FROM user WHERE username = ?", new Object[]{checker.getUsername()}, Integer.class);
//        jdbcTemplate.update("insert into userrole (roleId, userId) values (?, ?)", Role.STUDENT.getNumVal(), checkerid);
//
//        List<String> starts = null;
//        try {
//            starts = generateAppointmentStartTimes();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        for (String s : starts) {
//            User user = new User("User", "Doe", "johndoe@gmail.com", "Male", "John"+s, "123");
//
//            jdbcTemplate.update("insert into user (firstname, lastname, email, gender, username, password) values (?, ?, ?, ?, ?, ?)",
//            user.getFirstname(), user.getLastname(), user.getEmail(), user.getGender(), user.getUsername(), user.getPassword());
//
//            int id = jdbcTemplate.queryForObject("SELECT id FROM user WHERE username = ?", new Object[]{user.getUsername()}, Integer.class);
//
//            jdbcTemplate.update("insert into userrole (roleId, userId) values (?, ?)", Role.STUDENT.getNumVal(), id);
//
////            System.out.println(appointment.toString());
//            Appointment appointment = new Appointment(d, s, location);
//            appointment.setProvider(checker);
//
//            jdbcTemplate.update("insert into appointment (date, location, time, provider_id) values (?,?,?,?)",
//                    d, location, s, checkerid);
////            createAppointment(appointment);
//
////            int id = jdbcTemplate.queryForObject("SELECT * FROM appointment WHERE username = ?", new Object[]{user.getUsername()}, Integer.class);
//
//            jdbcTemplate.update("insert into reservation (status, date, time, consumer, appointment) value (?,?,?,?)",
//                    Status.PENDING, LocalDate.now().toString(), LocalTime.now().toString(), user, appointment);
////            appointmentRepository.save(appointment);
//        }
//    }
//
//
//    public List<String> generateAppointmentStartTimes() throws ParseException {
//        List<String> t = new ArrayList<>();
//        LocalTime starttime = LocalTime.of(8, 30);
//        for(int i = 1 ; i <= 15; i++) {
//            starttime = starttime.plusMinutes(30);
//            Date _24HourDt = _24HourSDF.parse(String.valueOf(starttime));
//            t.add(_12HourSDF.format(_24HourDt));
//        }
//        return t;
//    }
//
//
//}
