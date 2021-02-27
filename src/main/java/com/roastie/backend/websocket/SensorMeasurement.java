package com.roastie.backend.websocket;

import java.util.Date;

public class SensorMeasurement {
	
	private String sensorName;
	private Date time;
	private double value;
	
	public SensorMeasurement(String sensorName, double value) {
		super();
		this.sensorName = sensorName;
		this.time = new Date();
		this.value = value;
	}

	public String getSensorName() {
		return sensorName;
	}

	public Date getTime() {
		return time;
	}

	public double getValue() {
		return value;
	}

	
	

	

}
