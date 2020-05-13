package edu.miu.cs.cs544.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.miu.cs.cs544.domain.Reservation;
import edu.miu.cs.cs544.domain.Status;
import edu.miu.cs.cs544.repository.ReservationRepository;
import edu.miu.cs.cs544.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs.cs544.domain.Appointment;
import edu.miu.cs.cs544.domain.User;
import edu.miu.cs.cs544.repository.AppointmentRepository;

import javax.annotation.PostConstruct;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class AppointmentServiceImpl implements AppointmentService {

	public SimpleDateFormat _12HourSDF = new SimpleDateFormat("hh:mm a");
	public SimpleDateFormat _24HourSDF = new SimpleDateFormat("HH:mm");


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




	//Schedule task at 12AM for the next day
//    @Scheduled(cron = "0 0 0 * * ?")
	@PostConstruct
	public void generateAppointmentsForLocation() {
		String location = "Verill Hall";
		LocalDate date = LocalDate.now();
		String d = date.getMonthValue() + "/" + date.getDayOfMonth() + "/" + date.getYear();
		User checker = new User("Checker", "Doe", "johndoe@gmail.com", "Male", "John", "123");

		List<String> starts = null;
		try {
			starts = generateAppointmentStartTimes();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		for (String s : starts) {
			User user = new User("User-"+s, "Doe", "johndoe@gmail.com", "Male", "John", "123");
			Appointment appointment = new Appointment(d, s, location);
			appointment.setProvider(checker);
			System.out.println(appointment.toString());
			createAppointment(appointment);
			Reservation reservation = new Reservation(Status.ACCEPTED, new Date().toString(), user, appointment);
			reservationService.createReservation(reservation);
//            appointmentRepository.save(appointment);
		}
	}


	public List<String> generateAppointmentStartTimes() throws ParseException {
		List<String> t = new ArrayList<>();
		LocalTime starttime = LocalTime.of(8, 30);
		for(int i = 1 ; i <= 15; i++) {
			starttime = starttime.plusMinutes(30);
			Date _24HourDt = _24HourSDF.parse(String.valueOf(starttime));
			t.add(_12HourSDF.format(_24HourDt));
		}
		return t;
	}

















}
