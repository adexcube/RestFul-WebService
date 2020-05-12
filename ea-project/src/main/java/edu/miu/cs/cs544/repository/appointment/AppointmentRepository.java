package edu.miu.cs.cs544.repository.appointment;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.miu.cs.cs544.domain.appointment.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}
