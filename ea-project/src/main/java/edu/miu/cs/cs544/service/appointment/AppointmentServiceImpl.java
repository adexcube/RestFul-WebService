package edu.miu.cs.cs544.service.appointment;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs.cs544.domain.appointment.Appointment;
import edu.miu.cs.cs544.repository.appointment.AppointmentRepository;

@Service
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
//


}
