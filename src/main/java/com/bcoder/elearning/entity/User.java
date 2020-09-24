package com.bcoder.elearning.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private int id;
	private String username;
	private String password;
	
    @OneToOne(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Cart cart;
    
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_tutorials", joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="tutorial_id"))
	private Set<Tutorial> tutorials;
    
		public User() {
	}
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
		
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Set<Tutorial> getTutorials() {
		return tutorials;
	}
	public void setTutorials(Set<Tutorial> tutorials) {
		this.tutorials = tutorials;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

}
