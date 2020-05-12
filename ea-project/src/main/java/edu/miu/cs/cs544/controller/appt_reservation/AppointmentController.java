package edu.miu.cs.cs544.controller.appt_reservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.cs544.domain.appt_reservation.Appointment;
import edu.miu.cs.cs544.service.appt_reservation.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;
	
	public void createAppoinment(Appointment appointment) {
		appointmentService.createAppointment(appointment);
	}
	
	@GetMapping(value="all")
	public List<Appointment> getAllAppointments() {
		return appointmentService.getAllAppointments();
	}
}
