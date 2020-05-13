package edu.miu.cs.cs544.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.miu.cs.cs544.domain.Appointment;

public interface AppointmentService {
	public void createAppointment(Appointment appointment);
	public List<Appointment> getAllAppointments();
	public Appointment getAppointmentById(int id);
	public void updateAppointment(int id);
	public void updateAppointment(int id, Appointment appointment);
	public void deleteAppointment(int id);
}
