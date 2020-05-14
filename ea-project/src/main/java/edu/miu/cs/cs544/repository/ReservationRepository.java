package edu.miu.cs.cs544.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs.cs544.domain.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    public void removeReservationByStatus();
}
