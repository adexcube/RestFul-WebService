package edu.miu.cs.cs544.util;


import edu.miu.cs.cs544.domain.Appointment;
import edu.miu.cs.cs544.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Util {

    public List<Appointment> generateAppointments() {
//        Date date = new Date();
//        int [][] appointments = new int[14][20];
        List<Appointment> appointments = new ArrayList<>();
        LocalDate date = LocalDate.now();

        if(date.getDayOfMonth() == 30 || date.getDayOfMonth() == 31) {
            if(date.getMonthValue() + 1 < 13) {
//                Appointment appointment = new Appointment()
//                date.getMonthValue() + 1
            }
        }
        return null;
    }

    @Autowired
    private static AppointmentService appointmentService;

    public static void main(String [] args) {
//        appointmentService.createAppointment(new Appointment(LocalDate));

    }

}
