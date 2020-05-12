package edu.miu.cs.cs544.service.reservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs.cs544.domain.reservation.Reservation;
import edu.miu.cs.cs544.repository.reservation.ReservationRepository;


@Service
public class ReservationServiceImpl implements ReservationService {

<<<<<<< HEAD
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

=======
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

>>>>>>> f45fd4918833496944d5b3beb602930993c734d2
}
