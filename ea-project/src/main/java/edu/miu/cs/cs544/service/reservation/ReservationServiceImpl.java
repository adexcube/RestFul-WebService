package edu.miu.cs.cs544.service.reservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs.cs544.domain.reservation.Reservation;
import edu.miu.cs.cs544.repository.reservation.ReservationRepository;


@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;
	
	@Override
	public void createReservation(Reservation reservation) {
		reservationRepository.save(reservation);
	}

	@Override
	public List<Reservation> getAllReservations() {
		return reservationRepository.findAll();
	}

	@Override
	public Reservation getReservationById(int id) {
		return reservationRepository.findById(id).orElse(null);
	}

	@Override
	public void approveReservation(Reservation reservation) {
		reservationRepository.save(reservation);
	}

}
