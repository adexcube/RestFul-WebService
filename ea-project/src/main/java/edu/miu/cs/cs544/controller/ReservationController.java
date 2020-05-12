package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.domain.Appointment;
import edu.miu.cs.cs544.domain.Reservation;
import edu.miu.cs.cs544.domain.Status;
import edu.miu.cs.cs544.domain.User;
import edu.miu.cs.cs544.repository.AppointmentRepository;
import edu.miu.cs.cs544.service.AppointmentService;
import edu.miu.cs.cs544.service.ReservationService;
import edu.miu.cs.cs544.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private UserService userService;

    @GetMapping("/getAppoints/")
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/user/{userId}/reserve/{appointId}")
    public String reserveAppointment(@PathVariable int userId, @PathVariable int appointId) {
        User user = userService.getUserById(userId);
        Reservation reservation = new Reservation(Status.PENDING, LocalDate.now(), user);
        reservationService.createReservation(reservation);
        return "redirect:/";
    }

    @PostMapping("/user/{userId}/reserve/{appointId}")
    public void approveReservation(@PathVariable int userId, @PathVariable int appointId) {
        User user = userService.getUserById(userId);
        Reservation reservation = new Reservation(Status.ACCEPTED, LocalDate.now(), user);
        reservationService.approveReservation(reservation);
    }

}
