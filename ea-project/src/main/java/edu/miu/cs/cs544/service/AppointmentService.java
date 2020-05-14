package edu.miu.cs.cs544.service;

import java.util.List;

import edu.miu.cs.cs544.domain.Appointment;

public interface AppointmentService {
	public void createAppointment(Appointment appointment);
	public List<Appointment> getAllAppointments();
	public Appointment getAppointmentById(int id);
	public void deleteAppointment(int id);
}
