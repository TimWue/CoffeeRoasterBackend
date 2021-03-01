package com.roastie.backend.jpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class MultipleMeasurement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@ElementCollection
	@OneToMany(cascade = CascadeType.ALL , orphanRemoval = true)
	private List<Measurement> measurements;

	public MultipleMeasurement() {
		
	}
	
	public MultipleMeasurement(List<Measurement> measurements) {
		super();
		this.measurements = measurements;
	}

	public List<Measurement> getMeasurements() {
		return measurements;
	}

	public void setMeasurements(List<Measurement> measurements) {
		this.measurements = measurements;
	}
	
	
	
	
	
	

}
