package com.ecommerce;

import java.math.BigDecimal;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="eproduct")
public class EProduct {
	
	@Id @GeneratedValue
	@Column(name= "ID")
	private long ID;
	
	@Column(name= "name")
	private String name;
	
	@Column(name= "price")
	private BigDecimal price;
	
	@Column(name= "date_added")
	private Date dateAdded;
	

	public EProduct() {

	}

	public EProduct(long id, String name, BigDecimal price, Date dateAdded) {
		this.ID = id;
		this.name = name;
		this.price = price;
		this.dateAdded = dateAdded;
	}
	
	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	
}
