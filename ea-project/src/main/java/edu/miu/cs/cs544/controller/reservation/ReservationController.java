package edu.miu.cs.cs544.controller.reservation;

import edu.miu.cs.cs544.domain.reservation.Reservation;
import edu.miu.cs.cs544.domain.user.User;
import edu.miu.cs.cs544.repository.appointment.AppointmentRepository;
import edu.miu.cs.cs544.service.reservation.ReservationService;
import edu.miu.cs.cs544.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/getAppoints/")
    public String getAllAppointments() {
//        return appointmentRepository.getAll();
        return "";
    }

    @GetMapping("/user/{userId}/reserve/{appointId}")
    public String reserveAppointment(@PathVariable int userId, @PathVariable int appointId) {
        User user = userService.getUserById(userId);
        Reservation reservation = new Reservation(LocalDate.now(), user);
        reservationService.createReservation(reservation);
        return "redirect:getAppoints/";
    }

<<<<<<< HEAD
=======

>>>>>>> 3cfd9d0171dcab51ac0cc722c32bf6b9603fd40f
}
