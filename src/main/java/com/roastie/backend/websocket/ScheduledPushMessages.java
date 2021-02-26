package com.roastie.backend.websocket;

import java.io.IOException;

import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import de.re.easymodbus.modbusclient.ModbusClient;

@Service
public class ScheduledPushMessages {
	
	@Autowired
	SimpMessagingTemplate simpMessagingTemplate;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	ModbusClient mbclient = new ModbusClient("192.168.1.250", 502);
	private double temperature;

	public ScheduledPushMessages() {
		try {
			mbclient.Connect();
			this.logger.info("Modbus Client connected!");
		}  catch (Exception e) {
		}
	}
    @Scheduled(fixedRate = 500)
    public void sendMessage() {
		try {
			int[] result = mbclient.ReadInputRegisters(1000, 3);
			this.setTemperature((double) result[2]/10);

		} catch (Exception e) {
			this.setTemperature(-999);
			e.printStackTrace();
		}

    	logger.info("Send Temperature-Measurement: " + this.getTemperature());
        simpMessagingTemplate.convertAndSend("/temperature/stream", 
          this.getTemperature());
    }
    
    @PreDestroy
    public void destroy() {
    	try {
			this.mbclient.Disconnect();
			this.logger.info("Modbus Client disconnected!");
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }
    
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
    
}