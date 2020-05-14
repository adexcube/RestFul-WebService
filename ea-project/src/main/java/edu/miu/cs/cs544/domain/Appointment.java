package edu.miu.cs.cs544.domain;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String date;
	private String time;
	private String location;

	@ManyToOne // (cascade=CascadeType.ALL)
	@JoinColumn(name = "provider_id")
	private User provider;

	@OneToMany(mappedBy = "appointment", cascade = CascadeType.ALL)
	private List<Reservation> reservations;

	public Appointment() {
		super();
	}

	public Appointment(String date, String time, String location) {
		super();
		setDate(date);
		setTime(time);
		this.location = location;
	}

	public Appointment(int id, String date, String time, String location) {
		super();
		setDate(date);
		setTime(time);
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {

		this.date = date;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;

	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public User getProvider() {
		return provider;
	}

	public void setProvider(User provider) {
		this.provider = provider;
	}

	@Override
	public String toString() {
		return "Appointment{" + "id=" + id + ", date=" + date + ", time=" + time + ", location='" + location + '\''
				+ ", provider=" + provider + '}';
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
}
