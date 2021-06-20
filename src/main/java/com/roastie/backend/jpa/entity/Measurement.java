/*
*
* com.roastie.backend.jpa.entity
*
* EXAMPLE DISCLAIMER
* COPYRIGHT (C) 2021 TimWue
*
*/
package com.roastie.backend.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Class representing measurments of sensor
 */
@Entity
public class Measurement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	private double time;
	private double temperature;
	
	public Measurement() {
	// for jpa
	}
	
	public Measurement(double time, double temperature) {
		super();
		this.time = time;
		this.temperature = temperature;
	}

	/**
	 * Set the time
	 * @param time unix timestamp of measurement
	 */
	public void setTime(double time) {
		this.time = time;
	}

	/**
	 * Set the temperature of the measurement
	 * @param temperature temperature in degree celsius of measurement
	 */
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getTemperature() {
		return temperature;
	}

	public double getTime() {
		return time;
	}
}
