package edu.miu.cs.cs544.domain;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reservation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Status status;
	private String dateAndTime;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private User consumer;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Appointment appointment;
	
	public Reservation() {
		super();
	}


	public Reservation(Status status, String dateAndTime, User consumer, Appointment appointment) {
		super();
		this.status = status;
		this.dateAndTime = dateAndTime;
		this.consumer = consumer;
		this.appointment = appointment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(String dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public User getConsumer() {
		return consumer;
	}

	public void setConsumer(User consumer) {
		this.consumer = consumer;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	
}
