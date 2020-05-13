package edu.miu.cs.cs544.controller;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import edu.miu.cs.cs544.domain.Appointment;
import edu.miu.cs.cs544.domain.User;
import edu.miu.cs.cs544.service.AppointmentService;
import edu.miu.cs.cs544.service.Response;
import edu.miu.cs.cs544.service.UserService;

import java.util.Arrays;
import java.text.ParseException;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;

	@Autowired
	UserService userService;

	@ResponseBody
	//create appointment controller method
	@PostMapping(value = "new/{id}")
	public Response createAppoinment(@PathVariable int id, @RequestParam("date") String date, 
			@RequestParam("location") String location, @RequestParam("time") String time) {
		try {
			User user = userService.getUserById(id);
			if(user != null) {
				Appointment appointment = new Appointment(date, time, location);
				appointment.setProvider(user);
				appointmentService.createAppointment(appointment);
			} else {
				return new Response(HttpStatus.NOT_FOUND,"User not found...");
			}
		} catch (Exception e) {
			return new Response(HttpStatus.NOT_FOUND,e.getMessage());
		}
		return new Response(HttpStatus.ACCEPTED,"Succed",Arrays.asList("Appointment data"));
	}

	@GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getAllAppointments() throws ParseException {
		try {
			return new Response(200, "successful", appointmentService.getAllAppointments());
		} catch (Exception e) {
			return new Response(400, e.getMessage(), null);

		}
	}
	
	@DeleteMapping//(value = "/{id}")
	public Response DeleteAppointment(@RequestParam int id) {
		try {
			appointmentService.deleteAppointment(id);
		} catch(Exception e) {
			return new Response(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		return new Response(HttpStatus.ACCEPTED,"Succed");
	}
}
