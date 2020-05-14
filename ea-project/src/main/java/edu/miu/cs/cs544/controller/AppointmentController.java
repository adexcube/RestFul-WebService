package edu.miu.cs.cs544.controller;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import edu.miu.cs.cs544.domain.Appointment;
import edu.miu.cs.cs544.domain.Role;
import edu.miu.cs.cs544.domain.User;
import edu.miu.cs.cs544.service.AppointmentService;
import edu.miu.cs.cs544.service.UserService;

import java.util.List;
import java.util.stream.Collectors;
import java.text.ParseException;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	UserService userService;

	@PostMapping(value = "/new/{id}")
	public ResponseEntity createAppoinment(@PathVariable int id, @RequestParam("date") String date, 
							@RequestParam("location") String location, @RequestParam("time") String time) {
		System.out.println(id);
		System.out.println(date);
		System.out.println(location);
		System.out.println(time);
		try {
			User user = userService.getUserById(id);
			  Appointment appointment = new Appointment(date, time, location);
			if(user != null) {
				List<Integer> roles = user.getRoles().stream().map(r -> r.getRoleid()).collect(Collectors.toList());

				if(roles.contains(Role.CHECKER.name())) {
					appointment.setProvider(user);
					appointmentService.createAppointment(appointment);
					return ResponseEntity.ok().body("Succeed");
				} else {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Access denied");
				}
				
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
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
	public ResponseEntity deleteAppointment(@RequestParam int id) {
		try {
			appointmentService.deleteAppointment(id);
			return ResponseEntity.ok().body(null);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
		}
	}
}
