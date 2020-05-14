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
	private String date;
	private String time;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private User consumer;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Appointment appointment;
	
	public Reservation() {
		super();
	}


	public Reservation(Status status, String date, String time, User consumer, Appointment appointment) {
		super();
		this.status = status;
		this.date = date;
		this.time = time;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
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
