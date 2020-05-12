package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.domain.Appointment;
import edu.miu.cs.cs544.domain.Reservation;
import edu.miu.cs.cs544.domain.Status;
import edu.miu.cs.cs544.domain.User;
import edu.miu.cs.cs544.repository.AppointmentRepository;
import edu.miu.cs.cs544.service.AppointmentService;
import edu.miu.cs.cs544.service.ReservationService;
import edu.miu.cs.cs544.service.Response;
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

    @GetMapping("/")
    public Response getAllAppointments() {
        try {
            return new Response(200, "Success", appointmentService.getAllAppointments());
        } catch (Exception ex) {
            return new Response(500, "Failed To Get Appointment", null);
        }
    }

    @GetMapping("/{userId}/reserve/{appointId}")
    public Response reserveAppointment(@PathVariable int userId, @PathVariable int appointId) {
        try {
            User user = userService.getUserById(userId);
            Reservation reservation = new Reservation(Status.PENDING, LocalDate.now(), user);
            reservationService.createReservation(reservation);
            return new Response(200, "Success", null);
        } catch (Exception ex) {
            return new Response(500, "Reservation Failed", null);
        }
    }

    @PostMapping("/{userId}/reserve/{appointId}")
    public Response approveReservation(@PathVariable int userId, @PathVariable int appointId) {
        try {
            User user = userService.getUserById(userId);
            Reservation reservation = new Reservation(Status.ACCEPTED, LocalDate.now(), user);
            reservationService.approveReservation(reservation);
            return new Response(200, "Success", null);
        } catch (Exception ex) {
            return new Response(500, "Failed To Approve", null);
        }
    }

}
