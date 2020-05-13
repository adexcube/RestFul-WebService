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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
//	@Temporal(TemporalType.DATE)
	private String date;
//	@Temporal(TemporalType.TIME)
	private String time;
	private String location;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="provider_id")
	private User provider;
	
	@OneToMany(mappedBy="appointment")
	private List<Reservation> reservations;
	
//	private static DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,
//			Locale.US);
//	private static DateFormat tf = DateFormat.getTimeInstance(DateFormat.SHORT,
//			Locale.US);
	
	public Appointment() {
		super();
	}

	public Appointment(String date, String time, String location) {
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
//		return df.format(date);
	}

	public void setDate(String date) {
//		try {
//			this.date = df.parse(date);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		this.date = date;
	}

	public String getTime() {
		return this.time;
//		return tf.format(time);
	}

	public void setTime(String time) {
		this.time = time;
//		try {
//			this.time = tf.parse(time);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
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
		return "Appointment{" +
				"id=" + id +
				", date=" + date +
				", time=" + time +
				", location='" + location + '\'' +
				", provider=" + provider +
				'}';
	}
}
