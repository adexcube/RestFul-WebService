package edu.miu.cs.cs544.controller;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import edu.miu.cs.cs544.domain.Appointment;
import edu.miu.cs.cs544.domain.User;
import edu.miu.cs.cs544.service.AppointmentService;
import edu.miu.cs.cs544.service.Response;
import edu.miu.cs.cs544.service.UserService;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;

	@Autowired
	UserService userService;

	@ResponseBody
	//create appointment controller method
	@PostMapping(value = "createappt/{id}")
	public void createAppoinment(@PathVariable int id, @RequestParam("date") String date, @RequestParam("location") String location, @RequestParam("time") String time) {
		try {
			Appointment appointment = new Appointment(date, time, location);
			User user = userService.getUserById(id);
			if(user != null) {
				appointment.setProvider(user);
				appointmentService.createAppointment(appointment);
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getAllAppointments() {
		try {
			return new Response(200, "successful", appointmentService.getAllAppointments());
		} catch (Exception e) {
			return new Response(400, e.getMessage(), null);

		}
	}

}
