package edu.miu.cs.cs544.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs.cs544.domain.Appointment;
import edu.miu.cs.cs544.domain.User;
import edu.miu.cs.cs544.repository.AppointmentRepository;

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
	public void updateAppointment(int id) {
		Appointment appt = appointmentRepository.findById(id).orElse(null);
		if (appt != null) {
			appointmentRepository.save(appt);
		}
	}
	@Override
	public void updateAppointment(int id, Appointment appointment) {
		appointment.setId(id);
//		if (appt != null) {
			appointmentRepository.save(appointment);
//		}
	}

	@Override
	public void deleteAppointment(int id) {
			appointmentRepository.deleteById(id);
	}
}
