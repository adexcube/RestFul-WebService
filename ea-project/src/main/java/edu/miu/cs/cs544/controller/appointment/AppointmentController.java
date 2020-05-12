package edu.miu.cs.cs544.controller.appointment;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import edu.miu.cs.cs544.domain.appointment.Appointment;
import edu.miu.cs.cs544.domain.user.User;
import edu.miu.cs.cs544.service.appointment.AppointmentService;
import edu.miu.cs.cs544.service.response.Response;
import edu.miu.cs.cs544.service.user.UserService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;
<<<<<<< HEAD
	@Autowired UserService userService;
	
	@PostMapping(value="createappt/{id}")
	public void createAppoinment(@PathVariable int id, @RequestBody Appointment appointment) {
		try {
			User user = userService.getUserById(id);
			appointment.setProvider(user);
			appointmentService.createAppointment(appointment);
		} catch(Exception e) {
			e.printStackTrace();
		}
=======

	public void createAppoinment(Appointment appointment) {
		appointmentService.createAppointment(appointment);
>>>>>>> 617526f3c1e236cc93ba514de262fb4f175294a4
	}
	
	@GetMapping(value="all", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getAllAppointments() {
		try {
			return new Response(200, "successful", appointmentService.getAllAppointments());
		}catch(Exception e) {
			return new Response(400, e.getMessage(), null);
			
		}
	}


}
