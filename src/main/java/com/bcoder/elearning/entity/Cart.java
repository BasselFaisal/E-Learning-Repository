package com.bcoder.elearning.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
	private User user;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "cart_tutorials", joinColumns = @JoinColumn(name="cart_id"),inverseJoinColumns = @JoinColumn(name="tutorial_id"))
	private Set<Tutorial> tutorials;

	
	public Cart() {
	}

	public Cart(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Tutorial> getTutorials() {
		return tutorials;
	}

	public void setTutorials(Set<Tutorial> tutorials) {
		this.tutorials = tutorials;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", user=" + user + "]";
	}

}

