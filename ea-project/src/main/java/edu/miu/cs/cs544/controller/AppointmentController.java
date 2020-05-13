package edu.miu.cs.cs544.controller;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import edu.miu.cs.cs544.domain.Appointment;
import edu.miu.cs.cs544.domain.User;
import edu.miu.cs.cs544.service.AppointmentService;
import edu.miu.cs.cs544.service.UserService;

import java.util.List;
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
	public ResponseEntity<Appointment> createAppoinment(@PathVariable int id, @RequestParam("date") String date, 
							@RequestParam("location") String location, @RequestParam("time") String time) {
		try {
			User user = userService.getUserById(id);
			  Appointment appointment = new Appointment(date, time, location);
			if(user != null) {
				appointment.setProvider(user);
				appointmentService.createAppointment(appointment);
				return ResponseEntity.ok().body(appointment);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(null);
		}
	}

	@GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Appointment>> getAllAppointments() throws ParseException {
		try {
			return ResponseEntity.ok().body(appointmentService.getAllAppointments());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

	@GetMapping(value= "/{id}")
	public ResponseEntity<Appointment> getAppointmentById(@PathVariable int id) {
		try {
			return ResponseEntity.ok().body(appointmentService.getAppointmentById(id));
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
	@DeleteMapping
	public ResponseEntity<Appointment> deleteAppointment(@RequestParam int id) {
		try {
			appointmentService.deleteAppointment(id);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
		}
		return ResponseEntity.ok().body(null);
	}
}
