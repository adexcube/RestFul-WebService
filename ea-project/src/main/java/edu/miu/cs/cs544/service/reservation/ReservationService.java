package edu.miu.cs.cs544.service.reservation;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.miu.cs.cs544.domain.reservation.Reservation;


@Service
public interface ReservationService {
	public void createReservation(Reservation reservation);
	public List<Reservation> getAllReservations();
	public Reservation getReservationById(int id);
}
