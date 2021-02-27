package com.roastie.backend.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import javax.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import de.re.easymodbus.modbusclient.ModbusClient;

@Service
public class ScheduledPushMessages {
	
	@Value("${modbus.address}")
	private String modbusUrl;
	
	@Value("#{${register.addresses}}")
	private Map<String, Integer> registerMap;
	
	@Autowired
	SimpMessagingTemplate simpMessagingTemplate;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	ModbusClient mbclient;

	public ScheduledPushMessages() {
		try {
			
			mbclient = new ModbusClient(modbusUrl, 502);
			mbclient.Connect();
			this.logger.info("Modbus Client connected!");
			
			
		}  catch (Exception e) {
		}
	}
    @Scheduled(fixedRate = 500)
    public void sendMessage() {
    	ArrayList<SensorMeasurement> measures = new ArrayList<SensorMeasurement>();
		//HashMap<String, Double> measurements = new HashMap<String, Double>();

			for(Map.Entry m:registerMap.entrySet()){
				double value;
				try {
					int[] result = mbclient.ReadInputRegisters((int) m.getValue(), 3);
					value = (double) result[2]/10;
				} catch (Exception e) {
					value = -999.99;
					e.printStackTrace();
					
				}
			    measures.add(new SensorMeasurement(m.getKey().toString(), value));
			}
    	//logger.info("Send Temperature-Measurement: " + this.getTemperature());
        simpMessagingTemplate.convertAndSend("/temperature/stream",measures);
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
    
}