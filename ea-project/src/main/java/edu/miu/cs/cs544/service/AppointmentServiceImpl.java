package edu.miu.cs.cs544.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.miu.cs.cs544.domain.*;
import edu.miu.cs.cs544.repository.ReservationRepository;
import edu.miu.cs.cs544.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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

	@Autowired
	private ReservationService reservationService;

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


	@Override
	public void updateAppointment(Integer id) {
		Appointment appt = appointmentRepository.findById(id).orElse(null);
		if (appt != null) {
			appointmentRepository.save(appt);
		}
	}













}
