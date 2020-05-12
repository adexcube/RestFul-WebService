package edu.miu.cs.cs544.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.miu.cs.cs544.domain.Reservation;


public interface ReservationService {
	public void createReservation(Reservation reservation);
	public List<Reservation> getAllReservations();
	public Reservation getReservationById(int id);
	public void approveReservation(Reservation reservation);
}
