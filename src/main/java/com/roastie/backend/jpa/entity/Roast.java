package com.roastie.backend.jpa.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Roast {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotNull(message = "Name cannot be null")
	private String name;
	
	@NotNull(message = "Bean cannot be null")
	private String bean;
	
	private String comment;
	
	@Min(value= 1, message = "Rating should be at least 1")
	@Max(value= 5, message = "Rating should be at most 5")
	private int rating;
	
	@NotNull
	private Date dateTime;
	
	@ElementCollection
	@OneToMany(cascade = CascadeType.ALL , orphanRemoval = true)
	@NotNull(message = "No data available")
	private List<Measurement> data;
	
	

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public List<Measurement> getData() {
		return data;
	}

	public void setData(List<Measurement> data) {
		this.data = data;
	}

	public String getBean() {
		return bean;
	}

	public void setBean(String bean) {
		this.bean = bean;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
	

}
