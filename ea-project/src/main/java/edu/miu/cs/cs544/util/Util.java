package edu.miu.cs.cs544.util;


import edu.miu.cs.cs544.domain.*;
import edu.miu.cs.cs544.repository.AppointmentRepository;
import edu.miu.cs.cs544.repository.ReservationRepository;
import edu.miu.cs.cs544.service.AppointmentService;
import edu.miu.cs.cs544.service.ReservationService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Util {
//
//
////    public Util() {
////        generateAppointmentsForLocation();
////    }
//
//    public Util() {}
//
//    public SimpleDateFormat _12HourSDF = new SimpleDateFormat("hh:mm a");
//    public SimpleDateFormat _24HourSDF = new SimpleDateFormat("HH:mm");
//
//
//    //Schedule task at 12AM for the next day
////    @Scheduled(cron = "0 0 0 * * ?")
//    @PostConstruct
//    public void generateAppointmentsForLocation() {
//        List<Appointment> appointmentsOfTheDay = new ArrayList<>();
//        String location = "Verill Hall";
//        LocalDate date = LocalDate.now();
//        String d = date.getMonthValue() + "/" + date.getDayOfMonth() + "/" + date.getYear();
//        User checker = new User("Checker", "Doe", "johndoe@gmail.com", "Male", "John", "123");
//
//        List<String> starts = null;
//        try {
//            starts = generateAppointmentStartTimes();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        for (String s : starts) {
//            User user = new User("User-"+s, "Doe", "johndoe@gmail.com", "Male", "John", "123");
//            Appointment appointment = new Appointment(d, s, location);
//            appointment.setProvider(checker);
//            System.out.println(appointment.toString());
////            appointmentRepository.save(appointment);
//            Reservation reservation = new Reservation(Status.ACCEPTED, new Date().toString(), user, appointment);
////            reservationRepository.save(reservation);
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

    @Autowired
    private SessionFactory sf = new Ses;

    public SimpleDateFormat _12HourSDF = new SimpleDateFormat("hh:mm a");
    public SimpleDateFormat _24HourSDF = new SimpleDateFormat("HH:mm");


    //Schedule task at 12AM for the next day
//    @Scheduled(cron = "0 0 0 * * ?")
//	@PostConstruct
    public void generateAppointmentsForLocation() {
        String location = "Verill Hall";
        LocalDate date = LocalDate.now();
        String d = date.getMonthValue() + "/" + date.getDayOfMonth() + "/" + date.getYear();
        List<UserRole> roles = new ArrayList<>();
        roles.add(new UserRole("Checker"));
        User checker = new User("Checker", "Doe", "johndoe@gmail.com", "Male", "John", "123", roles);
        List<String> starts = null;
        try {
            starts = generateAppointmentStartTimes();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<UserRole> userroles = new ArrayList<>();
        userroles.add(new UserRole("User"));
        for (String s : starts) {
            User user = new User("User-"+s, "Doe", "johndoe@gmail.com", "Male", "John", "123", userroles);
            Appointment appointment = new Appointment(d, s, location);
            appointment.setProvider(checker);
            System.out.println(appointment.toString());
            createAppointment(appointment);
            Reservation reservation = new Reservation(Status.ACCEPTED, new Date().toString(), user, appointment);
            reservationService.createReservation(reservation);
//            appointmentRepository.save(appointment);
        }
    }


    public List<String> generateAppointmentStartTimes() throws ParseException {
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
