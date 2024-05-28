package com.boot.entity;

import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="micro_users")
public class User {
	
	@Id
	private int id;
	private String name;
	private String email;
	
	@Transient
	private List<Rating> ratings;
	
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	
	

}
