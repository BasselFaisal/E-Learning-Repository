package com.bcoder.elearning.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tutorial_category")
public class TutorialCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String categoryname;
	
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set<Tutorial> products;

	public TutorialCategory() {
	}

	public TutorialCategory(int id, String categoryname) {
		this.id = id;
		this.categoryname = categoryname;
	}

	public int getId() {
		return id;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}	
	
}
