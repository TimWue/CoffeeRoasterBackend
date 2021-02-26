package com.roastie.backend.websocket;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.concurrent.ThreadLocalRandom;

import de.re.easymodbus.exceptions.ModbusException;
import de.re.easymodbus.modbusclient.ModbusClient;

public class TemperatureMeasurement {
	//private double temperature = 0.05;
	private double temperature;
	/*= 
			ThreadLocalRandom.current().nextDouble(20.0, 300.0);
*/
	
	public TemperatureMeasurement() {
		ModbusClient mbclient = new ModbusClient("192.168.1.250", 502);
		try {
			mbclient.Connect();
			int[] result = mbclient.ReadInputRegisters(1000, 3);
			this.temperature = (double) result[2]/10;
			System.out.println(this.temperature);
			mbclient.Disconnect();
		} catch (UnknownHostException e) {
			this.temperature =-999;
			//e.printStackTrace();
		} catch (IOException e) {
			this.temperature =-999;
			//e.printStackTrace();
		} catch (ModbusException e) {
			this.temperature =-999;
			//e.printStackTrace();
		} catch (Exception e) {
			this.temperature = -999;
		}
		
	}

	/*
	public TemperatureMeasurement(double temperature) {
		super();
		this.temperature = temperature;
	}*/

	public double getTemperature() {
		return temperature;
	}

	

}
