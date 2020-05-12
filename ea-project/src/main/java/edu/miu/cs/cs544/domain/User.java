package edu.miu.cs.cs544.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotEmpty
	private String firstname;
	@NotEmpty
	private String lastname;
	@Email
	@NotEmpty
	private String email;
	private String gender;
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
	
//	@OneToMany(cascade=CascadeType.ALL)
//	@JoinColumn(name="role_id")
//	private UserRole role;
	
//	@OneToMany(mappedBy="provider")
//	@JsonBackReference
//	private List<Appointment> appointments;
	
//	@OneToMany(mappedBy="consumer")
//	@JsonBackReference
//	private List<Reservation> reservations;
	
	public User() {
		super();
	}

	public User(String firstname, String lastname, @Email String email, String gender, String username, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.gender = gender;
		this.username = username;
		this.password = password;
	}
	
//	public void addAppointment(Appointment appointment) {
//		appointments.add(appointment);
//	}
//	
//	public void addReservation(Reservation reservation) {
//		reservations.add(reservation);
//	}
//
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public List<Appointment> getAppointments() {
//		return appointments;
//	}
//
//	public void setAppointments(List<Appointment> appointments) {
//		this.appointments = appointments;
//	}
//
//	public List<Reservation> getReservations() {
//		return reservations;
//	}
//
//	public void setReservations(List<Reservation> reservations) {
//		this.reservations = reservations;
//	}
	
}
