package com.roastie.backend.websocket;

import java.util.Date;

public class SensorMeasurement {
	
	private String sensorName;
	private long time;
	private double value;
	
	public SensorMeasurement(String sensorName, double value) {
		super();
		this.sensorName = sensorName;
		this.time = (new Date()).getTime();
		this.value = value;
	}

	public String getSensorName() {
		return sensorName;
	}

	public long getTime() {
		return time;
	}

	public double getValue() {
		return value;
	}

	
	

	

}
