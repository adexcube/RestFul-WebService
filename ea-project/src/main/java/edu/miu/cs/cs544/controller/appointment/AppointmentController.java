package edu.miu.cs.cs544.controller.appointment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.cs544.domain.appointment.Appointment;
import edu.miu.cs.cs544.service.appointment.AppointmentService;
<<<<<<< HEAD:ea-project/src/main/java/edu/miu/cs/cs544/controller/appointment/AppointmentController.java
=======

>>>>>>> f45fd4918833496944d5b3beb602930993c734d2:ea-project/src/main/java/edu/miu/cs/cs544/controller/appt_reservation/AppointmentController.java

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
