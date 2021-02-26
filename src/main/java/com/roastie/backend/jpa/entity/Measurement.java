package com.roastie.backend.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Measurement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	private double time;
	private double temperature;
	
	public Measurement() {
		
	}
	
	public Measurement(double time, double temperature) {
		super();
		this.time = time;
		this.temperature = temperature;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	
	
	

}
