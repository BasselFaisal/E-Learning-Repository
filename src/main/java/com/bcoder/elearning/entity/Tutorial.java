package com.bcoder.elearning.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="tutorial")
public class Tutorial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String sku ;
	private String name ;
	private String description ;
	private double unitprice ;
	private String imageurl ;
	private boolean active ;
	private int unitsinstock ;
	private Date datecreated ;
	private Date lastupdated ;
	
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private TutorialCategory category;
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(name = "cart_tutorials", joinColumns = @JoinColumn(name="tutorial_id"),inverseJoinColumns = @JoinColumn(name="cart_id"))
	private Cart cart;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(name = "user_tutorials", joinColumns = @JoinColumn(name="tutorial_id"),inverseJoinColumns = @JoinColumn(name="user_id"))
	private User user ;

	public Tutorial() {
	}

	public Tutorial(String sku, String name, String description, double unitprice, String imageurl, boolean active,
			int unitsinstock, Date datecreated, Date lastupdated) {
		this.sku = sku;
		this.name = name;
		this.description = description;
		this.unitprice = unitprice;
		this.imageurl = imageurl;
		this.active = active;
		this.unitsinstock = unitsinstock;
		this.datecreated = datecreated;
		this.lastupdated = lastupdated;
	}
	
	public Tutorial(int id, String sku, String name, String description, double unitprice, String imageurl,
			boolean active, int unitsinstock, Date datecreated, Date lastupdated, TutorialCategory category) {
		this.id = id;
		this.sku = sku;
		this.name = name;
		this.description = description;
		this.unitprice = unitprice;
		this.imageurl = imageurl;
		this.active = active;
		this.unitsinstock = unitsinstock;
		this.datecreated = datecreated;
		this.lastupdated = lastupdated;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public String getSku() {
		return sku;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public double getUnitprice() {
		return unitprice;
	}

	public String getImageurl() {
		return imageurl;
	}

	public boolean isActive() {
		return active;
	}

	public int getUnitsinstock() {
		return unitsinstock;
	}

	public Date getDatecreated() {
		return datecreated;
	}

	public Date getLastupdated() {
		return lastupdated;
	}

	public TutorialCategory getCategory() {
		return category;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setUnitprice(double unitprice) {
		this.unitprice = unitprice;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setUnitsinstock(int unitsinstock) {
		this.unitsinstock = unitsinstock;
	}

	public void setDatecreated(Date datecreated) {
		this.datecreated = datecreated;
	}

	public void setLastupdated(Date lastupdated) {
		this.lastupdated = lastupdated;
	}

	public void setCategory(TutorialCategory category) {
		this.category = category;
	}	

}
