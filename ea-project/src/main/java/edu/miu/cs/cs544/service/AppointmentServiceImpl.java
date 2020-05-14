package edu.miu.cs.cs544.service;

import java.util.List;

import edu.miu.cs.cs544.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs.cs544.repository.AppointmentRepository;

import javax.annotation.PostConstruct;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Override
	public void createAppointment(Appointment appointment) {
		appointmentRepository.save(appointment);
	}

	@Override
	public List<Appointment> getAllAppointments() {
		return appointmentRepository.findAll();
	}

	@Override
	public Appointment getAppointmentById(int id) {
		return appointmentRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteAppointment(int id) {
			appointmentRepository.deleteById(id);
	}

//	@PostConstruct
//	public void generate() {
//		Util util = new Util();
//		Util.generateAppointmentsForLocation();
//	}
}
