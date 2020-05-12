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
    }

    @Override
    public List<Reservation> getAllReservations() {
        return null;
    }

    @Override
    public Reservation getReservationById(int id) {
        return null;
    }


}
