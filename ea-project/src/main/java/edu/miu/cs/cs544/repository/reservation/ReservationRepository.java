package edu.miu.cs.cs544.repository.reservation;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.miu.cs.cs544.domain.reservation.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
