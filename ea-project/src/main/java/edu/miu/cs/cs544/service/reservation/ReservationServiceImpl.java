package edu.miu.cs.cs544.service.reservation;

import edu.miu.cs.cs544.domain.reservation.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

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
