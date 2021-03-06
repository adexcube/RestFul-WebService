package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.domain.*;
import edu.miu.cs.cs544.repository.AppointmentRepository;
import edu.miu.cs.cs544.service.AppointmentService;
import edu.miu.cs.cs544.service.ReservationService;
import edu.miu.cs.cs544.service.Response;
import edu.miu.cs.cs544.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/{userId}/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private UserService userService;


    @GetMapping("/{appointId}")
    public ResponseEntity reserveAppointment(@PathVariable int userId, @PathVariable int appointId) {
        try {
            User user = userService.getUserById(userId);
            Appointment appointment = appointmentService.getAppointmentById(appointId);

            Reservation reservation = new Reservation(Status.PENDING, LocalDate.now().toString(),
                    LocalTime.now().toString(), user, appointment);
            reservationService.createReservation(reservation);
            return ResponseEntity.status(HttpStatus.OK).body(reservation);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Reservation Failed");
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAllReservations() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(reservationService.getAllReservations());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed");
        }
    }

    @GetMapping
    public ResponseEntity getReservationById (@RequestParam int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(reservationService.getReservationById(id));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed");
        }
    }


    @PostMapping("/{appointId}")
    public ResponseEntity approveReservation(@PathVariable int userId, @PathVariable int appointId) {
        try {
            User user = userService.getUserById(userId);
            List<Integer> ids = user.getRoles().stream().map(UserRole::getRoleid).collect(Collectors.toList());
            if(!ids.contains(Role.CHECKER.getNumVal())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
            Appointment appointment = appointmentService.getAppointmentById(appointId);
            List<Reservation> reservations = appointment.getReservations();
            reservations.get(0).setStatus(Status.ACCEPTED);
            return ResponseEntity.status(HttpStatus.OK).body(reservations);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed To Approve");
        }
    }

//    @PostMapping("/{checkerId}")
//    public Response declineReservation(@PathVariable int userId, @PathVariable int appointId) {
////        try {
//////            User user = userService.getUserById(userId);
//////            Ap
////        }
//
//    }



//            Reservation reservation = new Reservation(Status.ACCEPTED, LocalDate.now().toString(), LocalTime.now().toString(), user, appointment);

//            reservationService.getAllReservations();

//            reservationService.getReservationById()
//            reservationService.approveReservation(reservation);
}
