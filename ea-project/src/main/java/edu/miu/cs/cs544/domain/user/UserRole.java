package edu.miu.cs.cs544.domain.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class UserRole {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String roleName;
	
	@OneToOne(mappedBy="role")
	@JsonBackReference
	private User user;
	
	public UserRole() {
		super();
	}

	public UserRole(String roleName) {
		super();
		this.roleName = roleName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
