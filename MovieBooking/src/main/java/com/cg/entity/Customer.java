package com.cg.entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="customers")
@DynamicUpdate
@DynamicInsert
public class Customer extends User {
	
	@Column(name="username")
	private String username;
	
	@Column(name="email",unique=true,nullable=false)
	private String email;
	
	
	@OneToMany(mappedBy="customer")
	@Autowired
	private Set<Booking> booking;
	
	@OneToMany(mappedBy="customer")
	@Autowired
	private Set<Ticket> ticket;
	
	@Column(name="contact")
	private String contact;

	
	
	public Customer() {
		super();
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Set<Booking> getBookings() {
		return booking;
	}

	public void setBookings(Set<Booking> booking) {
		booking = booking;
	}

	public Set<Ticket> getBooking() {
		return ticket;
	}

	public void setBooking(Set<Ticket> ticket) {
		ticket = ticket;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
	
	

}